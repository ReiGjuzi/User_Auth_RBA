package model;

import security.PasswordUtil;
import security.UserPermissions;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserStoreFile {

    private final File USERS_FILE = new File("users.txt");
    private static final int MAX_FAILED_ATTEMPTS = 3;


    public boolean exists(String username) {
        return get(username) != null;
    }

    public User authenticate(String username, String code) {
        if (username == null || code == null) {
            return null;
        }
        User user = get(username);
        if (user == null) {
            return null;
        }
        if (user.isLocked()) {
            return null;
        }
        return PasswordUtil.matches(code, user.getPassword()) ? user : null;
    }

    public User get(String username) {
        try {
            if (!USERS_FILE.exists()) return null;
            Scanner scanner = new Scanner(USERS_FILE);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                User user = parseLine(line);
                if (user != null && user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void seedAdmin() {
        if (!exists("admin")) {
            String hashed = PasswordUtil.hash("1000");
            add(new User("admin", hashed, Role.ADMIN));
        }
    }

    public void add(User user) {
        try(FileWriter writer = new FileWriter(USERS_FILE, true))
        {
            String userData = String.join(",",
                    safe(user.getUsername()),
                    safe(user.getPassword()),
                    user.getRole().name(),
                    safe(user.getFirstName()),
                    safe(user.getLastName()),
                    safe(user.getAge()),
                    safe(user.getGender()),
                    safe(user.getSalary()),
                    user.getPermissions().toCompactString(),
                    String.valueOf(user.getFailedAttempts()),
                    String.valueOf(user.isLocked())
            ) + "\n";
            writer.write(userData);
            writer.flush();
        }
        catch (Exception e){
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

    public boolean update(String username, User updatedUser) {
        if (username == null || updatedUser == null) {
            return false;
        }
        List<User> users = loadAll();
        boolean updated = false;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                users.set(i, updatedUser);
                updated = true;
                break;
            }
        }
        if (!updated) {
            return false;
        }
        return writeAll(users);
    }

    public boolean delete(String username) {
        if (username == null) {
            return false;
        }
        List<User> users = loadAll();
        boolean removed = users.removeIf(user -> username.equals(user.getUsername()));
        if (!removed) {
            return false;
        }
        return writeAll(users);
    }

    public Collection<User> getAll() {
        try {
            if (!USERS_FILE.exists()) return new ArrayList<>();

            HashMap<String, User> users = new HashMap<>();
            Scanner scanner = new Scanner(USERS_FILE);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                User user = parseLine(line);
                if (user != null) {
                    users.put(user.getUsername(), user);
                }
            }
            return users.values();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findByCode(String code) {
        try {
            if (!USERS_FILE.exists()) return null;
            String hashed = PasswordUtil.hash(code);
            Scanner scanner = new Scanner(USERS_FILE);
            while (scanner.hasNextLine()) {
                User user = parseLine(scanner.nextLine());
                if (user != null && hashed.equals(user.getPassword())) {
                    return user;
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean codeExists(String code) {
        return findByCode(code) != null;
    }

    public boolean codeInUseByOther(String code, String username) {
        if (code == null || code.isEmpty()) {
            return false;
        }
        try {
            if (!USERS_FILE.exists()) return false;
            String hashed = PasswordUtil.hash(code);
            Scanner scanner = new Scanner(USERS_FILE);
            while (scanner.hasNextLine()) {
                User user = parseLine(scanner.nextLine());
                if (user != null && hashed.equals(user.getPassword())) {
                    if (username == null || !user.getUsername().equals(username)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean recordFailedLogin(String username) {
        if (username == null) {
            return false;
        }
        List<User> users = loadAll();
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                int attempts = user.getFailedAttempts() + 1;
                user.setFailedAttempts(attempts);
                if (attempts >= MAX_FAILED_ATTEMPTS) {
                    user.setLocked(true);
                }
                boolean locked = user.isLocked();
                writeAll(users);
                return locked;
            }
        }
        return false;
    }

    public boolean resetLoginFailures(String username) {
        if (username == null) {
            return false;
        }
        List<User> users = loadAll();
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                user.setFailedAttempts(0);
                user.setLocked(false);
                return writeAll(users);
            }
        }
        return false;
    }

    private User parseLine(String line) {
        String[] p = line.split(",", -1);
        if (p.length < 3) {
            return null;
        }
        Role role = Role.fromStoredName(p[2]);
        if (p.length == 3) {
            return new User(p[0], p[1], role);
        }
        String firstName = p.length > 3 ? p[3] : "";
        String lastName = p.length > 4 ? p[4] : "";
        String age = p.length > 5 ? p[5] : "";
        String gender = p.length > 6 ? p[6] : "";
        String salary = p.length > 7 ? p[7] : "";
        UserPermissions permissions = p.length > 8
                ? UserPermissions.fromCompactString(p[8])
                : UserPermissions.forRole(role);
        int failedAttempts = 0;
        if (p.length > 9) {
            try {
                failedAttempts = Integer.parseInt(p[9]);
            } catch (NumberFormatException ignored) {
                failedAttempts = 0;
            }
        }
        boolean locked = p.length > 10 && Boolean.parseBoolean(p[10]);
        return new User(p[0], p[1], role, firstName, lastName, age, gender, salary, permissions, failedAttempts, locked);
    }

    private List<User> loadAll() {
        try {
            List<User> users = new ArrayList<>();
            if (!USERS_FILE.exists()) {
                return users;
            }
            Scanner scanner = new Scanner(USERS_FILE);
            while (scanner.hasNextLine()) {
                User user = parseLine(scanner.nextLine());
                if (user != null) {
                    users.add(user);
                }
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean writeAll(Collection<User> users) {
        try (FileWriter writer = new FileWriter(USERS_FILE, false)) {
            for (User user : users) {
                String userData = String.join(",",
                        safe(user.getUsername()),
                        safe(user.getPassword()),
                        user.getRole().name(),
                        safe(user.getFirstName()),
                        safe(user.getLastName()),
                        safe(user.getAge()),
                        safe(user.getGender()),
                        safe(user.getSalary()),
                        user.getPermissions().toCompactString(),
                        String.valueOf(user.getFailedAttempts()),
                        String.valueOf(user.isLocked())
                ) + "\n";
                writer.write(userData);
            }
            writer.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}

package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class UserStoreFile {

    private final File USERS_FILE = new File("users.txt");


    public boolean exists(String username) {
        return get(username) != null;
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
                    user.getPermissions().toCompactString()
            ) + "\n";
            writer.write(userData);
            writer.flush();
        }
        catch (Exception e){
            System.out.println("Error writing to file: " + e.getMessage());
        }

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
        return new User(p[0], p[1], role, firstName, lastName, age, gender, salary, permissions);
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}

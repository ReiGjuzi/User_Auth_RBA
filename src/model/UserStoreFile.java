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
                String[] p = scanner.nextLine().split(",");
                if (p.length == 3 && p[0].equals(username)) {
                    return new User(p[0], p[1], Role.valueOf(p[2]));
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void seedAdmin() {
        if (!exists("admin")) {
            String hashed = PasswordUtil.hash("admin");
            add(new User("admin", hashed, Role.ADMIN));
        }
    }

    public void add(User user) {
        try(FileWriter writer = new FileWriter(USERS_FILE, true))
        {
            String userData = user.getUsername() + "," + user.getPassword() + "," + user.getRole().name() + "\n";
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
                String[] p = scanner.nextLine().split(",");
                if (p.length == 3) {
                    users.put(
                            p[0],
                            new User(p[0], p[1], Role.valueOf(p[2]))
                    );
                }
            }
            return users.values();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
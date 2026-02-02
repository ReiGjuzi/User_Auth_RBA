package model;

import java.util.Collection;
import java.util.HashMap;

public class UserStore {
    private final HashMap<String, User> users = new HashMap<>();

    public void seed() {
        add(new User("admin", "admin", Role.ADMIN));
        add(new User("user", "user", Role.USER));
    }

    public boolean exists(String username) {
        return users.containsKey(username);
    }

    public User get(String username) {
        return users.get(username);
    }

    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    public Collection<User> getAll() {
        return users.values();
    }
}
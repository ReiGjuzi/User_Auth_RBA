package model;

import security.UserPermissions;

public class User {
    private  String username;
    private  String password;
    private Role role;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String salary;
    private UserPermissions permissions;
    private int failedAttempts;
    private boolean locked;

    public User(String username, String password, Role role) {
        this(username, password, role, "", "", "", "", "", UserPermissions.forRole(role), 0, false);
    }

    public User(
            String username,
            String password,
            Role role,
            String firstName,
            String lastName,
            String age,
            String gender,
            String salary,
            UserPermissions permissions
    ) {
        this(username, password, role, firstName, lastName, age, gender, salary, permissions, 0, false);
    }

    public User(
            String username,
            String password,
            Role role,
            String firstName,
            String lastName,
            String age,
            String gender,
            String salary,
            UserPermissions permissions,
            int failedAttempts,
            boolean locked
    ) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.permissions = permissions == null ? UserPermissions.forRole(role) : permissions;
        this.failedAttempts = Math.max(0, failedAttempts);
        this.locked = locked;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getSalary() {
        return salary;
    }
    public UserPermissions getPermissions() {
        return permissions;
    }
    public int getFailedAttempts() {
        return failedAttempts;
    }
    public boolean isLocked() {
        return locked;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(Role role) {
        this.role = role;
        if (permissions == null) {
            this.permissions = UserPermissions.forRole(role);
        }
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public void setPermissions(UserPermissions permissions) {
        this.permissions = permissions;
    }
    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = Math.max(0, failedAttempts);
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

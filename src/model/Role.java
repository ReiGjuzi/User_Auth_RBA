package model;

public enum Role {
    ADMIN("Admin", '1'),
    MANAGER("Manager", '2'),
    BOX_OFFICE("Box Office", '3'),
    SALES("Sales", '4'),
    USHER("Usher", '5'),
    SHOW_MANAGER("Show Manager", '6'),
    CUSTOM("Custom", '9'),
    USER("User", '3');

    private final String displayName;
    private final char codePrefix;

    Role(String displayName, char codePrefix) {
        this.displayName = displayName;
        this.codePrefix = codePrefix;
    }

    public String getDisplayName() {
        return displayName;
    }

    public char getCodePrefix() {
        return codePrefix;
    }

    public boolean isAdmin() {
        return this == ADMIN;
    }

    public static Role fromDisplayName(String name) {
        if (name == null) {
            return CUSTOM;
        }
        for (Role role : values()) {
            if (role.displayName.equalsIgnoreCase(name)) {
                return role;
            }
        }
        return fromStoredName(name);
    }

    public static Role fromStoredName(String name) {
        if (name == null) {
            return CUSTOM;
        }
        try {
            return Role.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return CUSTOM;
        }
    }

    public static Role[] selectableRoles() {
        return new Role[] {
                ADMIN,
                MANAGER,
                BOX_OFFICE,
                SALES,
                USHER,
                SHOW_MANAGER,
                CUSTOM
        };
    }
}

package security;

import model.User;

public final class Authorization { // Utility class for checking user permissions

    private Authorization() {
    }
    public static boolean can(User user, Permission permission, AccessLevel required) {
        if (user == null) {
            return false;
        }
        return can(user.getPermissions(), permission, required);
    }

    public static boolean can(UserPermissions permissions, Permission permission, AccessLevel required) {
        AccessLevel level = getLevel(permissions, permission);
        return allows(level, required);
    }

    public static boolean hasAnyAccess(User user, Permission permission) {
        if (user == null) {
            return false;
        }
        return hasAnyAccess(user.getPermissions(), permission);
    }

    public static boolean hasAnyAccess(UserPermissions permissions, Permission permission) {
        return getLevel(permissions, permission) != AccessLevel.NONE;
    }

    public static AccessLevel getLevel(UserPermissions permissions, Permission permission) {
        if (permissions == null || permission == null) {
            return AccessLevel.NONE;
        }
        switch (permission) {
            case CREATE_ORDER:
                return permissions.getCreateOrder();
            case EDIT_ORDER:
                return permissions.getEditOrder();
            case CONFIRM_PURCHASE:
                return permissions.getConfirmPurchase();
            case DELETE_PURCHASE:
                return permissions.getDeletePurchase();
            case EDIT_SHOW_NAME:
                return permissions.getEditShowName();
            case EDIT_SHOW_INFO:
                return permissions.getEditShowInfo();
            case ADD_SHOW:
                return permissions.getAddShow();
            case DELETE_SHOW:
                return permissions.getDeleteShow();
            default:
                return AccessLevel.NONE;
        }
    }

    private static boolean allows(AccessLevel level, AccessLevel required) {
        if (required == AccessLevel.NONE) {
            return true;
        }
        if (level == AccessLevel.READ_WRITE) {
            return required == AccessLevel.READ || required == AccessLevel.WRITE || required == AccessLevel.READ_WRITE;
        }
        if (required == AccessLevel.READ) {
            return level == AccessLevel.READ || level == AccessLevel.WRITE;
        }
        if (required == AccessLevel.WRITE) {
            return level == AccessLevel.WRITE;
        }
        return level == required;
    }
}

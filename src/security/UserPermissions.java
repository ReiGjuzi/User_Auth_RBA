package security;

import model.Role;

public class UserPermissions {
    private AccessLevel createOrder;
    private AccessLevel editOrder;
    private AccessLevel confirmPurchase;
    private AccessLevel deletePurchase;
    private AccessLevel editShowName;
    private AccessLevel editShowInfo;
    private AccessLevel addShow;
    private AccessLevel deleteShow;

    public UserPermissions(
            AccessLevel createOrder,
            AccessLevel editOrder,
            AccessLevel confirmPurchase,
            AccessLevel deletePurchase,
            AccessLevel editShowName,
            AccessLevel editShowInfo,
            AccessLevel addShow,
            AccessLevel deleteShow
    ) {
        this.createOrder = createOrder;
        this.editOrder = editOrder;
        this.confirmPurchase = confirmPurchase;
        this.deletePurchase = deletePurchase;
        this.editShowName = editShowName;
        this.editShowInfo = editShowInfo;
        this.addShow = addShow;
        this.deleteShow = deleteShow;
    }

    public static UserPermissions forRole(Role role) {
        if (role == null) {
            return none();
        }
        switch (role) {
            case ADMIN:
            case MANAGER:
                return full();
            case BOX_OFFICE:
            case USER:
                return new UserPermissions(
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE
                );
            case SALES:
                return new UserPermissions(
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE
                );
            case USHER:
                return new UserPermissions(
                        AccessLevel.READ,
                        AccessLevel.READ,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE
                );
            case SHOW_MANAGER:
                return new UserPermissions(
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.NONE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE,
                        AccessLevel.READ_WRITE
                );
            case CUSTOM:
            default:
                return none();
        }
    }

    public static UserPermissions none() {
        return new UserPermissions(
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE,
                AccessLevel.NONE
        );
    }

    public static UserPermissions full() {
        return new UserPermissions(
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE,
                AccessLevel.READ_WRITE
        );
    }

    public static UserPermissions fromCompactString(String value) {
        if (value == null || value.length() < 8) {
            return none();
        }
        return new UserPermissions(
                AccessLevel.fromCode(value.charAt(0)),
                AccessLevel.fromCode(value.charAt(1)),
                AccessLevel.fromCode(value.charAt(2)),
                AccessLevel.fromCode(value.charAt(3)),
                AccessLevel.fromCode(value.charAt(4)),
                AccessLevel.fromCode(value.charAt(5)),
                AccessLevel.fromCode(value.charAt(6)),
                AccessLevel.fromCode(value.charAt(7))
        );
    }

    public String toCompactString() {
        return new String(new char[] {
                createOrder.getCode(),
                editOrder.getCode(),
                confirmPurchase.getCode(),
                deletePurchase.getCode(),
                editShowName.getCode(),
                editShowInfo.getCode(),
                addShow.getCode(),
                deleteShow.getCode()
        });
    }

    public AccessLevel getCreateOrder() {
        return createOrder;
    }

    public AccessLevel getEditOrder() {
        return editOrder;
    }

    public AccessLevel getConfirmPurchase() {
        return confirmPurchase;
    }

    public AccessLevel getDeletePurchase() {
        return deletePurchase;
    }

    public AccessLevel getEditShowName() {
        return editShowName;
    }

    public AccessLevel getEditShowInfo() {
        return editShowInfo;
    }

    public AccessLevel getAddShow() {
        return addShow;
    }

    public AccessLevel getDeleteShow() {
        return deleteShow;
    }
}

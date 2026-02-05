package model;

public enum AccessLevel {
    NONE('N'),
    READ('R'),
    WRITE('W'),
    READ_WRITE('B');

    private final char code;

    AccessLevel(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static AccessLevel fromCode(char code) {
        switch (Character.toUpperCase(code)) {
            case 'R':
                return READ;
            case 'W':
                return WRITE;
            case 'B':
                return READ_WRITE;
            default:
                return NONE;
        }
    }
}

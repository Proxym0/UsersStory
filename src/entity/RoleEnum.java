package entity;

public enum RoleEnum {
    USER(1), CUSTOMER(1),
    ADMIN(2), PROVIDER(2),
    SUPER_ADMIN(3);

    private final int level;

    RoleEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}


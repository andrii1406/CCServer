package ccserver.entity.jwt;

public enum ERole {

    ROLE_ADMIN,
    ROLE_USER,
    ROLE_GUEST;

    public static ERole fromString(String role) {
        switch (role) {
            case "admin", "ROLE_ADMIN" -> {
                return ROLE_ADMIN;
            }
            case "user", "ROLE_USER" -> {
                return ROLE_USER;
            }
            default -> {
                return ROLE_GUEST;
            }
        }
    }

}

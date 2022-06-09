package com.appiciel.youcoffee.enumeration;

/**
 * The enum Role.
 */
public enum Role {
    /**
     * User role.
     */
    USER("USER"),
    /**
     * Admin role.
     */
    ADMIN("ADMIN");

    /**
     * The Role.
     */
    private String role;

    /**
     * Instantiates a new Role.
     *
     * @param role the role
     */
    Role(String role) {
        this.role = role;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }
}

package ru.job4j.generics;

public class UserRole extends Base {
    private final String role;

    public UserRole(String id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

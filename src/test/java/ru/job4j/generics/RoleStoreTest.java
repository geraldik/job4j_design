package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenUserRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        UserRole result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenAddAndFindThenUserRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        UserRole result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUserRoleIsEDITOR() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        store.add(new UserRole("1", "VIEWER"));
        UserRole result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenReplaceThenUserRoleIsVIEWER() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        store.replace("1", new UserRole("1", "VIEWER"));
        UserRole result = store.findById("1");
        assertThat(result.getRole(), is("VIEWER"));
    }

    @Test
    public void whenNoReplaceUserRoleThenNoChangeUserRole() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        store.replace("10", new UserRole("10", "EDITOR"));
        UserRole result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenDeleteUserRoleThenUserRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        store.delete("1");
        UserRole result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserRoleThenUserRoleIsEDITOR() {
        RoleStore store = new RoleStore();
        store.add(new UserRole("1", "EDITOR"));
        store.delete("10");
        UserRole result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }
}
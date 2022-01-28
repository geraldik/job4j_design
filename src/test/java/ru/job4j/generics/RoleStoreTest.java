package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenUserRolenameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenAddAndFindThenUserRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUserRoleIsEDITOR() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        store.add(new Role("1", "VIEWER"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenReplaceThenUserRoleIsVIEWER() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        store.replace("1", new Role("1", "VIEWER"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("VIEWER"));
    }

    @Test
    public void whenNoReplaceUserRoleThenNoChangeUserRole() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        store.replace("10", new Role("10", "EDITOR"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }

    @Test
    public void whenDeleteUserRoleThenUserRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserRoleThenUserRoleIsEDITOR() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "EDITOR"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole(), is("EDITOR"));
    }
}
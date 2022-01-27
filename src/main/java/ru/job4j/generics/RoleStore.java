package ru.job4j.generics;

public class RoleStore implements Store<UserRole> {

    private final Store<UserRole> store = new MemStore<>();

    @Override
    public void add(UserRole model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, UserRole model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public UserRole findById(String id) {
        return store.findById(id);
    }
}

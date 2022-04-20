package ru.job4j.cache;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input) {
        return false;
    }
}

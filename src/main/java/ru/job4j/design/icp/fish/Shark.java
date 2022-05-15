package ru.job4j.design.icp.fish;

public class Shark implements Fish {
    @Override
    public void eat() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}

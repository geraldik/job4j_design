package ru.job4j.design.icp.control;

public class ControlSoundSystem implements ControlPanel {

    @Override
    public void power() {

    }

    @Override
    public void volumeUp(int unit) {

    }

    @Override
    public void volumeDown(int unit) {

    }

    @Override
    public void menu() {

    }

    @Override
    public void selectChannel() {
        throw new UnsupportedOperationException();
    }
}

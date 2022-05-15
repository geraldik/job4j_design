package ru.job4j.design.icp.vehicle;

import ru.job4j.design.icp.vehicle.Vehicle;

public class Subway implements Vehicle {
    @Override
    public int getPassengerSits() {
        return 0;
    }

    @Override
    public void startEngine() {

    }

    @Override
    public void move() {

    }

    @Override
    public void pumpUb() {
    throw new UnsupportedOperationException();
    }
}

package ru.job4j.design.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControlParkingTest {

    @Test @Ignore
    public void whenTwoPassengerAndOneTruckPlacesThanTwoTrucks() {
        var parking = new ControlParking(2, 1);
        var truck = new Truck(2);
        assertTrue(parking.park(truck));
        assertTrue(parking.park(truck));
        assertFalse(parking.park(truck));
    }

    @Test @Ignore
    public void whenTwoPassengerAndOneTruckPlacesThanOneCarAndTwoTrucks() {
        var parking = new ControlParking(2, 1);
        var car = new PassengerCar();
        var truck = new Truck(2);
        assertTrue(parking.park(car));
        assertTrue(parking.park(truck));
        assertFalse(parking.park(truck));
        assertTrue(parking.park(car));
        assertFalse(parking.park(car));
    }

    @Test @Ignore
    public void whenTwoPassengerAndNoTruckPlacesThanOneTruckAndNoCar() {
        var parking = new ControlParking(2, 0);
        var car = new PassengerCar();
        var truck = new Truck(2);
        assertTrue(parking.park(truck));
        assertFalse(parking.park(car));
        assertFalse(parking.park(truck));
    }

    @Test @Ignore
    public void whenNoPassengerAndOneTruckPlacesThanNoCar() {
        var parking = new ControlParking(0, 1);
        var car = new PassengerCar();
        assertFalse(parking.park(car));
    }
}
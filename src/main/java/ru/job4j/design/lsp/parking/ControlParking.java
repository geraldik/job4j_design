package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса Parking, управляющая сервисом учета парковки машин
 */
public class ControlParking implements Parking {

    private int passengerPlace;
    private int truckPlace;
    List<Car> carList = new ArrayList<>();

    public ControlParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }
}

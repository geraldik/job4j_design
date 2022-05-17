package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса Parking, управляющая сервисом учета парковки машин
 */
public class ControlParking implements Parking {

    private int passengerPlace;
    private int truckPlace;
    private final List<Car> carList;

    public ControlParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
        carList = new ArrayList<>(passengerPlace + truckPlace);
    }

    @Override
    public boolean park(Car car) {
        boolean rsl = false;
        int size = car.carSize();
        if (size == 1) {
            if (passengerPlace != 0) {
                passengerPlace -= size;
                rsl = true;
            }
        } else if (truckPlace != 0) {
            truckPlace--;
            rsl = true;

        } else if (passengerPlace >= size) {
            passengerPlace -= size;
            rsl = true;
        }
        return rsl;
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }
}

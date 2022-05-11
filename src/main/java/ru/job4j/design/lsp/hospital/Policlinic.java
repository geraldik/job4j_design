package ru.job4j.design.lsp.hospital;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;


/**
 * Метод appointment переопределен в наследнике таким образом, что усиливает предусловие данного метода родителя
 */
public class Policlinic extends Hospital {
    public Policlinic(List<Patient> patients) {
        super(patients);
    }

    @Override
    public void appointment(Predicate<Patient> filter, Calendar calendar) {
        if (calendar.get(Calendar.HOUR_OF_DAY) < 9
                || calendar.get(Calendar.HOUR_OF_DAY) > 18) {
            throw new IllegalArgumentException("Время записи не соответствует рабочему графику");
        }
        System.out.println("Пациент: " + find(filter) + "записан на следующую дату: " + calendar);
    }


}

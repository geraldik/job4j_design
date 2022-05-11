package ru.job4j.design.lsp.hospital;


import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Hospital {

    private List<Patient> patients;


    public Hospital(List<Patient> patients) {
        this.patients = patients;
    }

    public Patient find(Predicate<Patient> filter) {
        return null;
    }

    public void appointment(Predicate<Patient> filter, Calendar calendar) {
        if (calendar.get(Calendar.HOUR_OF_DAY) < 8
                || calendar.get(Calendar.HOUR_OF_DAY) > 20) {
            throw new IllegalArgumentException("Время записи не соответствует рабочему графику");
        }
        System.out.println("Пациент: " + find(filter) + "записан на следующую дату: " + calendar);
    }
}

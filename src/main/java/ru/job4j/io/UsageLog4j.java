package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger("UsageLog4j");

    public static void main(String[] args) {
        String name = "Vlad";
        byte bloodGroup = 1;
        char rhFactor = 'm';
        boolean car = true;
        short size = 48;
        int age = 35;
        long salary = 100000;
        float height = 178.5F;
        double weight = 73.3;


        LOG.debug("User info name : {}, bloodGroup : {}, rhFactor : "
                        + " {}, car : {}, size : {}, age : {}, salary : "
                        + "{}, height : {}, weight : {} ",
                name, bloodGroup, rhFactor, car, size, age, salary, height, weight);
    }
}
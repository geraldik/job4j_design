package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;

    private Address address;
    @XmlElementWrapper
    @XmlElement(name = "skill")
    private String[] skills;

    public Employee() {

    }

    public Employee(boolean sex, int age, String name, Address address, String... skill) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.address = address;
        this.skills = skill;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "sex=" + sex
                + ", age=" + age
                + ", name='" + name + '\''
                + ", address=" + address
                + ", skill=" + Arrays.toString(skills)
                + '}';
    }
}

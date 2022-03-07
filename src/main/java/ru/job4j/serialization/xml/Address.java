package ru.job4j.serialization.xml;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
    @XmlAttribute
    private String city;
    @XmlAttribute
    private String street;
    @XmlAttribute
    private String house;

    public Address() {

    }

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", house='" + house + '\''
                + '}';
    }
}

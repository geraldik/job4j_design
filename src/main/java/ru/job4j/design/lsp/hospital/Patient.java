package ru.job4j.design.lsp.hospital;


public class Patient {

    private String name;
    private String surName;
    private String policy;


    public Patient(String name, String surName, String policy) {
        this.name = name;
        this.surName = surName;
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        return "Patient{"
                + "name='" + name + '\''
                + ", surName='" + surName + '\''
                + ", policy='" + policy + '\''
                + '}';
    }
}

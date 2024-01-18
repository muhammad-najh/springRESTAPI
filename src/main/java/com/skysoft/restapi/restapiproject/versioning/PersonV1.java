package com.skysoft.restapi.restapiproject.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }

}

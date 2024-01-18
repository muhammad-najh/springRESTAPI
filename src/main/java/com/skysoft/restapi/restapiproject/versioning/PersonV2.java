package com.skysoft.restapi.restapiproject.versioning;

public class PersonV2 {
 
    private Name name;


    public PersonV2(Name name) {
        this.name = name;
    }
    

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }


}

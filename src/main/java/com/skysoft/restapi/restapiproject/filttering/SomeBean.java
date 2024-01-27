package com.skysoft.restapi.restapiproject.filttering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("SomeBean")

public class SomeBean {

    
//@JsonIgnore
private String item1;
private String item2;
private String item3;


    public SomeBean(String item1, String item2, String item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public String getItem1() {
        return this.item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return this.item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return this.item3;
    }

   

    @Override
    public String toString() {
        return "{" +
            " item1='" + getItem1() + "'" +
            ", item2='" + getItem2() + "'" +
            ", item3='" + getItem3() + "'" +
            "}";
    }




}

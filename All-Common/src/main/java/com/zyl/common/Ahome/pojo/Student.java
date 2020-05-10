package com.zyl.common.Ahome.pojo;

import lombok.Data;

@Data
public class Student {

    private Address address;

    public Student() {
        System.out.println(address.getAd());
    }
}

package com.zyl.common.Ahome.pojo;

import lombok.Data;

@Data
public class Address {
    private String ad;

    public Address() {
        System.out.println(ad);
    }
}

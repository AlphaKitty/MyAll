package com.zyl.common.Ahome.pojo;

import lombok.Data;

import java.util.*;

@Data
public class PropertyUser {

    private String name;
    private String[] friends;
    private List<String> books;
    private Set<String> hobbies;
    private Map<String, String> grade;
    private Address address;
    private Properties info;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", friends=" + Arrays.toString(friends) +
                ", books=" + books +
                ", hobbies=" + hobbies +
                ", grade=" + grade +
                ", address=" + address +
                ", info=" + info +
                '}';
    }
}

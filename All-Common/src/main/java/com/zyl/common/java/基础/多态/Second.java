package com.zyl.common.java.基础.多态;

import com.zyl.common.java.基础.多态.pojo.AImpl;

public abstract class Second extends First {
    @Override
    public void fa() {
        System.out.println("2A");
        super.fa();
    }

    @Override
    public void fb() {
        System.out.println("2B");
    }

    public void fc(AImpl a) {
        System.out.println("2C");
    }
}

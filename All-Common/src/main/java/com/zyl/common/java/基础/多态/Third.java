package com.zyl.common.java.基础.多态;

import com.zyl.common.java.基础.多态.pojo.AImpl;

public class Third extends Second {
    // @Override
    // public void fa() {
    //     System.out.println("3A");
    //     super.fa();
    // }

    public static void main(String[] args) {
        // new Third().fa();
        new Third().fc(new AImpl());
    }
}

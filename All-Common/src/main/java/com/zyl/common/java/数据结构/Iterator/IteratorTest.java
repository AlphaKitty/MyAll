package com.zyl.common.java.数据结构.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add("111");
        list.add("222");
        list.add("333");
        System.out.println(list.iterator().next());
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
            // 会报ConcurrentModificationException
            // list.remove("111");
            iterator.remove();
        }
        for (String s : list) {
            list.remove("111");
        }
    }
}

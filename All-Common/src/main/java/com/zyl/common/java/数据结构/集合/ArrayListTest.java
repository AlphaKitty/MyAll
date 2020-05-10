package com.zyl.common.java.数据结构.集合;

import com.zyl.common.Ahome.pojo.PropertyUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

public class ArrayListTest {
    private String a;

    void setUp() {
        System.out.println(ArrayListTest.this.a);
    }

    public static void main(String[] args) {
        // ArrayList<String> strings = new ArrayList<>();
        // System.out.println(strings.size());
        // // strings.ensureCapacity(3);
        // // System.out.println(strings.size());
        // strings.add("213");
        // strings.add("2131");
        // strings.add("21322");
        // strings.add("213333");
        // strings.stream().filter(s -> s.startsWith("2131")).forEach(System.out::println);
        // strings.add(null);
        // strings.add(null);
        // strings.add(null);
        // for (String string : strings) {
        //     System.out.println(string);
        // }
        // String[] stringss = new String[]{"111",null,null};
        // for (String s : stringss) {
        //     System.out.println(s);
        // }
        // HashMap<String,String> stringHashMap = new HashMap<String,String>();
        // stringHashMap.put(null,"21");
        // stringHashMap.put(null, "2323");
        // System.out.println(stringHashMap.get(null));
        //
        // Vector<String> v = new Vector<>(3,100);
        // v.add(null);
        // v.add(null);
        // v.add(null);
        // v.add(null);
        // System.out.println(v.capacity());
        //
        // new ArrayListTest().setUp();
        //
        // int h = 0;
        // String key = "111";
        // System.out.println((h = key.hashCode()) ^ h >>> 16);
        //
        // System.out.println(10 & 3);
        //

        ArrayListTest arrayListTest = new ArrayListTest();
        // System.out.println(arrayListTest.getIndex("122幅度523"));
        HashMap<String, String> kvs = new HashMap<>();
        kvs.put("123", "123");
        kvs.put("456", "123");
        kvs.put("789", "123");
        kvs.put("147", "123");
        kvs.put("258", "123");
        kvs.put("369", "123");
        kvs.put("3691", "123");
        kvs.put("3692", "123");
        kvs.put("3693", "123");
        kvs.put("3694", "123");
        kvs.put("3695", "123");
        kvs.put("36955", "123");
        kvs.put("336955", "123");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PropertyUser propertyUser = (PropertyUser) context.getBean("user");
        System.out.println(propertyUser.toString());

    }

    // 一个key在HashMap中数组的存放位置由key自己实现的hashCode和HashMap的hash方法共同决定
    public int getIndex(String string) {
        // String拆成字符数组
        char[] s = string.toCharArray();
        // String中的hashCode 把一个字符串转成32个bit的二进制
        // 乘31是因为31=32-1 而乘32也就是左移5位 所以乘31相当于左移5位再减h 这里的优化在编译器里是自动进行的
        int h = 0;
        for (char c : s) {
            h = 31 * h + c;
        }
        System.out.println(Integer.toBinaryString(h));
        // HashMap中get和put中用到的hash算法 hash算法针对的是对象的hashCode二进制值
        // 这里的操作相当于是高16位和低16位按位异或 叫扰动策略 如果直接用hashCode 碰撞概率还是挺高的 扰动策略可以降低碰撞概率
        int hash;
        hash = h ^ (h >>> 16);
        System.out.println(Integer.toBinaryString(hash));
        // HashMap中定位数组元素 这样写是因为hash是int类型 本身有2^31-1之多 数组长度-1在与hash就是把关注点只放到最后几位 返回值就是下标
        return (16 - 1) & hash;
    }
}

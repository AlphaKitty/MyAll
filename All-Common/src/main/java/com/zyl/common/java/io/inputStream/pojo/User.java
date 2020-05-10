package com.zyl.common.java.io.inputStream.pojo;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class User implements Serializable {
    // 标记为transient的变量会在序列化时被忽略 不是忽略字段 而是忽略值
    private transient String id;
    private String name;
    // 这个值被标记为transient 但还是可以通过自定义writeObject和readObject来强制序列化
    private transient String customValue;

    // 这两个方法都是private的 要被执行显然是用到了反射
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        // 这个方法只能在writeObject中使用 作用是执行默认的序列化机制
        outputStream.defaultWriteObject();
        // 然后显式写入需要强制序列化的值
        outputStream.writeObject(customValue);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        // 这个方法只能在readObject中使用 作用是执行默认的反序列化机制
        inputStream.defaultReadObject();
        // 然后显式读取需要强制反序列化的值
        customValue = (String) inputStream.readObject();
    }

}

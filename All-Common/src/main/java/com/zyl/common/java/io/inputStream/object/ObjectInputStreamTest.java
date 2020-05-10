package com.zyl.common.java.io.inputStream.object;

import java.io.*;

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream fileInputStream = new FileInputStream("C:\\Users\\37221\\Desktop\\obj.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ObjectInputStreamTest test = new ObjectInputStreamTest();
        test.readTest(objectInputStream);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
    }

    private void readTest(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        System.out.println(objectInputStream.readBoolean());
        System.out.println(((char) objectInputStream.readByte()));
        System.out.println(((char) objectInputStream.readByte()));
        System.out.println(((char) objectInputStream.readByte()));
        System.out.println(((char) objectInputStream.readByte()));
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readFloat());
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readLong());
        System.out.println(objectInputStream.readObject());
        System.out.println(objectInputStream.readShort());
    }
}

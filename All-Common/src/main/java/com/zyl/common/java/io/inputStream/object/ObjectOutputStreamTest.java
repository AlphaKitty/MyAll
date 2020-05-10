package com.zyl.common.java.io.inputStream.object;

import com.zyl.common.java.io.inputStream.pojo.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStream fileInputStream = new FileOutputStream("C:\\Users\\37221\\Desktop\\obj.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);

        ObjectOutputStreamTest test = new ObjectOutputStreamTest();
        User user1 = new User();
        user1.setId("123");
        user1.setName("zyl");
        user1.setCustomValue("value1");
        User user2 = new User();
        user2.setId("456");
        user2.setName("zzy");
        user2.setCustomValue("value2");
        test.writeTest(objectOutputStream, user1);
        objectOutputStream.close();
        fileInputStream.close();
    }

    private void writeTest(ObjectOutputStream objectOutputStream, User user) throws IOException {
        // objectOutputStream.writeFields();//
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeByte((byte) 'A');
        objectOutputStream.writeBytes("666");
        objectOutputStream.writeChar('c');
        objectOutputStream.writeChars("zh");
        objectOutputStream.writeDouble(372219506.999d);
        objectOutputStream.writeFloat(372219506.999f);
        objectOutputStream.writeInt(45);
        objectOutputStream.writeLong(9999L);
        objectOutputStream.writeObject(user);
        objectOutputStream.writeShort(33);
        // objectOutputStream.writeUnshared();
    }

}

package com.zyl.common.java.io.inputStream.byteArray;

import com.zyl.util.Splitter;
import com.zyl.util.StringAppender;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\37221\\Desktop\\test.txt");
        byte[] source = new byte[100];
        fileInputStream.read(source);
        InputStream inputStream = new ByteArrayInputStream(source);

        ByteArrayInputStreamTest test = new ByteArrayInputStreamTest();
        byte[] temp = new byte[20];
        test.markSupportedTest(inputStream, temp);
        test.available(inputStream);
        test.readTest(inputStream, temp);
        test.skipTest(inputStream, temp);
        inputStream.close();
    }

    private void skipTest(InputStream inputStream, byte[] temp) throws IOException {
        Splitter.split("ByteArrayInputStream#skip(int)");
        int skip = 3;
        inputStream.reset();
        inputStream.read(temp);
        System.out.println(StringAppender.append("重置后读取字符", temp));
        inputStream.skip(skip);
        System.out.println(StringAppender.append("跳过" + skip + "个字符之后读到的字符", ((char) inputStream.read())));
    }

    private void readTest(InputStream inputStream, byte[] temp) throws IOException {
        Splitter.split("ByteArrayInputStream#read()");
        System.out.println(StringAppender.append("读取单个字符", ((char) inputStream.read())));
        Splitter.split("ByteArrayInputStream#read(byte[])");
        inputStream.read(temp);
        System.out.println(StringAppender.append("读取多个字节", temp));
        Splitter.split("ByteArrayInputStream#read(byte[],int,int)");
        inputStream.read(temp, 0, 5);
        System.out.println(StringAppender.append("读取多个字节到指定字节数组位置", temp));
    }

    private void available(InputStream inputStream) throws IOException {
        Splitter.split("ByteArrayInputStream#available()");
        inputStream.reset();
        System.out.println(StringAppender.append("reset之后读到的字符", ((char) inputStream.read())));
        System.out.println("可以看出 对流的读取进度会保存在流状态中 available的返回结果取决于流的当前位置");
        System.out.println(StringAppender.append("剩余可用", inputStream.available()));
    }

    /**
     * ByteArrayInputStream支持mark/reset 但是mark方法的入参在此类中没有什么用
     * mark用来标记字节流中当前读取的位置 下次再读取时会从标记位置开始(前提是用了reset归位方法)
     *
     * @param inputStream
     * @param temp
     * @throws IOException
     */
    private void markSupportedTest(InputStream inputStream, byte[] temp) throws IOException {
        Splitter.split("ByteArrayInputStream#markSupported()");
        System.out.println(StringAppender.append("ByteArrayInputStream支持mark/reset?", inputStream.markSupported()));
        inputStream.read(temp);
        System.out.println(StringAppender.append("一开始读到的字节", temp));
        inputStream.mark(0);
        inputStream.read(temp);
        System.out.println(StringAppender.append("mark之后读到的字节", temp));
        inputStream.reset();
        inputStream.read(temp);
        System.out.println(StringAppender.append("reset之后读到的字节", temp));
        inputStream.read(temp);
        System.out.println(StringAppender.append("mark但是不reset相当于没设置mark", temp));
    }
}

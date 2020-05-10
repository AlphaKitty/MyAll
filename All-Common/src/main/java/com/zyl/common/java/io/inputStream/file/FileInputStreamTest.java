package com.zyl.common.java.io.inputStream.file;

import com.zyl.util.Splitter;
import com.zyl.util.StringAppender;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/**
 *
 */
public class FileInputStreamTest {

	/**
	 * @throws IOException 包括FileNotFoundException和读取字节流过程抛出的IO异常
	 */
	public static void main(String[] args) throws IOException {
		FileInputStreamTest test = new FileInputStreamTest();
		byte[] bytes = new byte[10];
		InputStream inputStream = new FileInputStream("C:\\Users\\37221\\Desktop\\test.txt");

		test.markSupportedTest(inputStream);
		test.available(inputStream);
		test.readTest(inputStream, bytes);
		test.skipTest(inputStream, bytes);
		test.fdTest(inputStream);
		inputStream.close();
	}

	private void fdTest(InputStream inputStream) throws IOException {
		FileDescriptor fd = ((FileInputStream) inputStream).getFD();
		FileChannel channel = ((FileInputStream) inputStream).getChannel();
	}

	/**
	 * 返回剩余字节的大概数量 数量随读出的个数变化
	 *
	 * @param inputStream inputStream
	 * @throws IOException IOException
	 */
	private void available(InputStream inputStream) throws IOException {
		System.out.println(StringAppender.append("available", inputStream.available()));
	}

	/**
	 * 跳过若干个输入流中的字节
	 *
	 * @param inputStream inputStream
	 * @param bytes       bytes
	 * @throws IOException IOException
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	private void skipTest(InputStream inputStream, byte[] bytes) throws IOException {
		Splitter.split("FileInputStream#skip(int)");
		int skip = 3;
		inputStream.skip(skip);
		inputStream.read(bytes);
		System.out.println(StringAppender.append("跳过" + skip + "之后的值", bytes));
	}

	/**
	 * 是否支持mark和reset 类似断点续传
	 *
	 * @param inputStream inputStream
	 */
	private void markSupportedTest(InputStream inputStream) {
		System.out.println(StringAppender.append("FileInputStream支持mark? ", inputStream.markSupported()));
	}

	/**
	 * read和read的重载方法测试
	 * read是读 从调用者中读出 写入到指定对象中
	 *
	 * @param inputStream 输入流根接口
	 * @param bytes       用于存储读到的字节
	 * @throws IOException IOException
	 */
	public void readTest(InputStream inputStream, byte[] bytes) throws IOException {
		Splitter.split("FileInputStream#read()");
		int first = inputStream.read();
		System.out.println(StringAppender.append("read()方法第一次读取返回的单个字符", (char) first));
		int second = inputStream.read();
		System.out.println(StringAppender.append("read()方法又一次读取返回的单个字符", (char) second));

		Splitter.split("FileInputStream#read(byte[])");
		int sum = inputStream.read(bytes);
		System.out.println("read(byte[])方法返回的长度" + sum);
		System.out.println(StringAppender.append("read(byte[])方法读到的字符串", bytes));

		Splitter.split("FileInputStream#read(byte[],int,int)");
		// 对bytes划范围 从off开始写入len个字节 read的含义是从调用方中读出来到目标对象里
		int sum1 = inputStream.read(bytes, bytes.length - 1, 1);
		System.out.println(StringAppender.append("read(byte[],int,int)方法返回的长度", sum1));
		System.out.println(StringAppender.append("read(byte[],int,int)方法读到的字符串", bytes));
	}
}

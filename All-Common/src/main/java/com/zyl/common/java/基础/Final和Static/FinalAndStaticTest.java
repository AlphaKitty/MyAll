package com.zyl.common.java.基础.Final和Static;

/**
 * 测试final和static的执行条件以及执行顺序
 */
public class FinalAndStaticTest {

	// 用static final修饰的内容变得和静态块一样
	private static final String staticFinalStr = new String("staticFinalStr");

	// 只要FinalAndStaticTest被加载到了内存 静态块就会首先被执行(好像除了ClassLoader.loadClass())
	static {
		System.out.println("static block");
	}

	// 只用final修饰的内容只有初始化成对象的时候才会执行 不管有没有用到
	private final String finalStr = new String("finalStr");

	// 普通属性和只用final修饰的属性没什么区别
	private String normalStr = new String("normalStr");

	// 这些个静态修饰的方法不直接被调用就不会执行 不管用什么访问修饰符
	private static void sayHello() {
		System.out.println("private sayHello");
	}

	public static void sayHello1() {
		System.out.println("public sayHello");
	}

	/**
	 * main方法和普通方法一样 也算所属类的一部分
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// FinalAndStaticTest test = new FinalAndStaticTest();
	}
}

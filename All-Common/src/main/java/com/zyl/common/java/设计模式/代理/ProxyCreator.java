package com.zyl.common.java.设计模式.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 静态代理特点:
 *  像中介给房东提供租房服务 中介并不拥有房子 但可以提供一些其他比如看房服务并收取中介费 这样能让房东专注自己的房屋出租功能 增强专一性
 *  中介和房东本质上是"一类出租房子的人" 所以两者需要共同继承一个"出租房子"接口(中介也出租房子 只不过房子是房东的 在代码里表现为房东的租房逻辑被包含在中介租房逻辑里)
 *  房屋中介可以为所有想要出租房子的人提供服务 但它们的工作范围只能局限于出租房屋 而且中介在代码里是手动创建的 如果再想创建一个司机的代理 就又得重新写
 * 动态代理特点:
 *  类似职位介绍所 产出的是代理 和静态代理不同的是代理是用反射自动生成的 原料只有被代理对象
 */
public class ProxyCreator implements InvocationHandler {

    // 目标被代理对象
    private final Object target;

    public ProxyCreator(Object t) {
        this.target = t;
    }

    public static void main(String[] args) {

        // 这两个用的是同一个ProxyCreator 但生产出来的是两个不同接口的实现 也就是放进去的只有纯粹的被代理对象 产出的是哪种接口和具体要做什么都手动指定
        ProxyCreator proxyCreator = new ProxyCreator(new Test());
        ITest proxy = (ITest) proxyCreator.createProxy();
        proxy.doSomething("something");

        ProxyCreator proxyCreator1 = new ProxyCreator(new Test1());
        ITest1 proxy1 = (ITest1) proxyCreator1.createProxy();
        proxy1.doSomeOtherThing();
    }

    private Object createProxy() {
        // 被代理类的类加载器 被代理类的接口 实现了InvocationHandler接口的对象知道要做什么
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before");
        method.invoke(target, args);
        System.out.println("After");
        return null;
    }
}

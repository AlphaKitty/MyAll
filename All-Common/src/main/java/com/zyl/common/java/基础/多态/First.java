package com.zyl.common.java.基础.多态;

import com.zyl.common.java.基础.多态.pojo.A;

/**
 * 多态测试 事实证明:
 *  儿子在在写作业 有道题儿子不会交给了父亲 父亲做出了这道题 然后父亲会顺理成章地接管剩下的作业吗? 不会 父类中再调用其他方法 都会由子类处理
 *  在整个继承链中 方法总是会找"最具体"的实现 也就是亲缘关系最近的实现
 */
public abstract class First {
    public void fa(){
        System.out.println("1A");
        fb();
    }
    public void fb(){
        System.out.println("1B");
    }
    public void fc(A a){
        System.out.println("1C");
    }
}

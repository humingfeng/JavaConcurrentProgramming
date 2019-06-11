package com.example.concurrentprogramming.threadlocal;

/**
     * 方法实现说明
     * @method      子线程中获取不到父线程中设置的 ThreadLocal 变量的值
     * @author      胡铭锋
     * @version     1.0
     * @exception   
     * @date        2019-06-11 16:03
     */

public class ThreadLocalTest02 {

    /**
     * 必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，如果不清理自定义的 ThreadLocal变量，可能会影响后续业务逻辑和造成内存泄露等问题。尽量在代理中使用try-finally块进行回收。
     */
    /**
     * 创建线程变量
     */
        public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        public static void main(String[] args) {

            //(2)  设置线程变量
            threadLocal.set("hello world");
            //(3) 启动子线程
            Thread thread = new Thread(new  Runnable() {
                @Override
                public void run() {
                    //(4)子线程输出线程变量的值
                    System.out.println("thread:" + threadLocal.get());

                }
            });
            thread.start();

            //(5)主线程输出线程变量值
            System.out.println("main:" + threadLocal.get());

        }
    
}

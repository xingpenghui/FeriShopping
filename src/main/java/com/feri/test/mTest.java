package com.feri.test;

/**
 *@Author feri
 *@Date Created in 2018/8/4 10:40
 */
public class mTest {

    public synchronized void test1(){
        for(int i=1;i<10;i++){
            System.err.println(i);
        }
    }
    public void test2(){
        synchronized (this) {
            for (int i = 1; i < 10; i++) {
                System.err.println(i);
            }
        }
    }
}


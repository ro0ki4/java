package com.edu.xust.cglib;

import com.edu.xust.proxy.IProduce;

public class Producer{
    public void saleProduce(float money) {
        System.out.println("卖出产品拿到" + money);
    }

    public void afterService(float money) {
        System.out.println("售后拿到" + money);
    }

    public void myTest(float money) {

    }
}

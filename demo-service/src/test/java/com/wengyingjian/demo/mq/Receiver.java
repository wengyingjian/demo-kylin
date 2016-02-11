package com.wengyingjian.demo.mq;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wengyingjian on 16/2/9.
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
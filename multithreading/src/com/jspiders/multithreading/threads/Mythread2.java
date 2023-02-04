package com.jspiders.multithreading.threads;

public class Mythread2 implements Runnable {
      @Override
    public void run() {
    	for(int i=1;i<=5;i++)
    		System.out.println("Mythread2 is now running");
    	
    }
}

package com.jspiders.multithreading.threads;

public class Mythread1 extends Thread {
   @Override
public void run() {
	for(int i=1;i<=5;i++) {
		System.out.println("My thread1 is now running");
	}
}
	   
   
}

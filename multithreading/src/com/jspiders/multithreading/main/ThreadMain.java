package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.Mythread1;

import com.jspiders.multithreading.threads.Mythread2;

public class ThreadMain {
     public static void main(String[] args) {
    	 Mythread1 myThread1=new Mythread1();
		Mythread2 myThread2=new Mythread2();
		Thread thread=new Thread(myThread2);
		myThread1.start();
		thread.start();
	}
}

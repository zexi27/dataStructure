package com.zlq.day280;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/27 21:53
 */
public class EightLocks {

	public static void main(String[] args) throws Exception {
		Phone phone = new Phone();
		Phone phone2 = new Phone();

		new Thread(() -> {
			try {
				phone.sendSMS();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "AA").start();

		Thread.sleep(100);

		new Thread(() -> {
			try {
				phone2.sendEmail();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "BB").start();

		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "call------";
			}
		});
		new Thread(task).start();
		Thread thread = new Thread();
		thread.stop();
		System.out.println(task.get());

	}
}

class Phone {

	public static synchronized void sendSMS() throws Exception {
		System.out.println("------sendSMS");
	}

	public static synchronized void sendEmail() throws Exception {
		System.out.println("------sendEmail");
	}

	public void getHello() {
		System.out.println("------getHello");
	}
}

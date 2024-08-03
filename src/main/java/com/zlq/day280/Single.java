package com.zlq.day280;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/28 22:23
 */
public class Single {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				Student instance = Single.getInstance();
				System.out.println("获取到了单例instance");
				System.out.println(instance.getAtomicInteger() + "---------");
			}).start();
		}
	}

	public static volatile Student INSTANCE;

	public static Student getInstance() {
		if (null == INSTANCE) {
			synchronized (Single.class) {
				if (null == INSTANCE) {
					System.out.println(Thread.currentThread().getName() + "发现对象是空的，正要创建对象。。。。");
					INSTANCE = new Student("张雅梅", 12);
				}
			}
		}
		return INSTANCE;
	}

}


class Student {

	private String name;
	Integer age;

	static AtomicInteger atomicInteger = new AtomicInteger(0);

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
		atomicInteger.incrementAndGet();
	}

	public AtomicInteger getAtomicInteger() {
		return atomicInteger;
	}
}
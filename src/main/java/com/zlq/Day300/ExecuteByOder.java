package com.zlq.Day300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/5 19:12
 */
public class ExecuteByOder {

	public static final int threadCnt = 100;

	public static void main(String[] args) {
		Thread[] threads = new Thread[threadCnt];

		for (int i = 0; i < threadCnt; i++) {
//            int finalI = i;
			threads[i] = new Thread(() -> {
//                if (finalI > 0){
//                    try {
//                        threads[finalI - 1].join();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
				System.out.println(Thread.currentThread().getName() + "->正在运行");
			});
		}

		for (Thread thread : threads) {
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		System.out.println(Thread.currentThread().getName() + "->->正在执行");
		String word = "aabbccddeeffgghhiiiiii";
		System.out.println(minimumPushes(word));

		Person person = new Person("aaa",12);
		System.out.println(person);
		changePerson(person);
		System.out.println(person);
	}

    /*
    nums[0][0] + nums[0][1] + nums[0][2] = 5
    nums[1][0] + nums[1][1] + nums[1][2] = 7
    nums[2][0] + nums[2][1] + nums[2][2] = 10

    num[0][0] + num[1][0] + num[2][0] = 8
    num[0][1] + num[1][1] + num[2][1] = 6
    num[0][2] + num[1][2] + num[2][2] = 8
     */


	public static int minimumPushes(String word) {
		int[] letterIdx = new int[26];
		for (int i = 0; i < word.length(); i++) {
			letterIdx[word.charAt(i) - 'a']++;
		}

		Arrays.sort(letterIdx);
		int res = 0, mapperCnt = 0;
		for (int i = 25; i >= 0; i--) {
			int letterCnt = letterIdx[i];
			if (letterCnt > 0) {
				mapperCnt++;
				if (mapperCnt % 8 > 0) {
					res += (mapperCnt / 8 + 1) * letterCnt;
				} else {
					res += ((mapperCnt - 1) / 8 + 1) * letterCnt;
				}
			}
		}
		return res;
	}

	public static void changePerson(Person person){
		person.setAge(person.getAge() + 1);
	}

}

class Person{
	private String name;
	private Integer age;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(name, person.name) && Objects.equals(age, person.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

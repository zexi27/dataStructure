package com.zlq.Day300;

import com.sun.org.apache.bcel.internal.generic.I2B;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/7 16:36
 */
public class OrderObject {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		Random random = new Random();
		students.add(new Student("Alice", 20, 1000));
		students.add(new Student("Bob", 18,2000));
		students.add(new Student("Charlie", 25,4000));
		students.add(new Student("David", 25,3000));

		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getAge().equals(o2.getAge())){
					return o2.getNumber() - o1.getNumber();
				}
				return o1.getAge() - o2.getAge() ;
			}
		});

		for (Student student : students) {
			System.out.println(student);
		}

		String s1 = new String("123");
		String s2 = "123";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}

}


class Student {

	private String name;
	private Integer age;
	private Integer number;

	public Student(String name, Integer age, Integer number) {
		this.name = name;
		this.age = age;
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student student = (Student) o;
		return Objects.equals(name, student.name) && Objects.equals(age, student.age)
				&& Objects.equals(number, student.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, number);
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", number=" + number +
				'}';
	}
}

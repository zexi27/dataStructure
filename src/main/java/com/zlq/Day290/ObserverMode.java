package com.zlq.Day290;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/24 22:43
 */
public class ObserverMode {

	public static void main(String[] args) {
		Observer myObserver = new ConcreteObserver("消息观察者1");

		Subject mySubject = new ConcreteSubject();

		mySubject.registerObserver(myObserver);

		mySubject.notifyObservers("123");
	}
}

// 观察者接口
interface Observer {
	void update(String message);
}

// 主题接口
interface Subject {
	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers(String message);
}

// 具体观察者实现类
class ConcreteObserver implements Observer {
	private String observerName;

	public ConcreteObserver(String name) {
		this.observerName = name;
	}

	@Override
	public void update(String message) {
		System.out.println(observerName + " received message: " + message);
	}
}



// 具体主题实现类
class ConcreteSubject implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private String message;

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

	// 主题状态改变时调用该方法
	public void setMessage(String message) {
		this.message = message;
		notifyObservers(message);
	}

}
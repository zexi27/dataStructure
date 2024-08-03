package com.zlq.day280;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/26 16:22
 */
public class ExecutionSequence {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayedElement> queue = new DelayQueue<>();

		// 添加元素到队列
		queue.put(new DelayedElement("Task 1", 5000));
		queue.put(new DelayedElement("Task 2", 1000));
		queue.put(new DelayedElement("Task 3", 3000));

		System.out.println("Starting to take elements from the queue:");

		// 从队列中取出元素
		while (!queue.isEmpty()) {
			DelayedElement element = queue.take();
			System.out.println("Taken: " + element);
		}
	}

	static class DelayedElement implements Delayed {
		private String name;
		private long delayTime; // 延迟时间，单位毫秒
		private long expireTime; // 过期时间

		public DelayedElement(String name, long delayTime) {
			this.name = name;
			this.delayTime = delayTime;
			this.expireTime = System.currentTimeMillis() + delayTime;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long remainingTime = expireTime - System.currentTimeMillis();
			return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.expireTime < ((DelayedElement) o).expireTime) {
				return -1;
			}
			if (this.expireTime > ((DelayedElement) o).expireTime) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "DelayedElement{name='" + name + "', delayTime=" + delayTime + '}';
		}
	}
}

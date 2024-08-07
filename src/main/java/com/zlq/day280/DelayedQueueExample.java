package com.zlq.day280;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/5 12:29
 */
public class DelayedQueueExample {


	static class DelayedTask implements Delayed {
		private final String name;
		private final long delayTime;  // 延迟时间
		private final long startTime;  // 开始时间

		public DelayedTask(String name, long delayTime) {
			this.name = name;
			this.delayTime = delayTime;
			this.startTime = System.currentTimeMillis() + delayTime;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = startTime - System.currentTimeMillis();
			return unit.convert(diff, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			if (this.startTime < ((DelayedTask) o).startTime) {
				return -1;
			}
			if (this.startTime > ((DelayedTask) o).startTime) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "DelayedTask{" +
					"name='" + name + '\'' +
					", delayTime=" + delayTime +
					", startTime=" + startTime +
					'}';
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Queue queue = new ArrayDeque(100);
		queue.poll();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int ele = random.nextInt(1000);
			queue.add(ele);
		}
		int ele = random.nextInt(1000);

		queue.add("123");
		System.out.println(queue.size());
		System.out.println(queue);
		new Thread().start();
	}
}

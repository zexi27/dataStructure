package com.zlq.primecalculate;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 15:05
 */
public class PrimeCalcTask implements Callable {

	/**
	 * 起始值
	 */
	private int start;

	/**
	 * 结束值
	 */
	private int end;

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	/**
	 * 线程id
	 */
	private String threadId;


	private TreeMap<Integer,Long> calcTimeMap = new TreeMap<>(Comparator.comparingInt(o -> o));


	private static AtomicInteger resCount = new AtomicInteger(0);


	public static final Object o = new Object(); // 锁

	public PrimeCalcTask(int start, int end) {
		this.start = start;
		this.end = end;
		this.threadId = UUID.randomUUID().toString();
	}

	@Override
	public Object call() {
		long curTimeMills = System.currentTimeMillis();
		for (int i = start; i < end; i++) {
			if (PrimeUtils.isPrime(i)){
				long timeMillis = System.currentTimeMillis();
				long calcTime = timeMillis - curTimeMills;
				curTimeMills = timeMillis;
				// 计算时间大都是0毫秒？
				calcTimeMap.put(i,calcTime);
			}
		}

		resCount.addAndGet(calcTimeMap.size());
		return resCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public TreeMap<Integer, Long> getCalcTimeMap() {
		return calcTimeMap;
	}

	public void setCalcTimeMap(TreeMap<Integer, Long> calcTimeMap) {
		this.calcTimeMap = calcTimeMap;
	}
}

package com.zlq.primecalculate.entity;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 15:08
 */
public class BatchCalculateRecord {

	/**
	 * 该批次的起始值
	 */
	private int start;

	/**
	 * 该批次的结束值
	 */
	private int end;

	/**
	 * 该批次的线程id
	 */
	private String threadId;

	/**
	 * 存储该批次计算每个质数的毫秒数关系
	 */
	private TreeMap<Integer,Long> timeMap;


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

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public Map<Integer, Long> getTimeMap() {
		return timeMap;
	}

	public void setTimeMap(TreeMap<Integer, Long> timeMap) {
		this.timeMap = timeMap;
	}

	@Override
	public String toString() {
		return "BatchCalculateRecord{" +
				"start=" + start +
				", end=" + end +
				", threadId='" + threadId + '\'' +
				", timeMap=" + timeMap +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BatchCalculateRecord that = (BatchCalculateRecord) o;
		return start == that.start && end == that.end && Objects.equals(threadId, that.threadId)
				&& Objects.equals(timeMap, that.timeMap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end, threadId, timeMap);
	}

}

package com.zlq.primecalculate.entity;

import java.util.Objects;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 14:56
 */
//字段包括 质数、数值、计算质数的线程id、计算该质数的用时毫秒数
public class CalculateResult {

	/**
	 * 数据id
	 */
	private int id;

	/**
	 * 质数的值
	 */
	private int value;

	/**
	 * 计算质数的线程id
	 */
	private String threadId;

	/**
	 * 计算该质数的时间
	 */
	private long calculateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public long getCalculateTime() {
		return calculateTime;
	}

	public void setCalculateTime(long calculateTime) {
		this.calculateTime = calculateTime;
	}

	@Override
	public String toString() {
		return "CalculateResult{" +
				"id=" + id +
				", value=" + value +
				", threadId='" + threadId + '\'' +
				", calculateTime=" + calculateTime +
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
		CalculateResult that = (CalculateResult) o;
		return id == that.id && value == that.value && calculateTime == that.calculateTime && Objects.equals(
				threadId, that.threadId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value, threadId, calculateTime);
	}
}

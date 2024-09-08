package com.zlq.primecalculate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 14:41
 */
/*
最快找出数字 22222222 的后1000个连续质数，使用多线程，在1分钟内计算出结果，放在数据库表  t_prime_number
要求：
1. 一分钟内执行完，并注释最快的要素是什么
2. 执行结果插入表里需要的记录，字段包括 质数、数值、计算质数的线程id、计算该质数的用时毫秒数
3. 记录到表里的质数是按照升序记录的
 */
public class PrimeUtils {

	/**
	 * 根据一个数判断是否是质数
	 */
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

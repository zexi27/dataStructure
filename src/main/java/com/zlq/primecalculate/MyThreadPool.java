package com.zlq.primecalculate;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 15:02
 */
public class MyThreadPool {

	public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = null;

	public static ThreadPoolExecutor getThreadPoolExecutor(){
		int cpuCores = Runtime.getRuntime().availableProcessors();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
				cpuCores,
				cpuCores * 2,
				1,
				TimeUnit.MINUTES,
				new LinkedBlockingQueue<>(1000),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy());

		return threadPoolExecutor;
	}

}

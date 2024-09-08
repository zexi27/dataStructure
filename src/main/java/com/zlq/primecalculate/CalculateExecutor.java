package com.zlq.primecalculate;

import com.zlq.primecalculate.entity.BatchCalculateRecord;
import com.zlq.primecalculate.entity.CalculateResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/8/14 15:25
 */
public class CalculateExecutor {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CalculateExecutor calculateExecutor = new CalculateExecutor();
		long start = System.currentTimeMillis();
		List<CalculateResult> results = calculateExecutor.calculate(22222222, 1000);
		for (CalculateResult result : results) {
			System.out.println(result);
		}
		System.out.println("数据量为：" + results.size());
		long end = System.currentTimeMillis();
		System.out.println("计算时间为" + (end - start) + "毫秒");
	}

	private static int batchCount = 5000; // 批处理数量

	private static Map<BatchCalculateRecord, String> resultMap = new TreeMap<>(
			Comparator.comparingInt(BatchCalculateRecord::getStart));

	/**
	 * 找出指定数量的质数
	 *
	 * @param baseNum 基数
	 * @param lastCount 数量
	 */
	public List<CalculateResult> calculate(int baseNum, int lastCount) throws ExecutionException, InterruptedException {
		ThreadPoolExecutor executor = MyThreadPool.getThreadPoolExecutor();
		// 最快的要素是利用了线程池，进行多线程计算，进行任务拆分
		int redundant = baseNum % batchCount;  // 剩余的
//		for (int i = baseNum - redundant; i <= baseNum; i++) {
		int start = baseNum - redundant, end = baseNum;
		PrimeCalcTask task = new PrimeCalcTask(start, end);
		Future future = executor.submit(task);
		AtomicInteger curCnt = (AtomicInteger) future.get();

		int executeCount = (baseNum - redundant) / batchCount;
		BatchCalculateRecord batchRecord = generateBatchRecord(task);
		resultMap.put(batchRecord, null);
		for (int i = 0; i < executeCount; i++) {
			end = (executeCount - i) * batchCount;
			start = end - batchCount + 1;
			task = new PrimeCalcTask(start, end);
			future = executor.submit(task);
			curCnt = (AtomicInteger) future.get();
			batchRecord = generateBatchRecord(task);
			resultMap.put(batchRecord, null);
			if (curCnt.get() >= lastCount) {
				break;
			}
		}

		List<CalculateResult> calculateResults = generateResults();
		// 插入数据库
//		batchSave(calculateResults);
		return calculateResults;
	}

	private static List<CalculateResult> generateResults() {
		List<CalculateResult> calculateResults = new ArrayList<>();
		// 生成记录
		for (Entry<BatchCalculateRecord, String> batchEntry : resultMap.entrySet()) {
			BatchCalculateRecord batchRecord = batchEntry.getKey();
			Map<Integer, Long> timeMap = batchRecord.getTimeMap();
			for (Entry<Integer, Long> entry : timeMap.entrySet()) {
				CalculateResult result = new CalculateResult();
				Integer prime = entry.getKey();
				Long time = entry.getValue();
				result.setValue(prime);
				result.setThreadId(batchRecord.getThreadId());
				result.setCalculateTime(time);
				calculateResults.add(result);
			}
		}
		return calculateResults;
	}

	public BatchCalculateRecord generateBatchRecord(PrimeCalcTask task) {
		BatchCalculateRecord batchRecord = new BatchCalculateRecord();
		batchRecord.setStart(task.getStart());
		batchRecord.setEnd(task.getEnd());
		batchRecord.setThreadId(task.getThreadId());
		batchRecord.setTimeMap(task.getCalcTimeMap());
		return batchRecord;
	}


}

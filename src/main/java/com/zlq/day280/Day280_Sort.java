package com.zlq.day280;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/26 12:53
 */
public class Day280_Sort {

	public static void main(String[] args) {
		int[] nums = {2,2,2};

		quickSort(nums);

		System.out.println(Arrays.toString(nums));
	}

	public static void selectSort(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int curMin = Integer.MAX_VALUE;
			int curMinIdx = -1;
			for (int j = i; j < length; j++) {
				if (nums[j] <= curMin) {
					curMin = nums[j];
					curMinIdx = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[curMinIdx];
			nums[curMinIdx] = temp;
		}
	}

	public static void bubbleSort(int[] nums) {
		int length = nums.length;

		for (int i = 0; i < length - 1; i++) {
			boolean isSwap = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					swap(j, j + 1, nums);
					isSwap = true;
				}
			}
			if (!isSwap) {
				break;
			}
		}
	}

	private static void swap(int a, int b, int[] nums) {
		int temp = nums[b];
		nums[b] = nums[a];
		nums[a] = temp;
	}

	// 插入排序
	public static void insertSort(int[] nums) {
		int length = nums.length;
		for (int i = 1; i < length; i++) {
			int j = i - 1;
			int value = nums[i];
			for (; j >= 0; j--) {
				if (value < nums[j]) {
					nums[j + 1] = nums[j];
				} else {
					break;
				}

			}
			nums[j + 1] = value;
		}
	}

	// 归并排序
	public static void mergeSort(int[] nums) {
		int length = nums.length;
		if (nums == null || length < 2) {
			return;
		}

		mergeSort(nums, 0, length - 1);

	}

	private static void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			merge(nums, left, mid, right);
		}
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[right - left + 1]; // 临时数组
		int idx = 0, l = left, r = mid + 1;

		while (l <= mid && r <= right) {
			if (nums[l] <= nums[r]) {
				temp[idx] = nums[l];
				l++;
			} else {
				temp[idx] = nums[r];
				r++;
			}
			idx++;
		}

		// 合并剩余元素
		if (l <= mid) {
			while (l <= mid) {
				temp[idx++] = nums[l++];
			}
		}

		if (r <= right) {
			while (r <= right) {
				temp[idx++] = nums[r++];
			}
		}

		// 将temp元素复制到 nums数组的 left ~ right坐标中
		idx = 0;
		for (int i = left; i <= right; i++) {
			nums[i] = temp[idx++];
		}
	}

	// 计数排序
	public static void countSort(int[] nums) {
		int[] indexArr = new int[100001];
		for (int num : nums) {
			indexArr[getIndex(num)]++;
		}

		int idx = 0;
		for (int i = 0; i < indexArr.length; i++) {
			int idxCnt = indexArr[i];
			if (idxCnt > 0) {
				int num = getNum(i);
				for (int j = 0; j < idxCnt; j++) {
					nums[idx++] = num;
				}
			}
		}
	}

	public static int getIndex(int num) {
		int index;
		if (num > 0) {
			index = 50001 + num;
		} else if (num < 0) {
			index = 50001 + num;
		} else {
			index = 50001;
		}
		return index - 1;
	}

	public static int getNum(int index) {
		if (index > 50000) {
			return index - 50000;
		} else if (index < 50000) {
			return index - 50000;
		} else {
			return 0;
		}
	}

	// 基数排序
	public static int[] radixSort(int[] nums) {
		int maxNum = Integer.MIN_VALUE;

		for (int num : nums) {
			maxNum = Math.max(num, maxNum);
		}

		int maxRadix = maxNum / 10 + 1;

		// key：基数，value基数对应数字的索引，例如 nums中包含 20,24,23,24,25,25,28,则 1=[1,0,0,1,2,2,0,0,1]
		Map<Integer, int[]> radixMap = new HashMap<>();
		for (int i = -maxRadix - 1; i <= maxRadix + 1; i++) {
			radixMap.put(i, new int[10]);
		}

		for (int num : nums) {
			int radix, remain;
			if (num > 0) {
				radix = num / 10 + 1;
				remain = num % 10;
			} else if (num < 0) {
				radix = num / 10 - 1;
				remain = Math.abs(num % 10);
			} else { // num == 0
				radix = 0;
				remain = 0;
			}
			radixMap.get(radix)[remain]++;
		}

		int[] resArr = new int[nums.length];
		int idx = 0;
		for (int i = -maxRadix - 1; i <= maxRadix + 1; i++) {
			if (i < 0) {
				List<Integer> radixList = sortNegativeRadix(radixMap, i);
				for (Integer ele : radixList) {
					resArr[idx++] = ele;
				}
			}

			if (i == 0) {
				int[] radixArr = radixMap.get(0);
				for (int j = 0; j < radixArr[0]; j++) {
					resArr[idx++] = 0;
				}
			}
			if (i > 0) {
				List<Integer> radixList = sortPositiveRadix(radixMap, i);
				for (Integer ele : radixList) {
					resArr[idx++] = ele;
				}
			}
		}

		return resArr;
	}


	private static List<Integer> sortPositiveRadix(Map<Integer, int[]> radixMap, int radix) {
		List<Integer> resList = new ArrayList<>();
		int[] radixIndexArr = radixMap.get(radix);
		for (int k = 0; k < radixIndexArr.length; k++) {
			int valCnt = radixIndexArr[k];
			for (int l = 0; l < valCnt; l++) {
				resList.add((radix - 1) * 10 + k);
			}
		}
		return resList;
	}

	// 桶排序
	private static List<Integer> sortNegativeRadix(Map<Integer, int[]> radixMap, int radix) {
		List<Integer> resList = new ArrayList<>();
		int[] radixIndexArr = radixMap.get(radix);
		for (int k = radixIndexArr.length - 1; k >= 0; k--) {
			int valCnt = radixIndexArr[k];
			for (int l = 0; l < valCnt; l++) {
				resList.add((radix + 1) * 10 - k);

			}
		}
		return resList;
	}

	public static void bucketSort(int[] nums) {
		Arrays.sort(nums);
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int num : nums) {
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		List<List<Integer>> buckets = new ArrayList<>();

		int length = nums.length;
		int bucketCount = (max - min) / length + 1;
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new ArrayList<>());
		}
		for (int num : nums) {
			int bucketIdx = (num - min) / length;
			buckets.get(bucketIdx).add(num);
		}

		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		int idx = 0;
		for (List<Integer> bucket : buckets) {
			if (!bucket.isEmpty()) {
				for (Integer ele : bucket) {
					nums[idx++] = ele;
				}
			}
		}
	}

	// 堆排序
	public static void heapSort(int[] nums) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.offer(num);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = queue.poll();
		}
	}

	public static void quickSort(int[] nums) {
		int length = nums.length;
		if (nums == null || length == 0) {
			return;
		}

		quickSort(nums, 0, length - 1);
	}

	private static void quickSort(int[] nums, int l, int r) {
		if (l < r) {
			// 分区操作，返回基准位置
			int mid = partition(nums, l, r);
			quickSort(nums, l, mid - 1);
			quickSort(nums, mid + 1, r);
		}
	}

	// [4,6,2,3,7,5] ==> [4,2,3,5,6,7]
	// [4,5,2,3,7,6]
	private static int partition(int[] nums, int l, int r) {
		int pivot = nums[r]; // 选择最右边的元素作为基准
		int i = l - 1; // i 是小于基准的最后一个元素的索引

		for (int j = l; j < r; j++) {
			if (nums[j] <= pivot) {
				i++;
				swap(nums, i, j);
			}
		}

		swap(nums, i + 1, r); // 将基准元素放置在正确的位置
		return i + 1; // 返回基准元素的位置
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}

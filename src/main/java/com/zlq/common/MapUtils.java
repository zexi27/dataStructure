package com.zlq.common;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/12/29 14:02
 */
public class MapUtils<K, V> {

	public static <K, V> void printMap(Map<K, V> map) {
		System.out.println("================================");
		for (Entry<K, V> entry : map.entrySet()) {
			K key = entry.getKey();
			String keyStr = transKey(key);
			System.out.print(keyStr + "->");
			V value = entry.getValue();
			String valueStr = transValue(value);
			System.out.println(valueStr);
		}
		System.out.println("================================");
	}

	private static <K> String transKey(K key) {
		String res = transObj(key);
		return res;

	}

	private static <V> String transValue(V value) {
		String res = transObj(value);
		return res;

	}

	private static String transObj(Object value) {
		if (value instanceof int[]) {
			return Arrays.toString((int[]) value);
		}
		return value.toString();
	}




}

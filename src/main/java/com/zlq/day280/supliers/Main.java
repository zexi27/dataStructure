package com.zlq.day280.supliers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/6/4 12:01
 */
public class Main {

	public static void main(String[] args) {

		Product product1 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		Product product2 = new Product("2", "饮料", 5.0, "娃哈哈");
		Product product3 = new Product("3", "牛奶", 6.0, "君乐宝,伊利,蒙牛,完达山");
		Product product4 = new Product("4", "方便面", 9.0, "今麦郎，康师傅,老坛,福满多");

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		Collections.sort(products, (o1, o2) -> {
			String s1 = o1.getSuppliers();
			String s2 = o2.getSuppliers();
			String[] s1Arr = s1.split(",");
			String[] s2Arr = s2.split(",");
			return s1Arr.length - s2Arr.length;
		});
		System.out.println(products);
		System.out.println(tailRecruit(5, 1));

		Set<Product> productSet = new HashSet<>();

		Product p1 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		Product p2 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		Product p3 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		Product p4 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		Product p5 = new Product("1", "矿泉水", 1.5, "农夫山泉,怡宝,百岁山");
		productSet.add(p1);
		productSet.add(p2);
		productSet.add(p3);
		productSet.add(p4);
		productSet.add(p5);
		System.out.println(productSet);

		int[] nums = {2,2,3,2,4,2,3,3,1,3};
		System.out.println(maxOperations(nums));
	}


	public static int recruit(int n) {
		if (n == 1) {
			return 1;
		}
		return n * recruit(n - 1);
	}

	public static int tailRecruit(int n, int result) {
		if (n == 0) {
			return result;
		}
		return tailRecruit(n - 1, n * result);
	}

	public static int maxOperations(int[] nums) {
		int index = 0;
		int baseNum = nums[index++] + nums[index++];
		int cnt = 1;
		while (index < nums.length - 1){
			if (nums[index++] + nums[index++]== baseNum) {
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}
}

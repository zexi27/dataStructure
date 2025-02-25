//package com.zlq.common;
//
//import com.zlq.day320.Day311_ExamRoom;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description:
// * @author: ZhangLiqun
// * @date: 2025/2/25 22:50
// */
//public class MethodInvoker {
//
//	public static void main(String[] args) {
////		Day311_ExamRoom examRoom = new Day311_ExamRoom(10);
////		System.out.println(examRoom.seat());
////		System.out.println(examRoom.seat());
////		System.out.println(examRoom.seat());
////		examRoom.leave(0);
////		examRoom.leave(4);
////		System.out.println(examRoom.seat());
//		String[] methods = {"ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"};
//		String params = "[[10], [], [], [], [], [4], []]";
//		System.out.println(invokeBatch(methods, params));
//	}
//
//	public static List<Integer> invokeBatch(String[] methods,String params, Class clazz){
//		if (checkParam(params)) {
//			throw new RuntimeException("方法参数不正确，请检查params参数！");
//		}
//		List<Integer> resList = new ArrayList<>();
//		for (int i = 0; i < methods.length; i++) {
//			Integer res = invokeParam(methods[i], params[i]);
//			resList.add(res);
//		}
//		return resList;
//	}
//
//	public static boolean checkParam(String params) {
//		if (!params.startsWith("[") || !params.endsWith("]")) {
//			return false;
//		}
//		params = params.substring(1, params.length() - 1);
//		params = params.trim();
//		String[] split = params.split(",");
//		for (String ele : split) {
//			if (!ele.startsWith("[") || ele.endsWith("]")) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public static List<List<Object>> splitParams(String params) {
//		List<List<Object>> paramList = new ArrayList<>();
//		params = params.substring(1, params.length() - 1);
//		params = params.trim();
//		String[] split = params.split(",");
//		for (String ele : split) {
//			List<Object> subParam = new ArrayList<>();
//			String[] subSplit = ele.split(",");
//			for (String subEle : subSplit) {
//				subParam.add(subEle);
//			}
//		}
//
//	}
//
//
//	public static Integer invokeParam(String method,Integer... param){
//		if ("ExamRoom".equals(method)) {
//			instance = new Day311_ExamRoom(param);
//		}
//		if ("seat".equals(method)) {
//			return instance.seat();
//		}
//		if ("leave".equals(method)) {
//			instance.leave(param);
//			return null;
//		}
//		return null;
//	}
//
//}

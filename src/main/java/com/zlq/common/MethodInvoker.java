package com.zlq.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/2/25 22:50
 */
public class MethodInvoker {

	private static Set<String> methodNameSet = new HashSet<>();
	private static Set<String> constructorNameSet = new HashSet<>();


	public static <T> List<Object> invokeBatch(String methods, String paramStr, Class<T> clazz) {
		checkParam(paramStr);
		checkMethods(clazz, methods);
		List<List<Object>> paramList = splitParams(paramStr);
		List<String> methodList = splitMethods(methods);
		T t = null;
		List<Object> resList = new ArrayList<>();
		for (int i = 0; i < methodList.size(); i++) {
			String methodName = methodList.get(i);
			List<Object> params = paramList.get(i);
			if (isConstructor(methodName)) {
				t = invokeConstructor(clazz, methodName, params);
				resList.add(null);
			} else {
				Object res = invokeParam(t, methodName, params);
				resList.add(res);
			}
		}
		return resList;
	}

	public static <T> void checkParam(String params) {
		if (!params.startsWith("[") || !params.endsWith("]")) {
			throw new RuntimeException("参数应以\"[\"初始，以\"]\"结束");
		}
		params = params.substring(1, params.length() - 1);
		params = params.trim();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < params.length(); i++) {
			char c = params.charAt(i);
			if (c == '[') {
				stack.push(c);
			} else if (c == ']') {
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			throw new RuntimeException("参数格式不正确");
		}
	}

	private static <T> void checkMethods(Class<T> clazz, String methods) {
		String className = clazz.getName();
		if (!methods.startsWith("[") || !methods.endsWith("]")) {
			throw new RuntimeException("参数应以\"[\"初始，以\"]\"结束");
		}
		Constructor<?>[] constructors = clazz.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor<?> constructor = constructors[i];
			String constructorName = constructor.getName();
			if (!constructorName.contains(className)) {
				throw new RuntimeException("构造器参数不正确");
			}
			String[] split = constructorName.split("\\.");
			constructorName = split[split.length - 1];
			constructorNameSet.add(constructorName);
		}

		Method[] methodArr = clazz.getMethods();
		for (int i = 0; i < methodArr.length; i++) {
			Method method = methodArr[i];
			String methodName = method.getName();
			// 排除构造器
			if (!isConstructor(methodName)) {
				methodNameSet.add(methodName);
			}
		}
		methodNameSet = Arrays.stream(methodArr).map(method -> method.getName()).collect(Collectors.toSet());
		methods = methods.substring(1, methods.length() - 1).replace("\"", "").replace(" ", "");
		methods = methods.trim();
		String[] split = methods.split(",");
		List<String> methodList = Arrays.stream(split).filter(ele -> !isConstructor(ele)).collect(Collectors.toList());
		for (String method : methodList) {
			if (!methodNameSet.contains(method)) {
				throw new RuntimeException("类中不包含该方法，methodName=" + method);
			}
		}
	}

	private static boolean isConstructor(String methodName) {
		for (String constructorName : constructorNameSet) {
			if (constructorName.toLowerCase(Locale.ROOT).contains(methodName.toLowerCase()) || constructorName.equals(
					methodName)) {
				return true;
			}
		}
		return false;
	}

	public static List<List<Object>> splitParams(String params) {
		List<List<Object>> paramList = new ArrayList<>();
		params = params.substring(1, params.length() - 1);
		params = params.replace(" ", "");
		int l = 0, r = 0;
		while (r < params.length() - 1) {
			while (r < params.length() - 1 && params.charAt(r) != ']') {
				r++;
			}
			String element = params.substring(l, r + 1);

			element = element.replace("[", "").replace("]", "");
			String[] split = element.split(",");
			List<Object> param = new ArrayList<>();
			for (String subEle : split) {
				String paramType = getParamType(subEle);
				switch (paramType) {
					case "String":
						param.add(subEle);
						break;
					case "int":
						Integer intP = Integer.parseInt(subEle);
						param.add(intP);
						break;
					case "Double":
						Double doubleP = Double.parseDouble(subEle);
						param.add(doubleP);
						break;
					case "Boolean":
						Boolean booleanP = Boolean.parseBoolean(subEle);
						param.add(booleanP);
						break;
					default:
						break;
				}
			}
			paramList.add(param);
			while (r < params.length() - 1 && params.charAt(r) != '[') {
				r++;
			}
			l = r;
			r = l;
		}
		return paramList;
	}

	// 根据字符串类型的param获取参数类型
	private static String getParamType(String paramString) {
		if ("true".equals(paramString) || "false".equals(paramString)) {
			return "boolean";
		}
		boolean isString = false;
		boolean containsPoint = false;
		boolean isNumber = true;
		for (int i = 0; i < paramString.length(); i++) {
			char c = paramString.charAt(i);
			if (!(c >= '0' && c <= '9'
					|| c == '.' && i < paramString.length() - 1 && i > 0)) {
				isString = true;
				isNumber = false;
			}
			if (c == '.') {
				containsPoint = true;
			}
		}
		if (isString) {
			return "String";
		}

		if (isNumber) {
			return containsPoint ? "double" : "int";
		}
		throw new RuntimeException("unknown param type:" + paramString);
	}

	public static List<String> splitMethods(String methods) {
		List<String> methodList = new ArrayList<>();
		methods = methods.substring(1, methods.length() - 1);
		methods = methods.trim().replace("\"", "").replace(" ", "");
		String[] split = methods.split(",");
		for (String ele : split) {
			methodList.add(ele);
		}
		return methodList;
	}


	private static <T> T invokeConstructor(Class<T> clazz, String constructorName, List<Object> params) {
		Class[] parameterTypes = new Class[params.size()];
		for (int i = 0; i < params.size(); i++) {
			parameterTypes[i] = toPrimitive(params.get(i).getClass());
		}
		T t;
		try {
			Constructor<T> constructor = clazz.getConstructor(parameterTypes);
			t = constructor.newInstance(params.toArray());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return t;
	}

	private static <T> Object invokeParam(T t, String methodName, List<Object> params) {
		Method method;
		Class<?>[] parameterTypes = new Class<?>[params.size()];
		for (int i = 0; i < params.size(); i++) {
			parameterTypes[i] = toPrimitive(params.get(i).getClass());
		}
		Object invokeResult = null;
		try {
			method = t.getClass().getMethod(methodName, parameterTypes);
			invokeResult = method.invoke(t, params.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invokeResult;
	}


	private static Class toPrimitive(Class<?> clazz) {
		if (clazz == Integer.class) {
			return int.class;
		}
		if (clazz == Double.class) {
			return double.class;
		}
		if (clazz == Boolean.class) {
			return boolean.class;
		}
		// 根据需要可以扩展其他类型转换
		return clazz;
	}


}
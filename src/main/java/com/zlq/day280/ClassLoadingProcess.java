package com.zlq.day280;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/7/2 18:06
 */
public class ClassLoadingProcess {

    public static void main(String[] args) throws Exception {
        T t = new T();
        System.out.println(t.count);

    }
}

class T {
    public static T t = new T(); // null
    public static int count = 2; //0


    public T() {
        count++;
        System.out.println("-----" + count);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        T.count = count;
    }
}
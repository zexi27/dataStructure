package com.zlq.day40.day36_lrucache;


import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day40.day36_lrucache
 * @ClassName: LRUCache
 * @description:
 * @author: LiQun
 * @CreateDate:2021/8/8 9:46 上午
 */
/*运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制。
        实现 LRUCache 类：
        LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

        进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache<T> extends LinkedHashMap<String,T> {
    public static void main(String[] args) {
        LRUCache<String> lruCache = new LRUCache<>(3);
        lruCache.put("k1","v1");
        lruCache.put("k2","v2");
        lruCache.put("k3","v3");
        print(lruCache);
        lruCache.put("k4","v4");
        print(lruCache);
        String k3 = lruCache.get("k3");
        System.out.println(k3);
        print(lruCache);
    }
    public int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }

    public T get(String key){
        return super.get(key);
    }

    public T put(String key,T t){
        return super.put(key,t);
    }

    public static void print(LinkedHashMap linkedHashMap){
        Set set = linkedHashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.print(next + "\t");
        }
        System.out.println();
    }

}

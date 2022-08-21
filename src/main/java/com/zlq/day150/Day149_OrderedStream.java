package com.zlq.day150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day150
 * @ClassName: Day149_OrderedStream
 * @description:
 * @author: LiQun
 * @CreateDate:2022/8/16 10:31
 */
/*
有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个(id, value) 对。

设计一个流，以 任意 顺序获取 n个(id, value)对，并在多次调用时 按 id 递增的顺序 返回一些值。

实现 OrderedStream 类：

OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个 id + 1。
否则，返回一个空列表。

示例：

输入
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
输出
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

解释
OrderedStream os= new OrderedStream(5);
os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 */
public class Day149_OrderedStream {
    public static void main(String[] args) {
        Day149_OrderedStream orderedStream = new Day149_OrderedStream(5);
        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));

    }

    private String[] stringArr = null;
    private int index = 0;

    public Day149_OrderedStream(int n) {
        stringArr = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> resList = new ArrayList<>();
        stringArr[idKey - 1] = value;
        while (index < stringArr.length && stringArr[index] != null){
            resList.add(stringArr[index]);
            index++;
        }
        return resList;
    }
}

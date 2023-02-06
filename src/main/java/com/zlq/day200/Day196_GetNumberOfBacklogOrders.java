package com.zlq.day200;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day200
 * @ClassName: Day196_GetNumberOfBacklogOrders
 * @description:
 * @author: LiQun
 * @CreateDate:2023/1/2 14:59
 */
/*
给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。

订单类型 orderTypei 可以分为两种：

0 表示这是一批采购订单 buy
1 表示这是一批销售订单 sell
注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。

存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：

如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。



示例 1：


输入：orders = [[10,5,0],[15,2,1],[25,1,1],[30,4,0]]
输出：6
解释：输入订单后会发生下述情况：
- 提交 5 笔采购订单，价格为 10 。没有销售订单，所以这 5 笔订单添加到积压订单中。
- 提交 2 笔销售订单，价格为 15 。没有采购订单的价格大于或等于 15 ，所以这 2 笔订单添加到积压订单中。
- 提交 1 笔销售订单，价格为 25 。没有采购订单的价格大于或等于 25 ，所以这 1 笔订单添加到积压订单中。
- 提交 4 笔采购订单，价格为 30 。前 2 笔采购订单与价格最低（价格为 15）的 2 笔销售订单匹配，从积压订单中删除这 2 笔销售订单。第 3 笔采购订单与价格最低的 1 笔销售订单匹配，销售订单价格为 25 ，从积压订单中删除这 1 笔销售订单。积压订单中不存在更多销售订单，所以第 4 笔采购订单需要添加到积压订单中。
最终，积压订单中有 5 笔价格为 10 的采购订单，和 1 笔价格为 30 的采购订单。所以积压订单中的订单总数为 6 。
示例 2：


输入：orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
输出：999999984
解释：输入订单后会发生下述情况：
- 提交 109 笔销售订单，价格为 7 。没有采购订单，所以这 109 笔订单添加到积压订单中。
- 提交 3 笔采购订单，价格为 15 。这些采购订单与价格最低（价格为 7 ）的 3 笔销售订单匹配，从积压订单中删除这 3 笔销售订单。
- 提交 999999995 笔采购订单，价格为 5 。销售订单的最低价为 7 ，所以这 999999995 笔订单添加到积压订单中。
- 提交 1 笔销售订单，价格为 5 。这笔销售订单与价格最高（价格为 5 ）的 1 笔采购订单匹配，从积压订单中删除这 1 笔采购订单。
最终，积压订单中有 (1000000000-3) 笔价格为 7 的销售订单，和 (999999995-1) 笔价格为 5 的采购订单。所以积压订单中的订单总数为 1999999991 ，等于 999999984 % (109 + 7) 。

 */
public class Day196_GetNumberOfBacklogOrders {

//    public static void main(String[] args) {
//        // [1,29,1],[22,7,1],[24,1,0],[25,15,1],[18,8,1],[8,22,0],[25,15,1],[30,1,1],[27,30,0]
////        int[][] orders = {{17, 27, 1}, {12, 11, 1}, {4, 10, 0}, {28, 20, 1}, {5, 19, 0}, {11, 2, 1}, {3, 13, 0}, {27, 5, 1}, {4, 20, 1}, {3, 19, 0}};
//        int[][] orders = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
//        System.out.println(getNumberOfBacklogOrders2(orders));
//    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        long res = 0;
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> saleQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < orders.length; i++) {
            res += orders[i][1];
            if (orders[i][2] == 0) {
                int buyOrderCount = orders[i][1];
                buyQueue.offer(new int[]{orders[i][0], orders[i][1]});
                while (!saleQueue.isEmpty()) {
                    int[] salePeek = saleQueue.peek(); // 取堆顶元素，也是最小价格销售订单元素
                    if (salePeek[0] <= orders[i][0]) { // 如果销售订单价格小于购买订单价格，勾销订单
                        if (salePeek[1] < buyOrderCount) { // 如果销售订单价格小于购买订单价格,且销售订单数量小于购买订单，则这比销售订单勾销，继续下一个比较
                            int[] salePoll = saleQueue.poll();
                            buyQueue.poll();
                            buyOrderCount = buyOrderCount - salePeek[1];
                            buyQueue.offer(new int[]{orders[i][0], buyOrderCount});
                            res -= (salePoll[1] + salePeek[1]);
                        } else { // 如果销售订单价格小于购买订单价格,且销售订单数量大于购买订单，则这比销售订单减去购买订单数量
                            saleQueue.poll();
                            saleQueue.offer(new int[]{salePeek[0], salePeek[1] - buyOrderCount});
                            int[] buyPool = buyQueue.poll();
                            res -= (buyOrderCount + buyPool[1]);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                int saleOrderCount = orders[i][1];
                saleQueue.offer(new int[]{orders[i][0], orders[i][1]});
                while (!buyQueue.isEmpty()) {
                    int[] buyPeek = buyQueue.peek(); // 取堆顶元素，也是最小价格购买订单元素
                    if (buyPeek[0] >= orders[i][0]) { // 如果销售订单价格小于购买订单价格，勾销订单
                        if (buyPeek[1] > saleOrderCount) { // 如果销售订单价格小于购买订单价格,且销售订单数量小于购买订单，则这比销售订单勾销，继续下一个比较
                            buyQueue.poll();
                            buyQueue.offer(new int[]{buyPeek[0], buyPeek[1] - saleOrderCount});
                            int[] salePool = saleQueue.poll();
                            res -= (saleOrderCount + salePool[1]);
                            break;
                        } else { // 如果销售订单价格小于购买订单价格,且销售订单数量大于购买订单，则这比销售订单减去购买订单数量
                            int[] buyPool = buyQueue.poll();
                            saleQueue.poll();
                            saleOrderCount = saleOrderCount - buyPool[1];
                            saleQueue.offer(new int[]{orders[i][0], saleOrderCount});
                            res -= (buyPool[1] + buyPeek[1]);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return (int) (res % 1000000007);
    }


    public static int getNumberOfBacklogOrders2(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> saleQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < orders.length; i++) {
            if (orders[i][2] == 0) {
                int buyOrderCount = orders[i][1];
                while (!saleQueue.isEmpty() && saleQueue.peek()[0] <= orders[i][0]) { // 如果销售订单价格小于购买订单价格，勾销订单
                    int[] salePeek = saleQueue.peek(); // 取堆顶元素，也是最小价格销售订单元素
                    // 如果销售订单价格小于购买订单价格，勾销订单
                    if (salePeek[1] < buyOrderCount) { // 如果销售订单价格小于购买订单价格,且销售订单数量小于购买订单，则这比销售订单勾销，继续下一个比较
                        saleQueue.poll();
                        buyOrderCount = buyOrderCount - salePeek[1];
                    } else { // 如果销售订单价格小于购买订单价格,且销售订单数量大于购买订单，则这比销售订单减去购买订单数量
                        int[] salePool = saleQueue.poll();
                        saleQueue.offer(new int[]{salePeek[0], salePeek[1] - buyOrderCount});
                        buyOrderCount = buyOrderCount - salePool[1];
                        break;
                    }
                }
                if (buyOrderCount > 0) buyQueue.offer(new int[]{orders[i][0], buyOrderCount});
            } else {
                int saleOrderCount = orders[i][1];
                while (!buyQueue.isEmpty() && buyQueue.peek()[0] >= orders[i][0]) {  // 如果销售订单价格小于购买订单价格，勾销订单
                    int[] buyPeek = buyQueue.peek(); // 取堆顶元素，也是最小价格购买订单元素
                    // 如果销售订单价格小于购买订单价格，勾销订单
                    if (buyPeek[1] > saleOrderCount) { // 如果销售订单价格小于购买订单价格,且销售订单数量小于购买订单，则这比销售订单勾销，继续下一个比较
                        int[] buyPool = buyQueue.poll();
                        buyQueue.offer(new int[]{buyPeek[0], buyPeek[1] - saleOrderCount});
                        saleOrderCount = saleOrderCount - buyPool[1];
                    } else { // 如果销售订单价格小于购买订单价格,且销售订单数量大于购买订单，则这比销售订单减去购买订单数量
                        int[] buyPool = buyQueue.poll();
                        saleOrderCount = saleOrderCount - buyPool[1];
                    }
                }
                if (saleOrderCount > 0) saleQueue.offer(new int[]{orders[i][0], saleOrderCount});
            }
        }
        long res = 0;
        while (!saleQueue.isEmpty()) {
            int[] poll = saleQueue.poll();
            res = res + poll[1];
        }
        while (!buyQueue.isEmpty()) {
            int[] poll = buyQueue.poll();
            res = res + poll[1];
        }

        return (int) (res % 1000000007);
    }


//    public static void main(String[] args) {
////        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
////        System.out.println(areNumbersAscending2(s));
//        System.out.println(countEven(30));
//    }

    public static boolean areNumbersAscending(String s) {
        String[] tokenArr = s.split(" ");
        int lastNum = 0, curNum = 0;
        for (int i = 0; i < tokenArr.length; i++) {
            if (tokenArr[i].charAt(0) - '0' >= 0 && tokenArr[i].charAt(0) - '0' <= 9) {
                int num = Integer.parseInt(tokenArr[i]);
                if (curNum != 0) {
                    lastNum = curNum;
                }
                curNum = num;
                if (curNum <= lastNum) return false;
            }
        }
        return true;
    }

    public static boolean areNumbersAscending2(String s) {
        int l = 0, r = 0;
        int lastNum = 0, curNum = 0;
        while (r <= s.length() - 1) {
            if (s.charAt(r) - '0' >= 0 && s.charAt(r) - '0' <= 9) {
                while (r <= s.length() - 1 && s.charAt(r) != ' ') {
                    r++;
                }
                int num = Integer.parseInt(s.substring(l, r));
                if (curNum != 0) {
                    lastNum = curNum;
                }
                curNum = num;
                if (curNum <= lastNum) return false;
                l = r + 1;
                r = l;
            } else {
                l++;
                r++;
            }
        }
        return true;
    }

    /*
    给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
    正整数的 各位数字之和 是其所有位上的对应数字相加的结果。

    示例 1：

    输入：num = 4
    输出：2
    解释：
    只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。
    示例 2：

    输入：num = 30
    输出：14
    解释：
    只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是：
    2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
     */
    public static void main(String[] args) {
        System.out.println(countEven3(910));
    }

    public static int countEven(int num) {
        int res = 0;
        /*
        528
        528 % 10 / 1 = 8
        528 % 100 / 10 = 2
        528 % 1000 / 100 = 5
        ---------
        11 % 10 / 1
         */
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            // 求各位数字之和
            sum = getSum(i);
            if (sum % 2 == 0 && sum != 0) {
                res++;
            }
        }
        return res;
    }


    private static int getSum(int num) {
        int sum = 0;
        int index = 10;
        while (true) {
            sum += num % index / (index / 10);
            if (num / index == 0) break;
            index *= 10;
        }
        return sum;
    }

    public static int countEven2(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            String numStr = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < numStr.length(); j++) {
                sum += numStr.charAt(j) - '0';
            }
            if (sum % 2 == 0) res++;
        }
        return res;
    }


    public static int countEven3(int num) {
        boolean[] booleans = new boolean[num + 1];
        booleans[0] = true;
        for (int i = 1; i < booleans.length; i++) {
            // 除了十进位以外所有元素都和前一个相反,百进位也相反
            if (i % 10 == 0 && i % 100 != 0) {  // 十进位
                booleans[i] =booleans[i - 1];
            }else {
                booleans[i] = !booleans[i - 1];

            }
        }
        if (booleans.length == 1001) booleans[1000] = false;
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (booleans[i] == true) res++;
        }
        return res;
    }
}
package com.zlq.day240;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day240
 * @ClassName: Day239_LongestDecomposition
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/12 14:26
 */
/*
1147. 段式回文
困难
你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:

subtexti 是 非空 字符串
所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
返回k可能最大值。



示例 1：

输入：text = "ghiabcdefhelloadamhelloabcdefghi"
输出：7
解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
示例 2：

输入：text = "merchant"
输出：1
解释：我们可以把字符串拆分成 "(merchant)"。
示例 3：

输入：text = "antaprezatepzapreanta"
输出：11
解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。

提示：

1 <= text.length <= 1000
text 仅由小写英文字符组成
 */
public class Day239_LongestDecomposition {

    public static void main(String[] args) {
        String text = "elvtoelvto";
        System.out.println(longestDecomposition(text));
        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(nums));
//        int length = text.length();
//        int l = 0, r = length - 1;
//        while (l < r) {
//            System.out.println(text.substring(0, l + 1));
//            System.out.println(text.substring(r, text.length()));
//            System.out.println("------");
//            l++;
//            r--;
//        }
    }

    public static int longestDecomposition(String text) {
        int k = 0;
        int length = text.length();
        int l = 0, r = length - 1;
        int start = 0, end = length;
        int leftLength = 0;
        while (l < r) {
            String leftStr = text.substring(start, l + 1);
            String rightStr = text.substring(r, end);
            if (leftStr.equals(rightStr)) {
                leftLength += l - start + 1;
                k += 2;
                start = l + 1;
                end = r;
            }
            l++;
            r--;
        }
        return length - 2 * leftLength > 0 ? k + 1 : k;
    }


    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (ele % 2 == 0) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        int minKey = 0;
        int maxValue = 0;
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            if (value > maxValue) {
                minKey = key;
                maxValue = value;
            }
        }
        return map.isEmpty() ? -1 : minKey;
    }
}

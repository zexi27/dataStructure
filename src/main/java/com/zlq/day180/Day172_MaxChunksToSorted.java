package com.zlq.day180;

import java.util.List;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day170
 * @ClassName: Day172_MaxChunksToSorted
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/13 22:04
 */
/*
给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。

我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。

返回数组能分成的最多块数量


示例 1:

输入: arr = [4,3,2,1,0]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
示例 2:

输入: arr = [1,0,2,3,4]
输出: 4
解释:
我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 */
public class Day172_MaxChunksToSorted {

    /*
    [1,0,3,2,4]
    [1,0],[3,2],[4]
    ---------------
    [1,3,0,6,4,5,2]    [1,3,0,2,5,6,4]
                       [1,3,0,2][5,6,4]
     */
    public static void main(String[] args) {
        int[] arr = {1,3,0,2,5,6,4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int length = arr.length;
        if (arr[length - 1] == 0) return 1;
        int count = 0;
        int curMin = 0;
        int curMax = 0;
        int index = 0;
        while (index < length) {
            curMax = Math.max(arr[index], curMax);
            if (arr[index] == curMin) {
                while (index < curMax) {
                    index++;
                    curMax = Math.max(arr[index], curMax);

                }
                if (index == curMax) {
                    count += 1;
                    curMin = curMax + 1;
                }
            }
            index++;
        }
        return count;
    }
}

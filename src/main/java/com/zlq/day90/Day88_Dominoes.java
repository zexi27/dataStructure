package com.zlq.day90;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day88_Dominoes
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/21 4:51 下午
 */
/*
n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。

每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。

如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。

就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。

给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：

dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
返回表示最终状态的字符串。

示例 1：

输入：dominoes = "RR.L"
输出："RR.L"
解释：第一张多米诺骨牌没有给第二张施加额外的力。
示例 2：


输入：dominoes = ".L.R...LR..L.."
输出："LL.RR.LLRRLL.."
提示：

n == dominoes.length
1 <= n <= 105
dominoes[i] 为 'L'、'R' 或 '.'
 */
public class Day88_Dominoes {
    public static void main(String[] args) {
        String dominoes = "....";
        System.out.println(pushDominoes(dominoes));
    }

    public static String pushDominoes(String dominoes) {
        // index为定义指针，leftSymbol为未推倒骨牌范围内左边的施力点，同理，rightSymbol为右边的
        int index = 0, leftSymbol = 0, rightSymbol = 0;
        StringBuilder res = new StringBuilder();
        while (index <= dominoes.length() - 1) {
            // 核心就在于修改'.' 为字符的骨牌，'L'和'R'不做修改
            char c = dominoes.charAt(index);
            if (c == 'L' || c == 'R') {
                res.append(c);
                index++;
            } else {  // 找到未推倒的骨牌，进行骨牌左右验证
                leftSymbol = index - 1;
                int innerIndex = index;
                while (innerIndex < dominoes.length() && dominoes.charAt(innerIndex) == '.') {
                    innerIndex++;
                }
                rightSymbol = innerIndex;
                index = rightSymbol;
                // 如果'.'左边没骨牌或者右边没骨牌
                if (leftSymbol < 0 || rightSymbol > dominoes.length() - 1) {
                    if (leftSymbol < 0 && rightSymbol > dominoes.length() - 1){
                        for (int i = 0; i < dominoes.length(); i++) {
                            res.append('.');
                        }
                        break;
                    }
                    if (leftSymbol < 0 && dominoes.charAt(rightSymbol)== 'L'){
                        for (int i = 0; i < (rightSymbol - leftSymbol - 1); i++) {
                            res.append('L');
                        }
                    }else if (rightSymbol > dominoes.length() - 1 && dominoes.charAt(leftSymbol)== 'R'){
                        for (int i = 0; i < (rightSymbol - leftSymbol - 1); i++) {
                            res.append('R');
                        }
                    }else {
                        for (int i = 0; i < (rightSymbol - leftSymbol - 1); i++) {
                            res.append('.');
                        }
                    }

                    continue;
                }
                // 如果范围内未推倒骨牌的左边和右边推倒方向一致
                if (dominoes.charAt(leftSymbol) == dominoes.charAt(rightSymbol)) {
                    char appendChar = dominoes.charAt(leftSymbol);
                    for (int i = 0; i < (rightSymbol - leftSymbol - 1); i++) {
                        res.append(appendChar);
                    }
                } else { // 如果范围内未推倒骨牌的左边和右边推倒方向不一致
                    if (dominoes.charAt(leftSymbol) == 'L' && dominoes.charAt(rightSymbol) == 'R') {
                        for (int i = 0; i < (rightSymbol - leftSymbol - 1); i++) {
                            res.append('.');
                        }
                    } else {
                        int notDownCount = rightSymbol - leftSymbol - 1;
                        if (notDownCount == 1) res.append('.');
                        else if (notDownCount % 2 == 0) {
                            for (int i = 0; i < notDownCount / 2; i++) {
                                res.append(dominoes.charAt(leftSymbol));
                            }
                            for (int i = 0; i < notDownCount / 2; i++) {
                                res.append(dominoes.charAt(rightSymbol));
                            }
                        } else if (notDownCount % 2 != 0) {
                            for (int i = 0; i < notDownCount / 2; i++) {
                                res.append(dominoes.charAt(leftSymbol));
                            }
                            res.append('.');
                            for (int i = 0; i < notDownCount / 2; i++) {
                                res.append(dominoes.charAt(rightSymbol));
                            }
                        }
                    }

                }

                continue;
            }
        }
        return res.toString();
    }
}

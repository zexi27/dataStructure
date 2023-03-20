package com.zlq.day210;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day210
 * @ClassName: Day210_AlphabetBoardPath
 * @description:
 * @author: LiQun
 * @CreateDate:2023/2/12 20:45
 */
/*
我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。

在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。



我们可以按下面的指令规则行动：

如果方格存在，'U' 意味着将我们的位置上移一行；
如果方格存在，'D' 意味着将我们的位置下移一行；
如果方格存在，'L' 意味着将我们的位置左移一列；
如果方格存在，'R' 意味着将我们的位置右移一列；
'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
（注意，字母板上只存在有字母的位置。）

返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。



示例 1：

输入：target = "leet"
输出："DDR!UURRR!!DDD!"
示例 2：

输入：target = "code"
输出："RR!DDRR!UUL!R!"


提示：

1 <= target.length <= 100
target 仅含有小写英文字母。
 */
public class Day210_AlphabetBoardPath {

    public int indexNum = 0;

    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int targetNum = c - 'a';
            while (indexNum != targetNum) {
                String code = getCodeAndRemove(targetNum);
                res.append(code);
            }
            res.append("!");
        }
        return res.toString();
    }

    public String getCodeAndRemove(int targetNum) {
        if (indexNum > targetNum) {
            if (indexNum - targetNum >= 5) {
                up();
                return "U";
            } else {
                if (sameLine(targetNum)) {
                    left();
                    return "L";
                } else {
                    up();
                    return "U";
                }
            }
        } else if (indexNum < targetNum) {
            if (targetNum - indexNum >= 5) {
                down();
                return "D";
            } else {
                if (sameLine(targetNum)) {
                    right();
                    return "R";
                } else {
                    left();
                    return "L";
                }

            }
        }
        return "";
    }

    /**
     * 判断当前位置和目标位置是否为同一行
     *
     * @param targetNum
     * @return
     */
    private boolean sameLine(int targetNum) {
        return indexNum / 5 == targetNum / 5;
    }

    public int up() {
        indexNum -= 5;
        return indexNum;
    }

    public int down() {
        indexNum += 5;
        return indexNum;
    }

    public int left() {
        indexNum -= 1;
        return indexNum;
    }

    public int right() {
        indexNum += 1;
        return indexNum;
    }
}

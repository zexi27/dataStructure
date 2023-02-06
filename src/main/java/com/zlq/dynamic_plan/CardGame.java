package com.zlq.dynamic_plan;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.dynamic_plan
 * @ClassName: CardGame
 * @description:
 * @author: LiQun
 * @CreateDate:2022/10/5 13:50
 */
/*
给定一个整型数组arr，代表数值不同的纸牌排成一条线
玩家A和玩家B依次拿走每张纸牌
规定玩家A先拿，玩家B后拿
但是每个玩家每次只能拿走最左或最右的纸牌
玩家A和玩家B都绝顶聪明
请返回最后获胜者的分数。
 */
public class CardGame {
    public static void main(String[] args) {
        int[] cards = {1, 10, 20, 5, 100};
        System.out.println(winnerScore(cards));
    }

    public static int winnerScore(int[] cards) {
        if (cards == null && cards.length == 0) return -1;
        return Math.max(f(0, cards.length - 1, cards), g(0, cards.length - 1, cards));
    }

    public static int f(int l, int r, int[] cards) {
        if (l == r) return cards[l];
        return Math.max(cards[l] + g(l + 1, r, cards), cards[r] + g(l, r - 1, cards));
    }
    public static int g(int l, int r, int[] cards) {
        if (l == r) return 0;
        return Math.min(f(l + 1, r, cards), f(l, r - 1, cards));
    }


}

package com.zlq.day90;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.day90
 * @ClassName: Day87_IsOneBitCharacter
 * @description:
 * @author: LiQun
 * @CreateDate:2022/2/20 9:12 上午
 */
public class Day87_IsOneBitCharacter {
    public static void main(String[] args) {
        int[] bits = {1,0,0,0};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter2(int[] bits) {
        int start = 0 ;
        while(start<bits.length-1){
            if(bits[start] == 0){
                start++;
            }else{
                start+=2;
            }
        }
        return start == bits.length-1;
    }
    // {0,1,1,1,0,0}
    public static boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index <= bits.length - 1) {
            if (bits[index] == 0) {
                index++;
            }
            else {
                index +=2;
            }
        }
        return index == bits.length - 1;
    }
    public static boolean allZero(int[] bits){
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) return false;
        }
        return true;
    }
}

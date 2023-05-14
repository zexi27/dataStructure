package com.zlq.day240;

import java.util.*;

/**
 * @ProjectName:dataStructurePractise
 * @Package:com.zlq.day240
 * @ClassName: Day238_IsRobotBounded
 * @description:
 * @author: LiQun
 * @CreateDate:2023/4/11 10:34
 */
/*
1041. Robot Bounded In Circle
提示
中等
170
相关企业
On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:

The north direction is the positive direction of the y-axis.
The south direction is the negative direction of the y-axis.
The east direction is the positive direction of the x-axis.
The west direction is the negative direction of the x-axis.
The robot can receive one of three instructions:

"G": go straight 1 unit.
"L": turn 90 degrees to the left (i.e., anti-clockwise direction).
"R": turn 90 degrees to the right (i.e., clockwise direction).
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
"G": move one step. Position: (0, 1). Direction: South.
"G": move one step. Position: (0, 0). Direction: South.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
Based on that, we return true.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
Based on that, we return false.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
"G": move one step. Position: (-1, 1). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
"G": move one step. Position: (-1, 0). Direction: South.
"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
"G": move one step. Position: (0, 0). Direction: East.
"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
Based on that, we return true.

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.
 */
public class Day238_IsRobotBounded {
    public static void main(String[] args) {
        String instructions = "GGLLGG";
        System.out.println(isRobotBounded(instructions));
    }

    public static boolean isRobotBounded(String instructions) {
        int directionIndex = 0;
        int[] position = {0, 0};
        for (int j = 0; j < instructions.length(); j++) {
            char c = instructions.charAt(j);
            if (c == 'G') position = move(position, directionIndex);
            if (c == 'L') directionIndex -= 1;
            else if (c == 'R') directionIndex += 1;

            if (directionIndex > 3) directionIndex = directionIndex - 4;
            if (directionIndex < 0) directionIndex = 4 + directionIndex;
        }
        return directionIndex != 0 || (position[0] == 0 && position[1] == 0);
    }

    public static int[] move(int[] position, int directionIndex) {
        if (directionIndex == 0) position[1]++;
        else if (directionIndex == 1) position[0]++;
        else if (directionIndex == 2) position[1]--;
        else position[0]--;

        return position;
    }


    public char findTheDifference(String s, String t) {
        int[] indexArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indexArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
             indexArr[c - 'a']--;
             if (indexArr[c - 'a'] < 0) return c;
        }
        return ' ';
    }
}

package com.zlq.day320;

import com.zlq.common.MapUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2024/12/29 12:57
 */

/*
In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.

The ordering of teams is decided by who received the most position-one votes.
 If two or more teams tie in the first position, we consider the second position to resolve the conflict,
 if they tie again, we continue this process until the ties are resolved.
 if two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

You are given an array of strings votes which is the votes of all voters in the ranking systems.
Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.



Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation:
Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
Team B was ranked second by 2 voters and ranked third by 3 voters.
Team C was ranked second by 3 voters and ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team, and team B is the third.
Example 2:

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation:
X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position.
Example 3:

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter, so their votes are used for the ranking.

1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length.
votes[i][j] is an English uppercase letter.

 */
public class Day311_RankTeams {

	public static String rankTeams(String[] votes) {
		// 构建投票索引,key：team字符，value：key-第几位，value-几张票
		Map<Character, int[] > teamScoreMap = new HashMap<>();
		for (int i = 0; i < votes[0].length(); i++) {
			char c = votes[0].charAt(i);
			teamScoreMap.put(c, new int[votes[0].length()]);
		}

		for (String vote : votes) {
			for (int i = 0; i < vote.length(); i++) {
				char c = vote.charAt(i);
				int[] scoreArr = teamScoreMap.get(c);
				scoreArr[i]++;
			}
		}

		List<Map.Entry<Character, int[]>> entries = new ArrayList<>(teamScoreMap.entrySet());
		entries.sort((entry1, entry2) -> {
			int[] scoreArr1 = entry1.getValue();
			int[] scoreArr2 = entry2.getValue();
			for (int i = 0; i < scoreArr1.length; i++) {
				if (scoreArr1[i] != scoreArr2[i]){
					return scoreArr2[i] - scoreArr1[i];
				}
			}
			return entry1.getKey() - entry2.getKey();
		});

		StringBuilder resBuilder = new StringBuilder();
		for (Map.Entry<Character, int[]> entry : entries) {
			resBuilder.append(entry.getKey());
		}

		return resBuilder.toString();
	}

}


class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.age, other.age);
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "}";
	}
}


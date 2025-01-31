package com.zlq.day320;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZhangLiqun
 * @date: 2025/1/5 15:48
 */
/*
2241. Design an ATM Machine
中等
相关标签
相关企业
提示
There is an ATM machine that stores banknotes of 5 denominations: 20, 50, 100, 200, and 500 dollars. Initially the ATM is empty. The user can use the machine to deposit or withdraw any amount of money.

When withdrawing, the machine prioritizes using banknotes of larger values.

For example, if you want to withdraw $300 and there are 2 $50 banknotes, 1 $100 banknote, and 1 $200 banknote, then the machine will use the $100 and $200 banknotes.
However, if you try to withdraw $600 and there are 3 $200 banknotes and 1 $500 banknote, then the withdraw request will be rejected because the machine will first try to use the $500 banknote and then be unable to use banknotes to complete the remaining $100. Note that the machine is not allowed to use the $200 banknotes instead of the $500 banknote.
Implement the ATM class:

ATM() Initializes the ATM object.
void deposit(int[] banknotesCount) Deposits new banknotes in the order $20, $50, $100, $200, and $500.
int[] withdraw(int amount) Returns an array of length 5 of the number of banknotes that will be handed to the user in the order $20, $50, $100, $200, and $500, and update the number of banknotes in the ATM after withdrawing. Returns [-1] if it is not possible (do not withdraw any banknotes in this case).


Example 1:

Input
["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
[[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
Output
[null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]

Explanation
ATM atm = new ATM();
atm.deposit([0,0,1,2,1]); // Deposits 1 $100 banknote, 2 $200 banknotes,
                          // and 1 $500 banknote.
atm.withdraw(600);        // Returns [0,0,1,0,1]. The machine uses 1 $100 banknote
                          // and 1 $500 banknote. The banknotes left over in the
                          // machine are [0,0,0,2,0].
atm.deposit([0,1,0,1,1]); // Deposits 1 $50, $200, and $500 banknote.
                          // The banknotes in the machine are now [0,1,0,3,1].
atm.withdraw(600);        // Returns [-1]. The machine will try to use a $500 banknote
                          // and then be unable to complete the remaining $100,
                          // so the withdraw request will be rejected.
                          // Since the request is rejected, the number of banknotes
                          // in the machine is not modified.
atm.withdraw(550);        // Returns [0,1,0,0,1]. The machine uses 1 $50 banknote
                          // and 1 $500 banknote.


Constraints:

banknotesCount.length == 5
0 <= banknotesCount[i] <= 109
1 <= amount <= 109
At most 5000 calls in total will be made to withdraw and deposit.
At least one call will be made to each function withdraw and deposit.
Sum of banknotesCount[i] in all deposits doesn't exceed 109
 */
public class Day315_ATM {

	public static void main(String[] args) {
		Day315_ATM atm = new Day315_ATM();
		atm.deposit(new int[]{250796, 638723, 691758, 845522, 938973});
		atm.deposit(new int[]{215317, 848628, 182949, 784609, 30472});

		System.out.println(Arrays.toString(atm.withdraw(701035245)));
		System.out.println(Arrays.toString(atm.withdraw(109992310)));
		System.out.println(Arrays.toString(atm.withdraw(755819795)));
		System.out.println(Arrays.toString(atm.withdraw(722349970)));

	}

	static int[] depositArr;
	static int[] moneyArr = {20,50,100,200,500};

	public Day315_ATM() {
		depositArr = new int[5];
	}

	public void deposit(int[] banknotesCount) {
		for (int i = 0; i < banknotesCount.length; i++) {
			depositArr[i] += banknotesCount[i];
		}
	}

	public int[] withdraw(int amount) {
		int[] dispatchResult = new int[5];
		while (amount > 0) {
			amount = dispatch(dispatchResult, amount);
		}
		if (amount == -1) {
			return new int[]{-1};
		}
		for (int i = 0; i < dispatchResult.length; i++) {
			depositArr[i] -= dispatchResult[i];
		}
		return dispatchResult;
	}

	/**
	 * 单次派发金额，返回剩余金额
	 */
	public int dispatch(int[] dispatchResult, int amount) {
		// 选择最大的面值派发多少张
		for (int i = 4; i >= 0; i--) {
			Integer money = moneyArr[i];
			if (money > amount){
				continue;
			}
			if (depositArr[i] - dispatchResult[i] > 0) {
				int cnt = amount / money;
				if (depositArr[i] <= cnt) {
					cnt = depositArr[i];
				}
				dispatchResult[i] += cnt;
				return amount - cnt * money;
			}
		}
		return -1;
	}


}

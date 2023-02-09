package Feb;

import java.util.Arrays;
import java.util.Scanner;

public class TwoFriends_1 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		int[] cost = new int[s.nextInt()];

		for (int i = 0; i < cost.length; i++) {
			System.out.print("element : ");
			cost[i] = s.nextInt();
		}
		System.out.println("Enter the total amount : ");
		System.out.println(Arrays.toString(iceCream(cost, s.nextInt())));
	}

	public static int[] iceCream(int[] cost, int total) {

		int[] res = { -1, -1 };
		int sum = 0;
		outer: for (int i = 0; i < cost.length; i++) {
			for (int j = i + 1; j < cost.length; j++) {
				sum = cost[i] + cost[j];
				if (sum == total) {
					res[0] = i + 1;
					res[1] = j + 1;
					break outer;
				}
			}
		}
		return res;
	}
}

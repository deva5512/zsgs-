package mid_jan;

import java.util.Scanner;

public class Question_4 {
	static int[] contain = { 68, 32, 45, 15 };
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the amount : ");
		int amount = s.nextInt();
		System.out.println("Total : " + total(contain));
		int number = noOfCoins(amount);
		System.out.println(number);
		System.out.println("Remaining : " + total(contain));
	}

	public static int noOfCoins(int amount) {
		int my_total = total(contain);
		if (my_total < amount) {
			return -1;
		}
		int i = contain.length - 1, count = 0;
		while (i >= 0) {
			if (amount == 0) {
				return count;
			}
			count++;
			if (amount >= 10 && contain[3] != 0) {
				amount -= 10;
				contain[3] -= 1;
				continue;
			} else if (amount >= 5 && contain[2] != 0) {
				amount -= 5;
				contain[2] -= 1;
				continue;
			} else if (amount >= 2 && contain[1] != 0) {
				amount -= 2;
				contain[1] -= 1;
				continue;
			} else if (amount >= 1 && contain[0] != 0) {
				amount -= 1;
				contain[0] -= 1;
			}
		}
		return count;
	}

	public static int total(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0)
				sum += a[i] * 1;
			if (i == 1)
				sum += a[i] * 2;
			if (i == 2)
				sum += a[i] * 5;
			if (i == 3)
				sum += a[i] * 10;
		}
		return sum;
	}
}

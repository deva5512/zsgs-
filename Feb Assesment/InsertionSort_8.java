package Feb;

import java.util.Arrays;

public class InsertionSort_8 {
	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		int[] num = new int[TwoFriends_1.s.nextInt()];

		for (int i = 0; i < num.length; i++) {
			System.out.print("element : ");
			num[i] = TwoFriends_1.s.nextInt();
		}
		insertion(num);
		System.out.println(Arrays.toString(num));
	}

	public static void insertion(int[] num) {

		for (int i = 1; i < num.length; i++) {
			int temp = i;
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] > num[temp])
					swap(num, temp--, j);
				else
					break;
			}
		}

	}

	public static void swap(int[] num, int first, int second) {
		num[first] = (num[first] + num[second]) - (num[second] = num[first]);
	}
}

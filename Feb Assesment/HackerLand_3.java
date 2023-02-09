package Feb;

import java.util.Arrays;

public class HackerLand_3 {
	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		int[] num = new int[TwoFriends_1.s.nextInt()];

		for (int i = 0; i < num.length; i++) {
			System.out.print("element : ");
			num[i] = TwoFriends_1.s.nextInt();
		}

		System.out.println("Enter the trailing days : ");
		int trailing = TwoFriends_1.s.nextInt();

//		int[] num = { 2, 3, 4, 2, 3, 6, 8, 5 };

		System.out.println("Number of notifications : " + notification(num, num.length, trailing));

	}

	public static int notification(int[] arr, int size, int trailing) {

		int count = 0;

		for (int i = trailing + 1; i < size; i++) {

			// for every trailing the method will find the median and check is the value is
			// greater then the 2*median
			if (median(arr, i - trailing - 1, i - 1) * 2 <= arr[i]) {
				System.out.println(arr[i]);
				count++;
			}
		}
		return count;
	}

	public static int median(int[] arr, int start, int end) {

		// median can be found in the sorted array so the array is sorted initially
		Arrays.sort(arr);
		int mid = (arr.length - 1) / 2;
		if ((mid & 1) == 0) {
			return arr[mid];
		} else {
			return (arr[mid] + arr[mid + 1]) / 2;
		}
	}
}

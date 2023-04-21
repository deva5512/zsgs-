package PreparationQuestions;

import java.util.Arrays;

public class Two_21_04_2023 {
	public static void main(String[] args) {
		int[] arr = { 9, 2, 0, 4, 3, 0, 2, 0 };
		moveZeros(arr);
	}

	public static void moveZeros(int[] arr) {
		int j = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[j] = arr[i];
				j++;
			}
		}
		for (; j < arr.length; j++) {
			arr[j] = 0;
		}

		System.out.println(Arrays.toString(arr));
	}
}

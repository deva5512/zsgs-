package PreparationQuestions;

import java.util.Arrays;

public class Four_21_04_2023 {

	public static void main(String[] args) {
		int[][] arr = { { 9, 9, 9, 9 }, { 9, 2, 6, 6 }, { 9, 5, 1, 0 }, { 9, 1, 3, 2 } };

		for (int[] array : arr) {
			System.out.println(Arrays.toString(array));
		}
		System.out.println();

		// if 1 horizontal 2 vertical 3 diagonal

		int input = 3;

		sortBasedOnDirection(arr, input);
	}

	private static void sortBasedOnDirection(int[][] arr, int input) {
		if (input == 1) {
			for (int[] i : arr) {
				Arrays.sort(i);
			}
		} else if (input == 2) {

			for (int i = 0; i < arr.length; i++) {

				boolean control = true;
				do {
					control = false;

					for (int j = 0; j < arr.length - 1; j++) {
						if (arr[j][i] > arr[j + 1][i]) {
							int temp = arr[j][i];
							arr[j][i] = arr[j + 1][i];
							arr[j + 1][i] = temp;
							control = true;
						}
					}

				} while (control);

			}

		} else {
			for (int i = 0; i < arr.length - 1; i++) {
				if (i == 0)
					sortDiagonal(0, 0, arr);
				else {
					sortDiagonal(i, 0, arr);
					sortDiagonal(0, i, arr);
				}
			}
		}

		for (int[] array : arr) {
			System.out.println(Arrays.toString(array));
		}
	}

	private static void sortDiagonal(int i, int j, int[][] arr) {
		boolean control = true;
		int minus = Math.max(i, j) + 1;
		do {
			control = false;

			for (int k = 0; k < arr.length - minus; k++) {
				if (arr[i + k][j + k] > arr[i + k + 1][j + k + 1]) {

					int temp = arr[i + k][j + k];

					arr[i + k][j + k] = arr[i + k + 1][j + k + 1];

					arr[i + k + 1][j + k + 1] = temp;

					control = true;
				}
			}

		} while (control);
	}

}

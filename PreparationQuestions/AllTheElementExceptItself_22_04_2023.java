package PreparationQuestions;

import java.util.Arrays;

/*
 *   5) Return the Array of product of All the elements except itself.

		Example : Input arr = {1,2,3,4}
		Output arr = {24,12,8,6} 
 */

public class AllTheElementExceptItself_22_04_2023 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		allExceptItself1(arr);
		int[] arr1 = { 1, 2, 3, 4 };
		allExceptItself(arr1);
	}

	// without using extra space 
	public static void allExceptItself(int[] arr) {
		int sum = Arrays.stream(arr).reduce(1, (a, b) -> a * b);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sum / arr[i];
		}
		System.out.println(Arrays.toString(arr));
	}

	// by using n space
	public static void allExceptItself1(int[] arr) {
		int[] extra = arr.clone();

		for (int i = arr.length - 2; i >= 0; i--) {
			extra[i] = extra[i] * extra[i + 1];
		}

		int mul = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				arr[i] = mul;
			} else {
				int temp = arr[i];
				arr[i] = mul * extra[i + 1];
				mul *= temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

package PreparationQuestions.Set3;

import java.util.Arrays;

public class CustomSort {

//	Eg 1: Input: 13,2,4,15,12,10,5
//    Output: 13,2,12,10,5,15,4
//	Eg 2: Input: 1,2,3,4,5,6,7,8,9
//    Output: 9,2,7,4,5,6,3,8,1 

	public static void main(String[] args) {
		int[] arr = { 13, 2, 4, 15, 12, 10, 5 };
		int e = arr.length; // even mean odd so len - 2
		boolean control = false;
		do {
			control = false;
			for (int i = 2; i < e; i += 2) {
				if (arr[i - 2] < arr[i]) {
					swap(arr, i - 2, i);
					control = true;
				}
			}
			for (int i = 3; i < e; i += 2) {
				if (arr[i - 2] > arr[i]) {
					swap(arr, i - 2, i);
					control = true;
				}
			}
			e -= 2;
		} while (control);
		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

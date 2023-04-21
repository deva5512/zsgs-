package PreparationQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Two_18_04_2023 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 5, 6, 9, 5 }; // 1, 2, 0, 5, 6, 9, 0
		usingSet(arr);
	}

	public static void usingSet(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (!set.add(arr[i])) {
				arr[i] = 0;
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}

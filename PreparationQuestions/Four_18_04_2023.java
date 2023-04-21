package PreparationQuestions;

import java.util.Arrays;
import java.util.Stack;

public class Four_18_04_2023 {

	public static void main(String[] args) {
		int[] arr = { 173654, 185654, 1982834 };
		System.out.println(Arrays.toString(covidCases1(arr)));
		System.out.println(Arrays.toString(covidCases(arr)));
	}

	public static int[] covidCases(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				arr[stack.peek()] = i - stack.pop();
			}
			stack.add(i);
		}

		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		return arr;
	}

	public static int[] covidCases1(int[] arr) {

		int[] res = new int[arr.length];
		Arrays.fill(res, -1);

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					res[j] = i - j;
				} else {
					break;
				}
			}
		}

		return res;
	}

}

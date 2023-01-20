package mid_jan;

import java.util.ArrayList;
import java.util.Arrays;

public class Question_2 {
	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 3, 3 };
		int[] b = new int[] { 1, 2, 3, 1, 5 };
		int[] c = new int[] { 1, 2, 3, 1, 2, 3 };
		int[] d = new int[] { 1, 2, 1, 2, 1, 2 };
		int[] e = { -1, 0, 1, 2, 3, 4, 5 };
		subArrays(d);
		for (int[] array : ans) {
			System.out.println(Arrays.toString(array));
		}
	}

	static ArrayList<int[]> ans = new ArrayList<>();

	public static void subArrays(int[] arr) {
		int total = total(arr);
		int equalsum = 0;
		int add = 0;
		int start = 0, i = 1;
		while (i < arr.length) {
			if (add == 0) {
				add += arr[i - 1];
			}
			if (arr[i - 1] < arr[i]) {
				add += arr[i];
				i++;
			} else if (add < total / 2 && arr[i - 1] == arr[i]) {
				add += arr[i];
				i++;
			} else {
				ans.add(Arrays.copyOfRange(arr, start, i));
				if (equalsum == 0) {
					equalsum = add;
				} else {
					if (add != equalsum)
						break;
				}
				start = i;
				add = 0;
				i++;
			}
		}
		if (equalsum != add) {
			ans = null;
		} else {
			ans.add(Arrays.copyOfRange(arr, start, arr.length));
		}
	}

	public static int total(int[] a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		return total;
	}
}

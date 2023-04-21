package PreparationQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Two_19_04_2023 {

	public static void main(String[] args) {
		int[][] arr = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		longestChain(arr);
	}

	public static void longestChain(int[][] arr) {
		Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return 1;
				return -1;
			}
		};

		Arrays.sort(arr, comp);

		List<int[]> list = new LinkedList<>();
		list.add(arr[0]);
		int[] pre = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (pre[1] < arr[i][0]) {
				list.add(arr[i]);
				pre = arr[i];
			}
		}

		for (int[] a : list) {
			System.out.println(Arrays.toString(a));
		}
	}
}

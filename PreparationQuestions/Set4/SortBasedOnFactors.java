package PreparationQuestions.Set4;

public class SortBasedOnFactors {
	
//	Input:
//		Given array : 8, 2, 3, 12, 16
//		Output:
//		12, 16, 8, 2, 3

	public static void main(String[] args) {
		int[] arr = { 8, 2, 3, 12, 16 };
		factorSort(arr);
	}

	private static void factorSort(int[] arr) {
		int[][] res = new int[arr.length][2];

		for (int i = 0; i < res.length; i++) {
			res[i][0] = arr[i];
			res[i][1] = factorCount(arr[i]);
		}
		quick(res, 0, res.length - 1);
		for (int i[] : res)
			System.out.print(i[0] + " ");
	}

	public static int factorCount(int num) {
		int count = 2;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				count++;
		}
		return count;
	}

	public static void quick(int[][] arr, int s, int e) {
		if (s >= e)
			return;
		int pivert = pivert(arr, s, e);
		quick(arr, s, pivert - 1);
		quick(arr, pivert + 1, e);
	}

	private static int pivert(int[][] arr, int s, int e) {
		int pivert = arr[e][1];
		int ind = s;
		for (; s <= e; s++) {
			if (arr[s][1] > pivert)
				swap(arr, ind++, s);
		}
		swap(arr, ind, e);
		return ind;
	}

	private static void swap(int[][] arr, int ind, int s) {
		int[] temp = arr[ind];
		arr[ind] = arr[s];
		arr[s] = temp;
	}

}

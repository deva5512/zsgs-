package PreparationQuestions;

public class SortTheWeights {

	public static void main(String[] args) {
		int[] arr = { 10, 36, 54, 89, 12 };
		sort(arr);
	}

	private static void sort(int[] arr) {
		int[][] res = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			res[i][0] = arr[i];
			int weight = 0;
			if (isSquare(arr[i]))
				weight += 5;
			if (arr[i] % 4 == 0 && arr[i] % 6 == 0)
				weight += 4;
			if (arr[i] % 2 == 0)
				weight += 3;
			res[i][1] = weight;
		}

		quick(res, 0, res.length - 1);
		for (int[] i : res)
			System.out.println(i[0] + " - " + i[1]);
	}

	public static boolean isSquare(int val) {
		int num = 1;
		int sqrt = 1;
		while (sqrt < val) {
			num++;
			sqrt = num * num;
			if (val == sqrt)
				return true;
		}
		return false;
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
		for (int i = s; i <= e; i++) {
			if (arr[i][1] < pivert)
				swap(arr, ind++, i);
		}
		swap(arr, ind, e);
		return ind;
	}

	private static void swap(int[][] arr, int ind, int e) {
		int[] temp = arr[ind];
		arr[ind] = arr[e];
		arr[e] = temp;
	}

}

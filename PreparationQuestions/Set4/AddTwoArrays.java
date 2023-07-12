package PreparationQuestions.Set4;

public class AddTwoArrays {

//	Number of elements in set1: 4
//	Elements are: 9, 9, 9, 9
//	Number of elements in set 2: 3
//	Elements are: 1,1,1
//	Output:
//	1, 0, 1, 1, 0
//	Input:
//	Number of elements in set1: 11
//	Elements are: 7,2,3,4,5,3,1,2,7,2,8
//	Number of elements in set 2: 3
//	Elements are: 1,2,3
//	Output: 7,2,3,4,5,3,1,2,8,5,1

	public static void main(String[] args) {
		int[] a = { 7, 2, 3, 4, 5, 3, 1, 2, 7, 2, 8 };
		int[] b = { 1, 2, 3 };
		addArrays(a, b);
		addTwoArray(a, b);
	}

	public static void addArrays(int[] a, int[] b) {
		int n = a.length > b.length ? a.length : b.length;
		int[] res = new int[n + 1];
		int ind = n;
		for (int i = a.length - 1; i >= 0; i--, ind--) {
			res[ind] = a[i];
		}
		ind = n;
		for (int i = b.length - 1; i >= 0; i--, ind--) {
			res[ind] += b[i];
			if (res[ind] >= 10) {
				res[ind - 1] += res[ind] / 10;
				res[ind] %= 10;
			}
		}
		if (res[ind] >= 10) {
			res[ind - 1] += res[ind] / 10;
			res[ind] %= 10;
		}
		print(res);
	}

	private static void addTwoArray(int[] a, int[] b) {
		int n = a.length > b.length ? a.length : b.length;
		int[] res = new int[n + 1];
		int ind = res.length - 1;
		int i = a.length - 1, j = b.length - 1;
		for (; i >= 0 && j >= 0; i--, j--, ind--) {
			res[ind] += a[i] + b[j];
			if (res[ind] >= 10) {
				res[ind - 1] = res[ind] / 10;
				res[ind] %= 10;
			}
		}
		while (i >= 0) {
			res[ind] += a[i];
			if (res[ind] >= 10) {
				res[ind - 1] = res[ind] / 10;
				res[ind] %= 10;
			}
			ind--;
			i--;
		}
		while (j >= 0) {
			res[ind] += b[j];
			if (res[ind] >= 10) {
				res[ind - 1] = res[ind] / 10;
				res[ind] %= 10;
			}
			ind--;
			j--;
		}
		print(res);
	}

	public static void print(int[] arr) {
		boolean start = true;
		for (int i = 0; i < arr.length; i++) {
			if (start) {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " ");
					start = false;
				}
			} else {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}

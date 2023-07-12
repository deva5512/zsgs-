package PreparationQuestions.Set3;

public class MergTwoSortedArray {

//	Eg 1: Input:
//        Array 1: 2,4,5,6,7,9,10,13
//        Array 2: 2,3,4,5,6,7,8,9,11,15
//        Output:
//        Merged array: 2,3,4,5,6,7,8,9,10,11,13,15 

	public static void main(String[] args) {
		int[] a = { 2, 4, 5, 6, 7, 9, 10, 13 };
		int[] b = { 2, 3, 4, 5, 6, 7, 8, 9, 11, 15 };
		for (int i : mergTwoArray(a, b))
			System.out.print(i + " ");
	}

	public static int[] mergTwoArray(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int ind = 0;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				i++;
				res[ind++] = b[j++];
			} else if (a[i] < b[j])
				res[ind++] = a[i++];
			else
				res[ind++] = b[j++];
		}
		while (i < a.length)
			res[ind++] = a[i++];
		while (j < b.length)
			res[ind++] = b[j++];
		return trimSize(res, ind);
	}

	private static int[] trimSize(int[] arr, int size) {
		int[] res = new int[size];
		for (int i = 0; i < size; i++)
			res[i] = arr[i];
		return res;
	}

}

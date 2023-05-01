package PreparationQuestions;

public class SearchInRotatedSortedArray_29_04_2023 {

	public static void main(String[] args) {
		int[] arr = { 3, 1 };
		System.out.println(searchSortedArray(arr, 1));
	}

	public static int searchSortedArray(int[] arr, int target) {
		int s = 0, e = arr.length - 1;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (arr[s] <= arr[mid]) {
				if (arr[s] <= target && arr[mid] >= target) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {
				if (arr[mid] <= target && arr[e] >= target) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}

		}
		return -1;
	}

}

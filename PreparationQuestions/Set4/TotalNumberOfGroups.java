package PreparationQuestions.Set4;

import java.util.ArrayList;
import java.util.List;

public class TotalNumberOfGroups {

//	Input:
//		Array: 3, 9, 7, 4, 6, 8
//		X: 3
//	Output:
//		3, 9
//		3, 6
//		9, 6
//		3, 9, 6
//		No of groups: 4

	public static void main(String[] args) {
		int[] arr = { 3, 9, 7, 4, 6, 8 };
		int x = 3;
		List<List<Integer>> list = new ArrayList<>();
		findGroups(arr, x, list, new ArrayList<>(), 0, 0);
		System.out.println(list);
	}

	private static void findGroups(int[] arr, int x, List<List<Integer>> res, List<Integer> list, int ind, int sum) {
		if (ind == arr.length) {
			if (list.size() > 1 && list.size() <= x)
				res.add(new ArrayList<>(list));
			return;
		}
		findGroups(arr, x, res, list, ind + 1, sum);
		if ((sum + arr[ind]) % x == 0) {
			list.add(arr[ind]);
			findGroups(arr, x, res, list, ind + 1, sum + arr[ind]);
			list.remove(list.size() - 1);
		}
	}

}

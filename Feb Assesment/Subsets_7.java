package Feb;

import java.util.ArrayList;
import java.util.List;

public class Subsets_7 {

	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		int[] num = new int[TwoFriends_1.s.nextInt()];

		for (int i = 0; i < num.length; i++) {
			System.out.print("element : ");
			num[i] = TwoFriends_1.s.nextInt();
		}
		subset(num);
	}

	public static void subset(int[] nums) {
		helper(nums, 0, new ArrayList<>());
	}

	public static void helper(int[] num, int ind, List<Integer> res) {
		if (ind == num.length) {
			System.out.println(res);
			return;
		}

		helper(num, ind + 1, res);

		res.add(num[ind]);
		helper(num, ind + 1, res);
		res.remove(res.size() - 1);
	}
}

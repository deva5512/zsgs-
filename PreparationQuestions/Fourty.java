package PrepatationQuestions_1;

public class Fourty {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 8, 5 };
		int target = 11;
		boolean[] check = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				continue;
			check[i] = true;
			makeNumber(nums, nums[i] + "", nums[i], check, 1, target);
			makeNumber(nums, nums[i] * -1 + "", nums[i] * -1, check, 1, target);
			check[i] = false;
		}
	}

	public static void makeNumber(int[] nums, String str, int sum, boolean[] check, int count, int target) {
		if (count == nums.length) {
			if (sum == target)
				System.out.println(str + "  ->  " + sum);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!check[i]) {
				check[i] = true;
				makeNumber(nums, str + "+" + nums[i], sum + nums[i], check, count + 1, target);
				makeNumber(nums, str + "-" + nums[i], sum - nums[i], check, count + 1, target);
				makeNumber(nums, str + "*" + nums[i], sum * nums[i], check, count + 1, target);
				if (nums[i] != 0 && (sum / (double) nums[i]) % 1 == 0)
					makeNumber(nums, str + "/" + nums[i], sum / nums[i], check, count + 1, target);
				check[i] = false;
			}
		}
	}
}

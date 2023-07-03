package PrepatationQuestions_1;

public class MakePairWithLessSwap {
	
	/*
	 * Ex: 
	 * Input: ABACDEB     Output: 2 AABBDEC 
	 * Input: ABCCDDB     Output:  1 BBCCDDA 
	 * Input: AABDDCB     Output: 1 AACDDBB
	 * Input: MOMDAD     Output: 2 MMODDA
	 */

	public static void main(String[] args) {
		String s = "ABACDEB";
		int[] arr = new int[26];
		for (char ch : s.toCharArray())
			arr[ch - 'A']++;
		solve(s.toCharArray(), new boolean[s.length()], 0, arr);
		System.out.println(min);
		System.out.println(res);

	}

	static int min = Integer.MAX_VALUE;
	static String res = "";

	public static void solve(char[] s, boolean[] check, int count, int[] freq) {
		if (isValid(s, freq)) {
			if (count < min) {
				min = count;
				res = new String(s);
			}
			return;
		}
		for (int i = 0; i < s.length; i++) {
			if (!check[i]) {
				check[i] = true;
				solve(s, check, count, freq);
				for (int j = 0; j < s.length; j++) {
					if (!check[j] && s[j] != s[i]) {
						check[j] = true;
						swap(s, i, j);
						solve(s, check, count + 1, freq);
						swap(s, i, j);
						check[j] = false;
					}
				}
				check[i] = false;
			}
		}
	}

	public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

	public static boolean isValid(char[] s, int[] arr) {
		int[] copy = arr.clone();
		for (int i = 0; i < s.length - 1; i++) {
			if (s[i] == s[i + 1]) {
				copy[s[i] - 'A'] -= 2;
				i++;
			}
		}
		for (int i = 0; i < copy.length; i++) {
			if (copy[i] > 1)
				return false;
		}
		return true;
	}

}

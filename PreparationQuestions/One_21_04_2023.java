package PreparationQuestions;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class One_21_04_2023 {
	public static void main(String[] args) {
		String word = "ABSG";
		permutation(word);
	}

	public static void permutation(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		s = new String(arr);
		boolean[] check = new boolean[arr.length];
		Set<String> res = new LinkedHashSet<>();
		helper(res, new StringBuilder(), check, s);

		for (String word : res) {
			System.out.println(word);
		}
	}

	public static void helper(Set<String> res, StringBuilder sb, boolean[] check, String word) {

		if (sb.length() == word.length()) {
			res.add(new String(sb));
			return;
		}

		for (int i = 0; i < word.length(); i++) {
			if (!check[i]) {
				check[i] = true;
				sb.append(word.charAt(i));
				helper(res, sb, check, word);
				sb.deleteCharAt(sb.length() - 1);
				check[i] = false;
			}
		}
	}
}

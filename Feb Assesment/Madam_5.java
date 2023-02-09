package Feb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Madam_5 {
	public static void main(String[] args) {
		System.out.println("Enter the word : ");
		String word = TwoFriends_1.s.nextLine();
		System.out.println("Enter the number of inputs : ");
		int[][] sizes = new int[TwoFriends_1.s.nextInt()][2];

		for (int i = 0; i < sizes.length; i++) {
			for (int j = 0; j < sizes[i].length; j++) {
				System.out.println("Enter the element : ");
				sizes[i][j] = TwoFriends_1.s.nextInt();
			}
		}

		helper(word, sizes);
	}

	public static void helper(String word, int[][] sizes) {
		int testes = 1;
		for (int[] i : sizes) {
			List<Integer> size = new ArrayList<>();
			String input = word.substring(i[0] - 1, i[1]);

			combinaton(input, new boolean[input.length()], size, new HashSet<>(), new StringBuilder());

			//Sorted the list of size to get the maximum size count 
			Collections.sort(size);
			int count = 1;

			for (int a = size.size() - 2; a >= 0; a--) {
				if (size.get(a) != size.get(a + 1)) {
					break;
				} else
					count++;
			}

			System.out.println(testes++ + " : " + count);
		}
	}

	public static void combinaton(String word, boolean check[], List<Integer> size, Set<String> pals,
			StringBuilder up) {
		for (int i = 0; i < word.length(); i++) {
			if (!check[i]) {
				check[i] = true;
				up.append(word.charAt(i));

				// Used set to avoid duplicate values
				if (isPalindrome(new String(up)) && pals.add(new String(up))) {
					size.add(up.length());
				}
				combinaton(word, check, size, pals, up);
				up.deleteCharAt(up.length() - 1);
				check[i] = false;
			}
		}

	}

	public static boolean isPalindrome(String word) {
		int i = 0, j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) != word.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

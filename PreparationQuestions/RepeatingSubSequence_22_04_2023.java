package PreparationQuestions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
 *  4. 	Given a string, find if there is any subsequence of length 2 or more that repeats itself such that the two subsequences don’t have the same character at the same position, i.e., any 0’th or 1st character in the two subsequences shouldn’t have the same index in the original string. [Longest common sequence problem]

		Input: ABCABD
		Output: Repeated Subsequence Exists (A B is repeated) 
		
		Input: ABBB
		Output: Repeated Subsequence Exists (B B is repeated)
		
		Input: AAB
		Output: Repeated Subsequence Doesn't Exist (Note that 
		A B cannot be considered as repeating because B is at
		same position in two subsequences).
		
		Input: AABBC
		Output: Repeated Subsequence Exists (A B is repeated)
		
		Input: ABCDACB
		Output: Repeated Subsequence Exists (A B is repeated)
		
		Input: ABCD
		Output: Repeated Subsequence Doesn't Exist
 */

public class RepeatingSubSequence_22_04_2023 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the word : ");
		String word = scanner.next().toUpperCase();
		String word1 = word;
		if (repeatingSubsequence(word)) {
			System.out.println("Exist ");
		} else {
			System.out.println("Not Exist");
		}
		if (repeatingSubsequence1(word1)) {
			System.out.println("Exist ");
		} else {
			System.out.println("Not Exist");
		}
	}

	// used method
	public static boolean repeatingSubsequence1(String word) {
		int[] freq = new int[26];

		for (int i = 0; i < word.length(); i++) {
			freq[word.charAt(i) - 'A']++;
		}

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == 1) {
				char ch = (char) ('A' + i);
				word = word.replace(ch + "", "");
			}
		}
		if (word.isEmpty()) {
			return false;
		}

		String res = "" + word.charAt(0);

		int check = 2;

		for (int i = 1; i < word.length(); i++) {
			if (res.indexOf(word.charAt(i)) != -1) {
				res += word.charAt(i);
				check--;
				if (check <= 0 && !isPalindrome(res)) {
					return true;
				}
			} else
				res += word.charAt(i);
		}
		return false;

	}

	public static boolean isPalindrome(String word) {
		if (word.length() == 3 && word.charAt(0) == word.charAt(1) && word.charAt(1) == word.charAt(2)) {
			return false;
		}
		int i = 0, j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// few edge cases wont pass like DACAD
	public static boolean repeatingSubsequence(String word) {
		Set<Character> set = new HashSet<>();

		int check = 2;

		for (int i = 0; i < word.length(); i++) {
			if (!set.add(word.charAt(i))) {
				check--;
				if (check == 0) {
					return true;
				}
			}
		}
		return false;
	}
}

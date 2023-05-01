package PreparationQuestions;

public class WordSearch_29_04_2023 {

	public static void main(String[] args) {
		char[][] chars = { { 'a', 'z', 'o', 'l' }, { 'n', 'x', 'h', 'o' }, { 'v', 'y', 'i', 'v' },
				{ 'o', 'r', 's', 'e' } };
		String[] words = { "van", "zoho", "love", "are", "is" };
		wordSearch(chars, words);
	}

	public static void wordSearch(char[][] chars, String[] words) {
		for (int i = 0; i < words.length; i++) {
			char req = words[i].charAt(0);
			outer: for (int r = 0; r < chars.length; r++) {
				for (int c = 0; c < chars[0].length; c++) {
					if (req == chars[r][c] && helper(words[i], chars, 1, r, c)) {
						System.out.println(words[i]);
						break outer;
					}
				}
			}
		}
	}

	public static boolean helper(String word, char[][] chars, int i, int row, int col) {
		if (i == word.length()) {
			return true;
		}

		if (row < chars.length - 1 && chars[row + 1][col] == word.charAt(i)
				&& helper(word, chars, i + 1, row + 1, col)) {
			return true;
		}

		if (col < chars[0].length - 1 && chars[row][col + 1] == word.charAt(i)
				&& helper(word, chars, i + 1, row, col + 1)) {
			return true;
		}

		return false;
	}

}

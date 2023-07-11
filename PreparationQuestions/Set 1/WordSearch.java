package PreparationQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

	public static void main(String[] args) {
		char[][] arr = { { 'W', 'E', 'L', 'C', 'O' }, { 'M', 'E', 'T', 'O', 'Z' }, { 'O', 'H', 'O', 'C', 'O' },
				{ 'R', 'P', 'O', 'R', 'A' }, { 'T', 'I', 'O', 'N', ' ' } };
		wordSearch(arr, "too");
	}

	private static void wordSearch(char[][] arr, String word) {
		word = word.toUpperCase();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == word.charAt(0))
					bfs(arr, word, i, j);
			}
		}
	}

	private static void bfs(char[][] arr, String word, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		int ind = 1;
		while (!queue.isEmpty() && ind < word.length()) {
			Queue<int[]> inner = new LinkedList<>();
			while (!queue.isEmpty()) {
				int row = queue.peek()[0];
				int col = queue.poll()[1];
				if (row + 1 < arr.length && arr[row + 1][col] == word.charAt(ind)) {
					if (ind == word.length() - 1) {
						System.out.println("start = " + r + "," + c);
						System.out.println("end = " + (row + 1) + "," + col);
					} else
						inner.offer(new int[] { row + 1, col });
				}

				if (col + 1 < arr[row].length && arr[row][col + 1] == word.charAt(ind)) {
					if (ind == word.length() - 1) {
						System.out.println("start = " + r + "," + c);
						System.out.println("end = " + row + "," + (col + 1));
					} else
						inner.offer(new int[] { row, col + 1 });
				}

			}
			queue = inner;
			ind++;
		}
	}

}

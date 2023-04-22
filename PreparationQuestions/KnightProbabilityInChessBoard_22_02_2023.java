package PreparationQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 688. Knight Probability in Chessboard
 */

public class KnightProbabilityInChessBoard_22_02_2023 {

	public static void main(String[] args) {
		System.out.println(knightProbability(8, 30, 6, 4));
	}

	public static double knightProbability(int n, int k, int row, int column) {
		if (k == 0) {
			return 1;
		}
		double[][][] grid = new double[n][n][k + 1];

		return helper(k, n, row, column, grid);
	}

	public static double helper(int k, int n, int row, int col, double[][][] grid) {
		if (k == 1) {
			return findPosibleMoves(row, col, n).size() / 8.0;
		}
		if (grid[row][col][k] != 0) {
			return grid[row][col][k];
		}
		Queue<int[]> moves = findPosibleMoves(row, col, n);
		int size = moves.size();
		double res = size / 8.0;
		double got = 0;
		while (!moves.isEmpty()) {
			int r = moves.peek()[0];
			int c = moves.poll()[1];
			got += helper(k - 1, n, r, c, grid);
		}
		if (got != 0)
			got /= size;
		res *= got;
		grid[row][col][k] = res;
		return res;
	}

	public static Queue<int[]> findPosibleMoves(int i, int j, int n) {
		Queue<int[]> moves = new LinkedList<>();

		if (i + 2 < n && j + 1 < n) {
			moves.add(new int[] { i + 2, j + 1 });
		}
		if (i + 2 < n && j - 1 >= 0) {
			moves.add(new int[] { i + 2, j - 1 });
		}

		if (i + 1 < n && j + 2 < n) {
			moves.add(new int[] { i + 1, j + 2 });
		}
		if (i - 1 >= 0 && j + 2 < n) {
			moves.add(new int[] { i - 1, j + 2 });
		}

		if (i - 2 >= 0 && j + 1 < n) {
			moves.add(new int[] { i - 2, j + 1 });
		}
		if (i - 2 >= 0 && j - 1 >= 0) {
			moves.add(new int[] { i - 2, j - 1 });
		}

		if (i - 1 >= 0 && j - 2 >= 0) {
			moves.add(new int[] { i - 1, j - 2 });
		}
		if (i + 1 < n && j - 2 >= 0) {
			moves.add(new int[] { i + 1, j - 2 });
		}
		return moves;
	}

}

package PreparationQuestions;

public class SudukoValidation {

	public static void main(String[] args) {
		int[][] board = {{5, 3, 4, 6, 7, 8, 9, 1, 2},
	            {6, 7, 2, 1, 9, 5, 3, 4, 8},
	            {1, 9, 8, 3, 4, 2, 5, 6, 7},
	            {8, 5, 9, 7, 6, 1, 4, 2, 3},
	            {4, 2, 6, 8, 5, 3, 7, 9, 1},
	            {7, 1, 3, 9, 2, 4, 8, 5, 6},
	            {9, 6, 1, 5, 3, 7, 2, 8, 4},
	            {2, 8, 7, 4, 1, 9, 6, 3, 5},
	            {3, 4, 5, 2, 8, 6, 1, 7, 9} };
		if(evaluate(board))
			System.out.println("valid");
		else
			System.out.println("invalid");
	}

	public static boolean evaluate(int[][] board) {
		if(!smallBoxCheck(board))
			return false;
		for(int i = 0;i<board.length;i++) {
			if(!rowColCheck(board, i, i))
				return false;
		}
		return true;
	}

	public static boolean smallBoxCheck(int[][] board) {
		int[] hash = new int[10];
		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board.length; j += 3) {

				for (int r = i; r < i + 3; r++) {
					for (int c = j; c < j + 3; c++) {
						int ind = board[r][c];
						hash[ind - 1]++;
						if (hash[ind - 1] > 1)
							return false;
					}
				}

				refill(hash);
			}
		}
		return true;
	}

	public static boolean rowColCheck(int[][] board, int row, int col) {
		int[] hash = new int[10];
		for (int i = 0; i < board.length; i++) {
			int ind = board[i][col];
			hash[ind - 1]++;
			if (hash[ind - 1] > 1)
				return false;
		}
		refill(hash);
		for (int i = 0; i < board.length; i++) {
			int ind = board[row][i];
			hash[ind - 1]++;
			if (hash[ind - 1] > 1)
				return false;
		}
		return true;
	}

	public static void refill(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;
	}

}

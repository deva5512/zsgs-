package tictactoe;

import java.util.Scanner;

public class TicTacToe {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		char[][] board = new char[3][3];
		boolean[][] check = new boolean[board.length][board.length];

		char sign = 'X';

		int no = 1;
		while (true) {

			print(board);

			System.out.println("\n" + sign + " turn : ");

			int row = input("Select the row ( 1 - 3 ) : ");

			int col = input("Select the col ( 1 - 3 ) : ");

			if (check[row][col]) {
				System.out.println("Alredy Marked ");
				continue;
			}
			board[row][col] = sign;
			check[row][col] = true;

			if (no > 3) {
				if (horside(board, row, col, sign) || diagnol(board, sign)) {
					System.out.println("Winner is " + sign);
					return;
				}
				if (no == 9) {
					break;
				}
			}
			no++;
			if (sign == 'X') {
				sign = 'O';
			} else {
				sign = 'X';
			}
		}
		System.out.println("Draw");
		s.close();

	}

	public static int input(String string) {
		while (true) {
			System.out.print(string);
			try {
				int res = s.nextInt();
				s.nextLine();
				if (res > 0 && res < 4) {
					return res - 1;
				} else {
					System.out.println("Enter a valid input ");
				}
			} catch (Exception e) {
				s.nextLine();
				System.out.println("Invalid input ");
			}
		}
	}

	public static void print(char[][] board) {
		System.out.println("    1   2   3");

		for (int i = 0; i < board.length; i++) {
			System.out.print("  -------------\n");
			for (int j = 0; j < board.length; j++) {

				if (j == 0) {
					System.out.print((i + 1) + " ");
				}

				System.out.print("| " + board[i][j] + " ");
				if (j == board.length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i == board.length - 1) {
				System.out.print("  -------------");
			}
		}
	}

	public static boolean horside(char[][] board, int i, int j, char sign) {
		if (j != 0 && j != board.length - 1 && board[i][j - 1] == sign && board[i][j + 1] == sign) {
			return true;
		}
		if (i != 0 && i != board.length - 1 && board[i - 1][j] == sign && board[i + 1][j] == sign) {
			return true;
		}
		boolean ver = true;
		for (int a = 0; a < board.length; a++) {
			if (board[a][j] != sign) {
				ver = false;
			}
		}
		if (ver) {
			return ver;
		}
		ver = true;
		for (int a = 0; a < board.length; a++) {
			if (board[i][a] != sign) {
				ver = false;
			}
		}
		return ver;
	}

	public static boolean diagnol(char[][] board, char sign) {
		int mid = board.length / 2;
		if (board[mid][mid] != sign) {
			return false;
		}
		if (board[mid - 1][mid - 1] == sign && board[mid + 1][mid + 1] == sign) {
			return true;
		}
		if (board[mid - 1][mid + 1] == sign && board[mid + 1][mid - 1] == sign) {
			return true;
		}
		return false;
	}
}

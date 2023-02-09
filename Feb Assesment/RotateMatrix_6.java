package Feb;

import java.util.Arrays;

public class RotateMatrix_6 {
	public static void main(String[] args) {
		System.out.println("Enter the row size : ");
		int row = TwoFriends_1.s.nextInt();
		System.out.println("Enter the col size :");
		int[][] num = new int[row][TwoFriends_1.s.nextInt()];

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print("Enter the " + i + " " + j + "Element : ");
				num[i][j] = TwoFriends_1.s.nextInt();
			}
		}

//		int[][] num = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(num);

		for (int[] i : num) {
			System.out.println(Arrays.toString(i));
		}

	}

	public static void rotate(int[][] num) {
		transpose(num);

		
		//Transposed the matrix and changed the swap the row indexes 
		for (int i = 0; i < num[0].length; i++) {
			int top = 0, down = num.length - 1;
			while (top < down) {
				int temp = num[top][i];
				num[top][i] = num[down][i];
				num[down][i] = temp;
				top++;
				down--;
			}
		}
	}

	public static void transpose(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}

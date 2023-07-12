package PreparationQuestions.Set4;

public class SpiralPrinting {

	public static void main(String[] args) {
		int n = 12, m = 6;
		spiral(n, m);
	}

	private static void spiral(int n, int m) {
		char[][] arr = new char[n][m];
		int rs = 0, cs = 0, re = n - 1, ce = m - 1;
		char ch = 'X';
		while (rs <= re && cs <= ce) {
			for (int i = cs; i <= ce; i++) {
				arr[rs][i] = ch;
			}
			rs++;
			for (int i = rs; i <= re; i++) {
				arr[i][ce] = ch;
			}
			ce--;
			if (rs <= re)
				for (int i = ce; i >= cs; i--) {
					arr[re][i] = ch;
				}
			re--;
			if (cs <= ce)
				for (int i = re; i >= rs; i--) {
					arr[i][cs] = ch;
				}
			cs++;
			if (ch == 'X')
				ch = 'O';
			else
				ch = 'X';
		}

		print(arr);
	}

	private static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (char j : arr[i])
				System.out.print(j + " ");
			System.out.println();
		}
	}

}

package Feb;

public class Patten_9 {
	public static void main(String[] args) {
		System.out.println("Enter the size of the patten : ");
		int size = TwoFriends_1.s.nextInt();
		patten(size);
	}

	public static void patten(int num) {
		int[][] array = new int[num][num];
		int rowstart = 0, rowend = array.length - 1;
		int colstart = 0, colend = array.length - 1;

		int a = 1;
		while (rowstart <= rowend && colstart <= colend) {

			for (int i = colstart; i <= colend; i++) {
				array[rowstart][i] = a;
			}
			rowstart++;
			for (int i = rowstart; i <= rowend; i++) {
				array[i][colend] = a;
			}
			colend--;
			for (int i = colend; i >= colstart; i--) {
				array[rowend][i] = a;
			}
			rowend--;
			for (int i = rowend; i >= rowstart; i--) {
				array[i][colstart] = a;
			}
			colstart += 2;
			rowstart++;
			colend--;
			rowend--;
		}

		for (int arr[] : array) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

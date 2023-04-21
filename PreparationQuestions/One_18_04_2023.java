package PreparationQuestions;

import java.util.LinkedList;
import java.util.List;

public class One_18_04_2023 {
	public static void main(String[] args) {
		circleGame(9, 4);
	}

	public static void circleGame(int num, int x) {
		int temp = x - 1;

		List<Integer> list = new LinkedList<>();

		for (int i = 1; i <= num; i++) {
			list.add(i);
		}

		int ind = 0;
		while (list.size() >= x) {
			ind = find_Index(ind, temp, num--);
			System.out.print(list.remove(ind) + " ");
		}
	}

	public static int find_Index(int ind, int plus, int size) {
		if (ind + plus > size) {
			return plus - (size - ind);
		}
		return ind + plus;
	}
}

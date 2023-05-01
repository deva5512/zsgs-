package PreparationQuestions;

import java.util.ArrayList;
import java.util.List;

public class NtnNumberWithOnly3And4_29_04_2023 {

	public static void main(String[] args) {
		getNtindexWith3and4(14);
	}

	public static void getNtindexWith3and4(int n) {
		List<String> list = new ArrayList<>();
		list.add("");
		int start = 0;
		while (list.size() <= n) {
			int pre = list.size();
			int size = list.size();

			for (int i = start; i < size && list.size() < n + 1; i++) {
				String got = "3" + list.get(i);
				list.add(got);
			}

			for (int i = start; i < size && list.size() < n + 1; i++) {
				String got = "4" + list.get(i);
				list.add(got);
			}
			start = pre;
		}
		System.out.println(list.get(n));
	}
}

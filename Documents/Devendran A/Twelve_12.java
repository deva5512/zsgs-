package zohosums;

import java.util.ArrayList;
import java.util.Iterator;

public class Twelve_12 {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(7);
		a.add('.');
		a.add(50);

		Iterator i = a.iterator();

		while (i.hasNext()) {
			System.out.print(i.next());
		}
	}
}

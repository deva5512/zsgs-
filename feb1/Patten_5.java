package feb1;

import java.util.Scanner;

public class Patten_5 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		Patten_5 p = new Patten_5();
		System.out.println("Enter the input : ");
		int num = s.nextInt();
		p.print(num);
		s.close();
	}

	public void print(int num) {

		int temp = num - 1;
		int val = 0;

		for (int i = 1; i <= num; i++) {
			val = i;
			for (int j = 0; j < i; j++) {
				System.out.print(val + " ");
				val += temp--;
			}
			System.out.println();
			temp = num - 1;
		}

	}
}

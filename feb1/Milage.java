package feb1;

import java.util.Scanner;

public class Milage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of bikes : ");
		int input = sc.nextInt();
		sc.nextLine();

		Bike b[] = new Bike[input];
		double milage[] = new double[input];

		for (int i = 0; i < input; i++) {
			System.out.print("Name : ");
			String name = sc.nextLine();
			System.out.print("runs : ");
			double runs = sc.nextDouble();
			sc.nextLine();
			System.out.print("consume : ");
			double counsume = sc.nextDouble();
			sc.nextLine();

			Bike bike = new Bike(name, runs, counsume);
			double mil = runs / counsume;

			milage[i] = mil;
			b[i] = bike;
		}
		sort(milage, b);

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static void sort(double[] m, Bike[] b) {
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m.length - 1; j++) {
				if (m[j] < m[j + 1]) {
					double temp = m[j];
					m[j] = m[j + 1];
					m[j + 1] = temp;

					Bike tempr = b[j];
					b[j] = b[j + 1];
					b[j + 1] = tempr;
				}
			}
		}
	}

}

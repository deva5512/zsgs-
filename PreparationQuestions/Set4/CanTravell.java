package PreparationQuestions.Set4;

public class CanTravell {

//	Petrol in car: 2 Liters
//	Petrol bunks: A B C
//	Distance from petrol each petrol bunks: 1, 5, 3
//	Capacities of each petrol bunk: 6, 4, 2
//	Output:
//	Remaining petrol in car is 5 liters

	public static void main(String[] args) {
		int have = 2;
		int[] dis = { 1, 5, 3 };
		int[] petrol = { 4, 3, 2 };
		travell(have, dis, petrol);
	}

	private static void travell(int have, int[] dis, int[] petrol) {

		for (int i = 0; i < dis.length; i++) {
			have = have - dis[i];
			if (have < 0) {
				System.out.println("cant be reached");
				return;
			}
			have += petrol[i];
		}
		System.out.println("Remaining with " + have);
	}

}

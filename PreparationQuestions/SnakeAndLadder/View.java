package PreparationQuestions.SnakeAndLadder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class View {

	private static Model model = new Model();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t\tSnake and Ladder\n");
		View view = new View();
		view.caller();
	}

	public void caller() {
		System.out.print("Enter the size of the board : ");
//		int size = scanner.nextInt();
//		scanner.nextLine();
		int size = 10;

		model.createBoard(size);

		// by using size determine weather the input is correct or not
		// and also check whether the user giving the repeated input or not
		size *= size;
		// getInputForLadder(size);
		Map<Integer, Integer> ladders = new HashMap<>();
		ladders.put(5, 60);
		ladders.put(25, 48);
		ladders.put(42, 80);

		// dont allow the user to give the same input again in the snake and make the
		// infinite loop
		// getInputForSnakes(size, ladders);
		Map<Integer, Integer> snakes = new HashMap<>();
		snakes.put(21, 3);
		snakes.put(92, 68);
		snakes.put(65, 32);
		snakes.put(78, 61);
		snakes.put(99, 43);

		Queue<Player> players = getPlayerDetails();

		model.startGame(ladders, snakes, players);
		startGame();
	}

	private void startGame() {
		boolean controller = true;

		do {
			printPlayersStatus();
			printBoard();
			Player player = model.whoseTurn();
			System.out.println(player.getName() + "'s turn \nPress Enter to roll ");
			scanner.nextLine();
			int currentpostion = player.getPosition();
			int moved = model.rollDice(player);
			if (moved == -1) {
				break;
			}
			int rolled = player.getPosition() - currentpostion;
			if (moved != -15 && moved != 15) {

				if (rolled == 0)
					System.out.println("\n" + player.getName() + " has Rolled " + moved + " \nBetter Luck Next Time ");
				else
					System.out.println("\n" + player.getName() + " has rolled " + moved + " and moved from "
							+ currentpostion + " to " + player.getPosition());
			} else {
				if (moved == 15)
					System.out.println("\nGot ladder ");
				else
					System.out.println("\nYou Got Bit from Snake Oops");
				System.out.println(
						"\n" + player.getName() + " moved from " + currentpostion + " to " + player.getPosition());
			}
		} while (controller);

		System.out.println("Match Over ");

		printStatus();

	}

	private void printStatus() {
		List<Player> players = model.getCompletedPlayers();

		for (int i = 0; i < players.size(); i++) {
			System.out.println("\tCompleted " + (i + 1));
			Player player = players.get(i);
			System.out.println(" Player Name : " + player.getName());
			System.out.println(" Player NickName : " + player.getNickName());
		}
	}

	private void printBoard() {
		String[][] board = model.getBoard();

		for (String[] a : board) {
			System.out.println(Arrays.toString(a));
		}
	}

	private void printPlayersStatus() {
		List<Player> players = model.getPlayers();
		System.out.println();
		for (Player p : players) {
			System.out.print(p);
		}
		System.out.println();
	}

	private Queue<Player> getPlayerDetails() {
		System.out.print("Enter the number of players : ");
		int size = scanner.nextInt();
		scanner.nextLine();
		Queue<Player> players = new LinkedList<>();

		for (int i = 0; i < size; i++) {
			System.out.print("Enter the player " + (i + 1) + " Name : ");
			String name = scanner.nextLine();
			Player player = new Player(name);
			players.add(player);
		}
		return players;
	}

	private Map<Integer, Integer> getInputForLadder(int size) {
		System.out.print("Enter the number of ladder : ");
		int s = scanner.nextInt();
		scanner.nextLine();

		Map<Integer, Integer> ladders = new HashMap<>();

		for (int i = 0; i < s; i++) {
			System.out.print("Enter the bottom of the " + (i + 1) + " ladder : ");
			int bottom = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter the top of the " + (i + 1) + " ladder : ");
			int top = scanner.nextInt();
			scanner.nextLine();

			ladders.put(bottom, top);
		}
		return ladders;
	}

	private Map<Integer, Integer> getInputForSnakes(int size, Map<Integer, Integer> ladder) {
		System.out.print("Enter the number of snakes : ");
		int s = scanner.nextInt();
		scanner.nextLine();

		Map<Integer, Integer> snakes = new HashMap<>();

		for (int i = 0; i < s; i++) {
			System.out.println("Enter the head of the " + (i + 1) + " snake : ");
			int head = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter the tail of the " + (i + 1) + " snake : ");
			int tail = scanner.nextInt();
			scanner.nextLine();

			snakes.put(head, tail);
		}
		return snakes;
	}

}

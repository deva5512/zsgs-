package PreparationQuestions.SnakeAndLadder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Model {

	String[][] board;
	int winningposition;

	List<Player> completed = new LinkedList<>();
	Map<Integer, Integer> ladders;
	Map<Integer, Integer> snakes;
	Queue<Player> players;
	List<Player> playerslist;

	public void createBoard(int size) {
		board = new String[size][size];
		winningposition = size * size;
		fillTheBoard(size);
	}

	public String[][] getBoard() {
		return board;
	}

	public List<Player> getPlayers() {
		return playerslist;
	}

	public List<Player> getCompletedPlayers() {
		return completed;
	}

	private void fillTheBoard(int size) {

		boolean check = size % 2 == 0;

		int num = 1;
		for (int i = size - 1; i >= 0; i--) {
			if (i % 2 == 0 == check)
				for (int j = size - 1; j >= 0; j--) {
					board[i][j] = "" + num++;
				}
			else
				for (int j = 0; j < size; j++) {
					board[i][j] = "" + num++;
				}
		}
	}

	// in snake first one is head
	// in ladder first one is bottom
	public void startGame(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes, Queue<Player> players) {
		this.players = players;
		this.ladders = ladders;
		this.snakes = snakes;
		this.playerslist = new ArrayList<>(players);

		Iterator<Integer> ladderiterator = ladders.keySet().iterator();

		int count = 1;
		while (ladderiterator.hasNext()) {
			int bottom = ladderiterator.next();
			int top = ladders.get(bottom);

			int[] position = findPosition(bottom);
			board[position[0]][position[1]] = "L" + count + "B";

			position = findPosition(top);
			board[position[0]][position[1]] = "L" + count++ + "T";
		}

		Iterator<Integer> snakeiterator = snakes.keySet().iterator();

		count = 1;
		while (snakeiterator.hasNext()) {
			int head = snakeiterator.next();
			int tail = snakes.get(head);

			int[] position = findPosition(head);
			board[position[0]][position[1]] = "S" + count + "H";

			position = findPosition(tail);
			board[position[0]][position[1]] = "S" + count++ + "T";
		}
	}

	public int[] findPosition(int position) {

		int size = board.length;
		boolean right = size % 2 != 0;

		int row = position / size;
		int col = 0;

		if (position % size == 0) {
			row--;
		}

		row = (size - 1) - row;
		col = (position % size) - 1;

		if (col == -1) {
			col = size - 1;
		}

		if (row % 2 == 0 != right) {
			col = (size - 1) - col;
		}

		return new int[] { row, col };
	}

	public static int roll() {
		return (int) (Math.random() * 6) + 1;
	}

	public int rollDice(Player player) {

		int pos = player.getPosition();
		if (pos != 0 && !ladders.containsKey(pos) && !snakes.containsKey(pos) && !snakes.values().contains(pos)
				&& !ladders.values().contains(pos)) {
			int[] position = findPosition(pos);
			board[position[0]][position[1]] = "" + pos;
		}

		int jackpot = roll();
		pos += jackpot;

		if (pos <= winningposition) {

			if (ladders.containsKey(pos)) {
				jackpot = 15;
				player.setPosition(ladders.get(pos));
			} else if (snakes.containsKey(pos)) {
				jackpot = -15;
				player.setPosition(snakes.get(pos));
			} else {
				if (!ladders.containsKey(pos) && !snakes.containsKey(pos) && !snakes.values().contains(pos)
						&& !ladders.values().contains(pos)) {
					int[] position = findPosition(pos);
					board[position[0]][position[1]] = player.getNickName();
				}
				player.setPosition(pos);
			}
		}

		if (pos == winningposition) {
			completed.add(player);
			playerslist.remove(player);
		} else {
			players.add(player);
		}

		if (players.size() == 1) {
			return -1;
		} else
			return jackpot;
	}

	public Player whoseTurn() {
		return players.poll();
	}

}

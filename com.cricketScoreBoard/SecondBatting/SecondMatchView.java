package secondbatting;

import java.util.Arrays;
import java.util.Scanner;

import com.cricketscoremanagement.dto.ScoreBoard;
import com.cricketscoremanagement.dto.Teleporter;

public class SecondMatchView implements Teleporter, SecondViewCallBack {
	private Scanner scanner = new Scanner(System.in);

	private SecondViewControllerCall secondcontroller;

	public SecondMatchView() {
		this.secondcontroller = new SecondMatchController(this);
	}

	@Override
	public void caller() {
		System.out.println(secondcontroller.getTeam2name() + " Batting : \n Required Runs to win :"
				+ (secondcontroller.getpreviousScore() + 1));
		startmatch();
	}

	private void startmatch() {

		ScoreBoard board = secondcontroller.getScoreBoard();

		while (!secondcontroller.isTeam2Out(board.getScore())) {

			int index = board.getInd();
			printScoreBoard();
			boolean move = true;

			board.getp1().setStatus("Not Out");
			board.getp2().setStatus("Not Out");

			System.out.println("\n0) 0 run \n1) 1 run \n2) 2 runs \n4) 4 runs \n6) 6 runs \n9) Out");

			System.out.print("\nEnter your input :");
			int input = scanner.nextInt();
			scanner.nextLine();

			switch (input) {
			case 0: {
				board.getBalls()[index] = '0';
				break;
			}
			case 1: {
				secondcontroller.swap();
				board.setScore(board.getScore() + 1);
				board.getp1().setIndevidual_score(board.getp1().getIndevidual_score() + 1);
				board.getp1().setNo_of_balls(board.getp1().getNo_of_balls() + 1);
				board.getBalls()[index] = '1';
				break;
			}
			case 2: {
				board.setScore(board.getScore() + 2);
				board.getp1().setIndevidual_score(board.getp1().getIndevidual_score() + 2);
				board.getp1().setNo_of_balls(board.getp1().getNo_of_balls() + 1);
				board.getBalls()[index] = '2';
				break;
			}
			case 4: {
				board.setScore(board.getScore() + 4);
				board.getp1().setIndevidual_score(board.getp1().getIndevidual_score() + 4);
				board.getp1().setNo_of_balls(board.getp1().getNo_of_balls() + 1);
				board.getBalls()[index] = '4';
				break;
			}
			case 6: {
				board.setScore(board.getScore() + 6);
				board.getp1().setIndevidual_score(board.getp1().getIndevidual_score() + 6);
				board.getp1().setNo_of_balls(board.getp1().getNo_of_balls() + 1);
				board.getBalls()[index] = '6';
				break;
			}
			case 9: {
				board.getp1().setStatus("Out");
				secondcontroller.changeBatsman();
				board.getbow().setNumberofWickets(board.getbow().getNumberofWickets() + 1);
				board.setWickets(board.getWickets() + 1);
				board.getBalls()[index] = 'W';
				break;
			}
			default: {
				System.out.println(" Wide ");
				board.setScore(board.getScore() + 1);
				move = false;
			}
			}

			if (move) {
				board.setInd(index + 1);
				board.getbow().setNumberofballsput(board.getbow().getNumberofballsput() + 1);
				board.setNumberofballs(board.getNumberofballs() + 1);
			}

			if (board.getInd() == 6) {
				board.setbow(secondcontroller.getabowler());
				secondcontroller.setScore();
				Arrays.fill(board.getBalls(), '0');
				secondcontroller.increaseOver();
			}

		}

		System.out.println(secondcontroller.getTeam2name() + " Match has been ended \nScores : "
				+ secondcontroller.getScoreBoard().getScore() + "\n");

		int score = secondcontroller.getpreviousScore();

		if (score < secondcontroller.getScoreBoard().getScore()) {
			secondcontroller.setwinneras(secondcontroller.getTeam2name());
		} else if (score == secondcontroller.getScoreBoard().getScore()) {
			secondcontroller.setwinneras("Draw");
		}

	}

	private void printScoreBoard() {

		ScoreBoard score = secondcontroller.getScoreBoard();

		System.out.println(" +------------------------------------------------+");
		System.out.printf(" | %28s %19s \n", "Score Board ", "|");
		System.out.println(" +------------------------------------------------+");
		System.out.printf(" | %-20s :    %-20s %s\n", "Player 1", score.getPlayer1(), "|");
		System.out.printf(" | %-20s :    %-20s %s\n", "Player 2", score.getPlayer2(), "|");
		System.out.printf(" | %-20s :    %-20s %s\n", "Batting Team", score.getBatting_team(), "|");
		System.out.printf(" | %-20s :    %-20s %s\n", "Bowling Team", score.getBowling_team(), "|");
		System.out.printf(" | %-20s :    %-20s %s\n", "Bowler", score.getBowler(), "|");
		System.out.printf(" | %-20s :    %-20d %s\n", "Scores", score.getScore(), "|");
		System.out.printf(" | %-20s :    %-20d %s\n", "Wickets", score.getWickets(), "|");
		System.out.printf(" | %-20s :    %-20d %s\n", "Ball Number", score.getNumberofballs(), "|");
		System.out.printf(" | %-20s :    %-20d %s\n", "Required Runs", score.getRequired_to_win() - score.getScore(),
				"|");
		System.out.printf(" | %-20s :    %d - %-16d %s\n", "Over", score.getOver(), score.getInd(), "|");
		if (score.getNumberofballs() != 0)
			System.out.printf(" | %-20s :    %-19d  %s\n", "Strike Rate",
					(score.getScore() / score.getNumberofballs() * 100), "|");
		System.out.printf(" | %48s\n", "|");
		System.out.println(" |             " + Arrays.toString(score.getBalls()) + "                 |");
		System.out.printf(" | %48s\n", "|");
		System.out.println(" +------------------------------------------------+");
	}

}

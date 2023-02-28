package firstbatting;

import java.util.Arrays;

import com.cricketscoremanagement.dto.GetInput;
import com.cricketscoremanagement.dto.ScoreBoard;
import com.cricketscoremanagement.dto.Teleporter;

public class FirstMatchView implements FirstMatchViewCallBack, Teleporter {

	private FirstMatchViewControllerCall firstcontroller;

	public FirstMatchView() {
		this.firstcontroller = new FirstMatchController(this);
	}

	@Override
	public void caller() {
		System.out.println(firstcontroller.getTeam1name() + " Batting");
		startmatch();
	}

	private void startmatch() {

		while (!firstcontroller.isTeam1Out()) {

			ScoreBoard board = firstcontroller.getScoreBoard();

			firstcontroller.setStatus(board.getp1(), "Not Out");
			firstcontroller.setStatus(board.getp2(), "Not Out");

			int index = board.getInd();
			printScoreBoard();
			boolean move = true;

			System.out.println("\n0) 0 run \n1) 1 run \n2) 2 runs \n4) 4 runs \n6) 6 runs \n9) Out");

			int input = GetInput.getInt();

			switch (input) {
			case 0: {
				firstcontroller.setBallindex(board.getBalls(), index, '0');
				break;
			}
			case 1: {
				firstcontroller.setscore(board, 1);
				firstcontroller.increaseIndividual(board.getp1(), 1);
				firstcontroller.setBallindex(board.getBalls(), index, '1');
				firstcontroller.swap();
				break;
			}
			case 2: {
				firstcontroller.setscore(board, 2);
				firstcontroller.increaseIndividual(board.getp1(), 2);
				firstcontroller.setBallindex(board.getBalls(), index, '2');
				break;
			}
			case 4: {
				firstcontroller.setscore(board, 4);
				firstcontroller.increaseIndividual(board.getp1(), 4);
				firstcontroller.setBallindex(board.getBalls(), index, '4');
				break;
			}
			case 6: {
				firstcontroller.setscore(board, 6);
				firstcontroller.increaseIndividual(board.getp1(), 6);
				firstcontroller.setBallindex(board.getBalls(), index, '6');
				break;
			}
			case 9: {
				firstcontroller.setStatus(board.getp1(), "Out");
				firstcontroller.changeBatsman();
				firstcontroller.gotWicket(board);
				firstcontroller.setBallindex(board.getBalls(), index, 'W');
				break;
			}
			default: {
				System.out.println(" Wide ");
				firstcontroller.setscore(board, 1);
				move = false;
			}
			}

			if (move) {
				firstcontroller.increseEveryTime(board);
			}

			if (board.getInd() == 6) {
				firstcontroller.swap();
				board.setbow(firstcontroller.getabowler());
				firstcontroller.setScore();
				Arrays.fill(board.getBalls(), '0');
				firstcontroller.increaseOver();
			}

		}

		System.out.println(firstcontroller.getTeam1name() + " Match has been ended \nScores : "
				+ firstcontroller.getScoreBoard().getScore() + "\n");

		firstcontroller.setMatch1Score(firstcontroller.getScoreBoard().getScore());
		firstcontroller.setwinner(firstcontroller.getTeam1name());

	}

	private void printScoreBoard() {

		ScoreBoard score = firstcontroller.getScoreBoard();

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

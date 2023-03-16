package firstbatting;

import java.util.Arrays;

import com.cricketscoremanagement.dto.GetInput;
import com.cricketscoremanagement.dto.ScoreBoard;
import com.cricketscoremanagement.dto.Teleporter;

public class FirstMatchView implements Teleporter {

	private FirstMatchModel firstMatchModel;

	public FirstMatchView() {
		this.firstMatchModel = new FirstMatchModel();
	}

	@Override
	public void caller() {
		System.out.println(firstMatchModel.getTeam1name() + " Batting");
		startmatch();
	}

	private void startmatch() {

		while (!firstMatchModel.isTeam1Out()) {

			ScoreBoard board = firstMatchModel.getScoreBoard();

			firstMatchModel.setStatus(board.getp1(), "Not Out");
			firstMatchModel.setStatus(board.getp2(), "Not Out");

			int index = board.getInd();
			printScoreBoard();
			boolean move = true;

			System.out.println("\n0) 0 run \n1) 1 run \n2) 2 runs \n4) 4 runs \n6) 6 runs \n9) Out");

			int input = GetInput.getInt();

			switch (input) {
			case 0: {
				firstMatchModel.setBallindex(board.getBalls(), index, '0');
				break;
			}
			case 1: {
				firstMatchModel.setscore(board, 1);
				firstMatchModel.increaseIndividual(board.getp1(), 1);
				firstMatchModel.setBallindex(board.getBalls(), index, '1');
				firstMatchModel.swap();
				break;
			}
			case 2: {
				firstMatchModel.setscore(board, 2);
				firstMatchModel.increaseIndividual(board.getp1(), 2);
				firstMatchModel.setBallindex(board.getBalls(), index, '2');
				break;
			}
			case 4: {
				firstMatchModel.setscore(board, 4);
				firstMatchModel.increaseIndividual(board.getp1(), 4);
				firstMatchModel.setBallindex(board.getBalls(), index, '4');
				break;
			}
			case 6: {
				firstMatchModel.setscore(board, 6);
				firstMatchModel.increaseIndividual(board.getp1(), 6);
				firstMatchModel.setBallindex(board.getBalls(), index, '6');
				break;
			}
			case 9: {
				firstMatchModel.setStatus(board.getp1(), "Out");
				firstMatchModel.changeBatsman();
				firstMatchModel.gotWicket(board);
				firstMatchModel.setBallindex(board.getBalls(), index, 'W');
				break;
			}
			default: {
				System.out.println(" Wide ");
				firstMatchModel.setscore(board, 1);
				move = false;
			}
			}

			if (move) {
				firstMatchModel.increseEveryTime(board);
			}

			if (board.getInd() == 6) {
				firstMatchModel.swap();
				board.setbow(firstMatchModel.getabowler());
				firstMatchModel.setScore();
				Arrays.fill(board.getBalls(), '0');
				firstMatchModel.increaseOver();
			}

		}

		System.out.println(firstMatchModel.getTeam1name() + " Match has been ended \nScores : "
				+ firstMatchModel.getScoreBoard().getScore() + "\n");

		firstMatchModel.setMatch1Score(firstMatchModel.getScoreBoard().getScore());
		firstMatchModel.setwinner(firstMatchModel.getTeam1name());

	}

	private void printScoreBoard() {

		ScoreBoard score = firstMatchModel.getScoreBoard();

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

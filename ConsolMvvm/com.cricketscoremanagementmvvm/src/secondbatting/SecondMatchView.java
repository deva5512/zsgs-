package secondbatting;

import java.util.Arrays;

import com.cricketscoremanagement.dto.GetInput;
import com.cricketscoremanagement.dto.ScoreBoard;
import com.cricketscoremanagement.dto.Teleporter;

public class SecondMatchView implements Teleporter {

	private SecondMatchModel secondMatchModel;

	public SecondMatchView() {
		this.secondMatchModel = new SecondMatchModel();
	}

	@Override
	public void caller() {
		System.out.println(secondMatchModel.getTeam2name() + " Batting : \n Required Runs to win :"
				+ (secondMatchModel.getpreviousScore() + 1));
		startmatch();
	}

	private void startmatch() {

		ScoreBoard board = secondMatchModel.getScoreBoard();

		while (!secondMatchModel.isTeam2Out(board.getScore())) {

			int index = board.getInd();
			printScoreBoard();
			boolean move = true;

			secondMatchModel.setStatus(board.getp1(), "Not Out");
			secondMatchModel.setStatus(board.getp2(), "Not Out");

			System.out.println("\n0) 0 run \n1) 1 run \n2) 2 runs \n4) 4 runs \n6) 6 runs \n9) Out");

			int input = GetInput.getInt();

			switch (input) {
			case 0: {
				secondMatchModel.setBallindex(board.getBalls(), index, '0');
				break;
			}
			case 1: {
				secondMatchModel.swap();
				secondMatchModel.setscore(board, 1);
				secondMatchModel.increaseIndividual(board.getp1(), 1);
				secondMatchModel.setBallindex(board.getBalls(), index, '1');
				break;
			}
			case 2: {
				secondMatchModel.setscore(board, 2);
				secondMatchModel.increaseIndividual(board.getp1(), 2);
				secondMatchModel.setBallindex(board.getBalls(), index, '2');
				break;
			}
			case 4: {
				secondMatchModel.setscore(board, 4);
				secondMatchModel.increaseIndividual(board.getp1(), 4);
				secondMatchModel.setBallindex(board.getBalls(), index, '4');
				break;
			}
			case 6: {
				secondMatchModel.setscore(board, 6);
				secondMatchModel.increaseIndividual(board.getp1(), 6);
				secondMatchModel.setBallindex(board.getBalls(), index, '6');
				break;
			}
			case 9: {
				secondMatchModel.setStatus(board.getp1(), "Out");
				secondMatchModel.changeBatsman();
				secondMatchModel.gotWicket(board);
				secondMatchModel.setBallindex(board.getBalls(), index, 'W');
				break;
			}
			default: {
				System.out.println(" Wide ");
				secondMatchModel.setscore(board, 1);
				move = false;
			}
			}

			if (move) {
				secondMatchModel.increseEveryTime(board);
			}

			if (board.getInd() == 6) {
				board.setbow(secondMatchModel.getabowler());
				secondMatchModel.swap();
				secondMatchModel.setInd();
				Arrays.fill(board.getBalls(), '0');
				secondMatchModel.increaseOver();
			}

		}

		System.out.println(secondMatchModel.getTeam2name() + " Match has been ended \nScores : "
				+ secondMatchModel.getScoreBoard().getScore() + "\n");

		int score = secondMatchModel.getpreviousScore();

		if (score < secondMatchModel.getScoreBoard().getScore()) {
			secondMatchModel.setwinneras(secondMatchModel.getTeam2name());
		} else if (score == secondMatchModel.getScoreBoard().getScore()) {
			secondMatchModel.setwinneras("Draw");
		}

	}

	private void printScoreBoard() {

		ScoreBoard score = secondMatchModel.getScoreBoard();

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

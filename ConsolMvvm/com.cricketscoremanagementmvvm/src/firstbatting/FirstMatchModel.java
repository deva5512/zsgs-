package firstbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

import repository.ScoreManagementDb;

public class FirstMatchModel {

	public FirstMatchModel() {
		
	}

	public String getTeam1name() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam_name();
	}

	public ScoreBoard getScoreBoard() {
		return ScoreManagementDb.getInstance().getBoard();
	}

	public boolean isTeam1Out() {
		if (ScoreManagementDb.getInstance().getBoard().getWickets() == 10) {
			return true;
		}
		if (ScoreManagementDb.getInstance().getBoard().getOver() >= ScoreManagementDb.getInstance().getNumber_overs()) {
			return true;
		}
		return false;
	}

	public Player getBatsman() {
		return ScoreManagementDb.getInstance().getBatsmanFromTeam1();
	}

	public Player getabowler() {
		return ScoreManagementDb.getInstance().getBowler(0);
	}

	public void setMatch1Score(int score) {
		ScoreManagementDb.getInstance().setFirst_match_score(score);
	}

	public void setwinner(String winner) {
		ScoreManagementDb.getInstance().setWinning_team(winner);
	}

	public void setStatus(Player player, String string) {
		player.setStatus(string);
	}

	public void gotWicket(ScoreBoard board) {
		board.getbow().setNumberofWickets(board.getbow().getNumberofWickets() + 1);
		board.setWickets(board.getWickets() + 1);

	}

	public void increseEveryTime(ScoreBoard board) {
		board.setInd(board.getInd() + 1);
		board.getbow().setNumberofballsput(board.getbow().getNumberofballsput() + 1);
		board.setNumberofballs(board.getNumberofballs() + 1);
	}

	public void increaseIndividual(Player p1, int score) {
		p1.setIndevidual_score(p1.getIndevidual_score() + score);
		p1.setNo_of_balls(p1.getNo_of_balls() + 1);

	}

	public void setscore(ScoreBoard board, int i) {
		board.setScore(board.getScore() + i);
	}

	public void setBallindex(char[] balls, int index, char c) {
		balls[index] = c;
	}

	public void setScore() {
		getScoreBoard().setInd(0);
	}

	public void increaseOver() {
		getScoreBoard().setOver(getScoreBoard().getOver() + 1);
	}

	public void swap() {
		ScoreBoard board = getScoreBoard();

		Player p = board.getp1();
		board.setp1(board.getp2());
		board.setp2(p);
	}

	public void changeBatsman() {
		ScoreBoard board = getScoreBoard();
		Player player = getBatsman();
		board.setp1(player);
	}

}

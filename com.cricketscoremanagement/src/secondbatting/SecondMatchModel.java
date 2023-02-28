package secondbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

import repository.ScoreManagementDb;

public class SecondMatchModel implements SecondModelCallBack {
	private SecondModelControllerCall secondcontroller;

	public SecondMatchModel(SecondModelControllerCall secondcontroller) {
		this.secondcontroller = secondcontroller;
	}

	@Override
	public String getTeam2name() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam_name();
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return ScoreManagementDb.getInstance().getBoard();
	}

	@Override
	public boolean isTeam2Out(int score) {
		if (ScoreManagementDb.getInstance().getBoard().getWickets() == 10) {
			return true;
		}
		if (ScoreManagementDb.getInstance().getBoard().getOver() >= ScoreManagementDb.getInstance().getNumber_overs()) {
			return true;
		}
		if (ScoreManagementDb.getInstance().getFirst_match_score() < score) {
			return true;
		}
		return false;
	}

	@Override
	public Player getBatsman() {
		return ScoreManagementDb.getInstance().getBatsmanFromTeam2();
	}

	@Override
	public Player getabowler() {
		return ScoreManagementDb.getInstance().getBowler(1);
	}

	@Override
	public int getpreviousScore() {
		return ScoreManagementDb.getInstance().getFirst_match_score();
	}

	@Override
	public void setwinneras(String winner) {
		ScoreManagementDb.getInstance().setWinning_team(winner);
	}

}

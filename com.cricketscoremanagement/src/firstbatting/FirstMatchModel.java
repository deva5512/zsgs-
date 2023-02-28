package firstbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

import repository.ScoreManagementDb;

public class FirstMatchModel implements FirstMatchModelCallBack {

	private FirstMatchModelControllerCall firstcontroller;

	public FirstMatchModel(FirstMatchModelControllerCall firstMatchController) {
		this.firstcontroller = firstMatchController;
	}

	@Override
	public String getTeam1name() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam_name();
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return ScoreManagementDb.getInstance().getBoard();
	}

	@Override
	public boolean isTeam1Out() {
		if (ScoreManagementDb.getInstance().getBoard().getWickets() == 10) {
			return true;
		}
		if (ScoreManagementDb.getInstance().getBoard().getOver() >= ScoreManagementDb.getInstance().getNumber_overs()) {
			return true;
		}
		return false;
	}

	@Override
	public Player getBatsman() {
		return ScoreManagementDb.getInstance().getBatsmanFromTeam1();
	}

	@Override
	public Player getabowler() {
		return ScoreManagementDb.getInstance().getBowler(0);
	}

	@Override
	public void setMatch1Score(int score) {
		ScoreManagementDb.getInstance().setFirst_match_score(score);
	}

	@Override
	public void setwinner(String winner) {
		ScoreManagementDb.getInstance().setWinning_team(winner);
	}

}

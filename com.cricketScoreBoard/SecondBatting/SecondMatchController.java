package secondbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public class SecondMatchController implements SecondViewControllerCall, SecondModelControllerCall {
	private SecondViewCallBack secondView;
	private SecondModelCallBack secondModel;

	public SecondMatchController(SecondViewCallBack secondView) {
		this.secondView = secondView;
		this.secondModel = new SecondMatchModel(this);
	}

	@Override
	public String getTeam2name() {
		return secondModel.getTeam2name();
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return secondModel.getScoreBoard();
	}

	@Override
	public boolean isTeam2Out(int score) {
		return secondModel.isTeam2Out(score);
	}

	@Override
	public void setScore() {
		getScoreBoard().setInd(0);
	}

	@Override
	public void increaseOver() {
		getScoreBoard().setOver(getScoreBoard().getOver() + 1);
	}

	@Override
	public void swap() {
		ScoreBoard board = getScoreBoard();

		Player p = board.getp1();
		board.setp1(board.getp2());
		board.setp2(p);
	}

	@Override
	public void changeBatsman() {
		ScoreBoard board = getScoreBoard();

		Player player = secondModel.getBatsman();

		board.setp1(player);
	}

	@Override
	public Player getabowler() {
		return secondModel.getabowler();
	}

	@Override
	public int getpreviousScore() {
		return secondModel.getpreviousScore();
	}

	@Override
	public void setwinneras(String winner) {
		secondModel.setwinneras(winner);
	}
}

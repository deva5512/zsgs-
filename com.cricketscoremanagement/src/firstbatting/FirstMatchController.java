package firstbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public class FirstMatchController implements FirstMatchViewControllerCall, FirstMatchModelControllerCall {

	private FirstMatchViewCallBack firstView;
	private FirstMatchModelCallBack firstModel;

	public FirstMatchController(FirstMatchViewCallBack firstMatchView) {
		this.firstView = firstMatchView;
		this.firstModel = new FirstMatchModel(this);
	}

	@Override
	public String getTeam1name() {
		return firstModel.getTeam1name();
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return firstModel.getScoreBoard();
	}

	@Override
	public boolean isTeam1Out() {
		return firstModel.isTeam1Out();
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

		Player player = firstModel.getBatsman();

		board.setp1(player);
	}

	@Override
	public Player getabowler() {
		return firstModel.getabowler();
	}

	@Override
	public void setMatch1Score(int score) {
		firstModel.setMatch1Score(score);
	}

	@Override
	public void setwinner(String winner) {
		firstModel.setwinner(winner);
	}

	public void setStatus(Player player, String string) {
		player.setStatus(string);
	}

	@Override
	public void setBallindex(char[] balls, int index, char c) {
		balls[index] = c;
	}

	@Override
	public void setscore(ScoreBoard board, int i) {
		board.setScore(board.getScore() + i);
	}

	@Override
	public void increaseIndividual(Player p1, int score) {
		p1.setIndevidual_score(p1.getIndevidual_score() + score);
		p1.setNo_of_balls(p1.getNo_of_balls() + 1);

	}

	@Override
	public void increseEveryTime(ScoreBoard board) {
		board.setInd(board.getInd() + 1);
		board.getbow().setNumberofballsput(board.getbow().getNumberofballsput() + 1);
		board.setNumberofballs(board.getNumberofballs() + 1);
	}

	@Override
	public void gotWicket(ScoreBoard board) {
		board.getbow().setNumberofWickets(board.getbow().getNumberofWickets() + 1);
		board.setWickets(board.getWickets() + 1);

	}

}

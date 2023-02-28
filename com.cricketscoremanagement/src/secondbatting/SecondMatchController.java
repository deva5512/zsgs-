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
	public void setInd() {
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

	@Override
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

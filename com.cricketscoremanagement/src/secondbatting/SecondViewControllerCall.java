package secondbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public interface SecondViewControllerCall {

	void changeBatsman();

	void swap();

	void increaseOver();

	void setInd();

	String getTeam2name();

	ScoreBoard getScoreBoard();

	boolean isTeam2Out(int score);

	Player getabowler();

	int getpreviousScore();

	void setwinneras(String winner);

	void setStatus(Player player, String string);

	void setBallindex(char[] balls, int index, char c);

	void setscore(ScoreBoard board, int i);

	void increaseIndividual(Player getp1, int i);

	void increseEveryTime(ScoreBoard board);

	void gotWicket(ScoreBoard board);

}

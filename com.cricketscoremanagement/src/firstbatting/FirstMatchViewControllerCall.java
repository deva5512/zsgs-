package firstbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public interface FirstMatchViewControllerCall {

	String getTeam1name();

	ScoreBoard getScoreBoard();

	boolean isTeam1Out();

	void setScore();

	void increaseOver();

	void swap();

	void changeBatsman();

	Player getabowler();

	void setMatch1Score(int score);

	void setwinner(String winner);

	void setStatus(Player getp1, String string);

	void gotWicket(ScoreBoard board);

	void increseEveryTime(ScoreBoard board);

	void increaseIndividual(Player p1, int score);

	void setscore(ScoreBoard board, int i);

	void setBallindex(char[] balls, int index, char c);

}

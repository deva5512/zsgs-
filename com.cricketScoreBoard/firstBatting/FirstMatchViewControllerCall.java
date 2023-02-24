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

	boolean havePlayer();

}

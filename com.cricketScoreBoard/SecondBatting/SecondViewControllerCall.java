package secondbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public interface SecondViewControllerCall {

	void changeBatsman();

	void swap();

	void increaseOver();

	void setScore();

	String getTeam2name();

	ScoreBoard getScoreBoard();

	boolean isTeam2Out(int score);

	Player getabowler();

	int getpreviousScore();

	void setwinneras(String winner);

}

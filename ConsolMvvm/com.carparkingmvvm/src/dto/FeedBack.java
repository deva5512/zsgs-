package dto;

import java.time.LocalDate;

public class FeedBack {
	private LocalDate date;
	private String feedback;

	public FeedBack(LocalDate now, String feedback2) {
		this.date = now;
		this.feedback = feedback2;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}

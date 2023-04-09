package ecommercedto;

public class Review {
	private String name;
	private String message;
	private String date;

	public Review(String name, String message, String date) {
		this.name = name;
		this.message = message;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

package tables;

public class Rating {
	private long userId;
	private int rating;
	private long raterId;

	public long getRaterId() {
		return raterId;
	}

	public void setRaterId(long raterId) {
		this.raterId = raterId;
	}

	public Rating() {
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	};
}

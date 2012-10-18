package tables;

public class Feedback {
	private long senderId;
	private long revieverId;
	private String feedback;

	public Feedback() {
	}

	public long getSenderId() {
		return senderId;
	}

	private void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getRevieverId() {
		return revieverId;
	}

	public void setRevieverId(long revieverId) {
		this.revieverId = revieverId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}

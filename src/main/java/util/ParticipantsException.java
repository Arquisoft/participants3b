package util;

public class ParticipantsException extends Exception {
	private static final long serialVersionUID = 4001710687990554589L;

	public ParticipantsException() {
	}

	public ParticipantsException(String message) {
		super(message);
	}

	public ParticipantsException(Throwable cause) {
		super(cause);
	}

	public ParticipantsException(String message, Throwable cause) {
		super(message, cause);
	}

}

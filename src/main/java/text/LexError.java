package main.java.text;

public class LexError extends RuntimeException {
	/**
	 * Since Exceptions are {@linkplain java.io.Serializable}, we must have a version.
	 */
	private static final long serialVersionUID = 1L;

	public LexError(String msg) {
		super(msg);
	}
}
package main.java.text;

public class MissingVariableError extends RuntimeException {
	/**
	 * Since Exceptions are {@linkplain java.io.Serializable}, we must have a version.
	 */
	private static final long serialVersionUID = 1L;
	
	public MissingVariableError(String which) {
		super("Missing Variable: "+which);
	}
}

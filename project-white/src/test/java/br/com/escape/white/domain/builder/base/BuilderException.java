package br.com.escape.white.domain.builder.base;

/**
 * @author julianopontes
 *
 */
public class BuilderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6659696610480821988L;

	/**
	 * @param cause
	 */
	public BuilderException(final Throwable cause) {
		super(cause);
	}
}
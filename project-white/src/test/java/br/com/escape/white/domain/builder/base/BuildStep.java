package br.com.escape.white.domain.builder.base;

/**
 * @author julianopontes
 *
 * @param <T>
 */
public interface BuildStep<T> {
	
	/**
	 * @param target
	 */
	void build(T target);
}
package br.com.escape.white.domain.builder.base;

import java.io.Serializable;

/**
 * @author julianopontes
 *
 * @param <T>
 */
public interface Builder<T extends Serializable> {
	T build();
}
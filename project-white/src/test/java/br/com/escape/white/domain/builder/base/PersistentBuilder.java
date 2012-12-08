package br.com.escape.white.domain.builder.base;

import java.io.Serializable;

/**
 * @author julianopontes
 *
 * @param <T>
 */
public interface PersistentBuilder<T extends Serializable> extends Builder<T> {

	T buildAndSave();
}

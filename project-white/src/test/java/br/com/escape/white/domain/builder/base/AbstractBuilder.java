package br.com.escape.white.domain.builder.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author julianopontes
 * 
 * @param <T>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AbstractBuilder<T extends Serializable> implements Builder<T> {

	private List<BuildStep> steps = new ArrayList<BuildStep>();

	/**
	 * @return Uma instancia do tipo T
	 */
	protected T createInstance() {
		try {
			ParameterizedType pType;
			pType = (ParameterizedType) getClass().getGenericSuperclass();
			final Class<T> clazz = ((Class<T>) pType.getActualTypeArguments()[0]);
			return (T) clazz.newInstance();
		} catch (Exception e) {
			throw new BuilderException(e);
		}
	}

	public <B extends AbstractBuilder<T>> B addStep(final BuildStep<T> step) {
		AbstractBuilder<T> builder = cloneBuilder();
		builder.steps.add(step);
		return (B) builder;
	}

	public <B extends AbstractBuilder<T>> B p(final String property, final Object value) {
		return this.addStep(new BuildStep<T>() {
			@Override
			public void build(T target) {
				try {
					PropertyUtils.setProperty(target, property, value);
				} catch (Exception e) {
					throw new BuilderException(e);
				}
			}
		});
	}

	/**
	 * Cria uma cópia do atual builder
	 * 
	 * @param <B>
	 *            the generic type
	 * @return Uma cópia do builder atual
	 */
	protected <B extends AbstractBuilder<T>> B cloneBuilder() {
		try {
			final AbstractBuilder<T> clone = this.getClass().newInstance();
			clone.steps.addAll(this.steps);
			return (B) clone;
		} catch (Exception e) {
			throw new BuilderException(e);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see br.org.sesc.test.commons.builder.Builder#build()
	 */
	@Override
	public T build() {
		T target = this.createInstance();
		for (BuildStep<Object> step : this.steps) {
			step.build((Object) target);
		}
		return target;
	}
}
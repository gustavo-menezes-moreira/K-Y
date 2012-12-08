package br.com.escape.white.domain.builder.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public abstract class AbstractPersistentBuilder<T extends Serializable, ID extends Serializable> extends
		AbstractBuilder<T> implements
		PersistentBuilder<T> {

	private CrudRepository<T, ID> persistence;

	/**
	 * @param persistence
	 */
	@Autowired
	public void setPersistence(final CrudRepository<T, ID> persistence) {
		this.persistence = persistence;
	}

	/**
	 * {@inheritDoc} (non-Javadoc)
	 * 
	 * @see br.org.sesc.test.commons.builder.PersistentBuilder#buildAndSave()
	 */
	@Override
	public T buildAndSave() {
		T target = build();
		persistence.save(target);
		return target;
	}

	/**
	 * {@inheritDoc} (non-Javadoc)
	 * 
	 * @see br.com.escape.white.domain.builder.base.AbstractBuilder#cloneBuilder()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <B extends AbstractBuilder<T>> B cloneBuilder() {
		AbstractPersistentBuilder<T, ID> builder = super.cloneBuilder();
		builder.setPersistence(this.persistence);
		return (B) builder;
	}
}
package br.com.escape.white.domain.builder.base;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import br.com.escape.white.domain.builder.UserBuilder;

/**
 * @author julianopontes
 * 
 */
public class Builders implements ApplicationContextAware {

	private static ApplicationContext context;

	public static UserBuilder user(String username, String name, boolean userAssistant, String password,
			DateTime expirationDate) {
		return getBean(UserBuilder.class).username(username).name(name).userAssistant(userAssistant).password(password)
				.expirationDate(expirationDate);
	}

	/**
	 * @param clazz
	 * @return
	 */
	private static <T extends AbstractBuilder<? extends Serializable>> T getBean(Class<T> clazz) {
		return (T) context.getBean(clazz);
	}

	/**
	 * {@inheritDoc} (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
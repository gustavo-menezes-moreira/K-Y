package br.com.escape.white.domain.builder;

import java.math.BigInteger;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.escape.white.domain.builder.base.AbstractPersistentBuilder;
import br.com.escape.white.domain.builder.base.BuildStep;
import br.com.escape.white.domain.entities.User;

/**
 * @author julianopontes
 * 
 */
@Component
@Scope("prototype")
public class UserBuilder extends AbstractPersistentBuilder<User, BigInteger> {

	/**
	 * @param username
	 * @return
	 */
	public UserBuilder username(String username) {
		return p("username", username);
	}

	/**
	 * @param name
	 * @return
	 */
	public UserBuilder name(String name) {
		return p("name", name);
	}

	/**
	 * @param userAssistant
	 * @return
	 */
	public UserBuilder userAssistant(boolean userAssistant) {
		return p("userAssistant", userAssistant);
	}

	/**
	 * @param password
	 * @return
	 */
	public UserBuilder password(String password) {
		return p("password", password);
	}

	/**
	 * @param expirationDate
	 * @return
	 */
	public UserBuilder expirationDate(DateTime expirationDate) {
		return p("expirationDate", expirationDate);
	}

	/**
	 * @param lastLogin
	 * @return
	 */
	public UserBuilder lastLogin(DateTime lastLogin) {
		return p("lastLogin", lastLogin);
	}

	/**
	 * @param tryLogin
	 * @return
	 */
	public UserBuilder tryLogin(int tryLogin) {
		return p("tryLogin", tryLogin);
	}

	/**
	 * @param assistant
	 * @return
	 */
	public UserBuilder addAssistant(final User assistant) {
		return addStep(new BuildStep<User>() {

			@Override
			public void build(User target) {
				target.addAssistant(assistant);
			}
		});
	}
}
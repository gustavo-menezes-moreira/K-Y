/**
 * 
 */
package br.com.escape.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.escape.white.domain.entities.User;
import br.com.escape.white.domain.repositories.UserRepository;

/**
 * @author super_000
 * 
 */
public class UserDetailsService implements
		org.springframework.security.core.userdetails.UserDetailsService {

	private UserRepository userRepository;

	/**
	 * Carrega o usuário pelas permissões
	 * 
	 * @param username
	 *            o nome do usuário
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = this.userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("username");
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(
				SystemAuthorities.ROLE_ASSISTANT.name()));

		if (!user.getUserAssistant()) {
			authorities.add(new SimpleGrantedAuthority(
					SystemAuthorities.ROLE_USER.name()));
		}
		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
				username, null, authorities);

		return userDetails;
	}

	/**
	 * @param userRepository
	 *            the userRepository to set
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}

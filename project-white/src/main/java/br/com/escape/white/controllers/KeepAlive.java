/**
 * 
 */
package br.com.escape.white.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author super_000
 * 
 */
@Controller
@RequestMapping("/keepAlive")
public class KeepAlive {

	/**
	 * Devolve o usuário logado na sessão
	 * 
	 * @param authentication
	 *            o usuário logado
	 * @return os detalhes do usuário
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public UserDetails keepAlive(Authentication authentication) {
		return (UserDetails) authentication.getPrincipal();
	}
}
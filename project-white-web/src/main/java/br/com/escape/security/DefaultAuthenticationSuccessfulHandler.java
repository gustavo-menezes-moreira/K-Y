/**
 * 03/02/2012
 */
package br.com.escape.security;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author gustavo.moreira
 * 
 */
public class DefaultAuthenticationSuccessfulHandler implements AuthenticationSuccessHandler {

	private JsonFactory jsonFactory;

	/**
	 * Se encarrega de preencher a saída com os detalhes do usuário
	 * 
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		StringWriter writer = new StringWriter();
		JsonGenerator jsonGenerator = this.jsonFactory.createJsonGenerator(writer);
		jsonGenerator.writeObject(authentication.getPrincipal());

		try {
			response.getWriter().print(writer.toString());
			response.getWriter().flush();
		} finally {
			writer.close();
		}

	}

	/**
	 * @param jsonFactory
	 *            the jsonFactory to set
	 */
	public void setJsonFactory(JsonFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}
}
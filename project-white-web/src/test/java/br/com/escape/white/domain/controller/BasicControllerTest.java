package br.com.escape.white.domain.controller;

import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.RequestBuilder;
import org.springframework.test.web.server.ResultActions;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author julianopontes
 * 
 */
@ContextConfiguration(locations = "classpath:api-servlet.xml")
public class BasicControllerTest {

	@Autowired
	private ApplicationContext applicationContext;

	protected MockMvc mockMvc;

	@EnableWebMvc
	protected static class WebConfig {
	}

	/**
	 * Configuração inicial.
	 */
	@Before
	public void setUp() {
		mockMvc = annotationConfigSetup(WebConfig.class).setParentContext(applicationContext)
				.configureWebAppRootDir("src/main/webapp", false).build();
	}

	/**
	 * Executa a ação.
	 * 
	 * @param requestBuilder
	 * @return resultado.
	 */
	public ResultActions perform(RequestBuilder requestBuilder) {
		try {
			return mockMvc.perform(requestBuilder);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
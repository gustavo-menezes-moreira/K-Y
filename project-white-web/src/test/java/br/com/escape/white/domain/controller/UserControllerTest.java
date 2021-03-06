package br.com.escape.white.domain.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.escape.white.domain.builder.base.Builders;

/**
 * @author julianopontes
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest extends BasicControllerTest {

	/**
	 * Teste de controller.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testController() throws Exception {
		Builders.user("name@name.com", "name", false, "", DateTime.now()).buildAndSave();

		perform(get("/user")).andExpect(status().isNotFound()).andReturn();		
	}
}
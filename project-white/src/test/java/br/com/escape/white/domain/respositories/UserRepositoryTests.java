/**
 * 
 */
package br.com.escape.white.domain.respositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.escape.white.domain.entities.User;
import br.com.escape.white.domain.repositories.UserRepository;

/**
 * @author super_000
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:white-test-beans.xml")
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Testando o básico de um repositório
	 */
	@Test
	public void testBasics() {

		User user = new User();
		user.setName("nome");
		user.setUsername("username@email.com");

		User save = this.userRepository.save(user);

		Assert.assertNotNull(save);

		Assert.assertNotNull(save.getId());

		User found = this.userRepository.findOne(save.getId());
		Assert.assertNotNull(found);
		Assert.assertEquals(save, found);

		this.userRepository.delete(found.getId());

		User delete = this.userRepository.findOne(found.getId());
		Assert.assertNull(delete);

	}

	/**
	 * Testa a busca pelo nome de usuário
	 */
	@Test
	public void testFindByUsername() {

		User user = new User();
		user.setName("nome");
		user.setUsername("username@email.com");

		User save = this.userRepository.save(user);

		Assert.assertNotNull(save);

		User found = this.userRepository.findByUsername("username@email.com");
		Assert.assertNotNull(found);
		Assert.assertEquals(save, found);

		this.userRepository.delete(found.getId());

		User delete = this.userRepository.findOne(found.getId());
		Assert.assertNull(delete);

	}

}

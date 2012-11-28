/**
 * 
 */
package br.com.escape.white.domain.repositories;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import br.com.escape.white.domain.entities.User;

/**
 * @author super_000
 * 
 */
public interface UserRepository extends CrudRepository<User, BigInteger> {

}

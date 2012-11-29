package br.com.escape.white.domain.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author super_000
 * 
 */
@Entity
@Table(name = "main_users", uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class User {

	private BigInteger id;

	private String userName;

	private String name;

	private Boolean userAssistant = true;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	@Column(name = "username", nullable = false, unique = true)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the name
	 */
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userAssistant
	 */
	@Column(name = "assistant", nullable = false)
	public Boolean getUserAssistant() {
		return userAssistant;
	}

	/**
	 * @param userAssistant
	 *            the userAssistant to set
	 */
	public void setUserAssistant(Boolean userAssistant) {
		this.userAssistant = userAssistant;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
}

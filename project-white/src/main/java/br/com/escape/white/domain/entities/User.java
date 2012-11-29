package br.com.escape.white.domain.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author super_000
 * 
 */
@Entity
@Table(name = "main_users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private BigInteger id;

	@Column(name = "username", nullable = false, unique = true)
	private String userName;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "assistant", nullable = false)
	private Boolean userAssistant = true;

	/**
	 * @return the id
	 */
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
		return new HashCodeBuilder()
				.append(id).append(userName).append(name).append(userAssistant)
				.toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		final User other = (User) obj;
		return new EqualsBuilder()
				.append(id, other.id).append(userName, other.userName)
				.isEquals();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append(id).append(userName).append(name).append(userAssistant)
				.toString();
	}
}
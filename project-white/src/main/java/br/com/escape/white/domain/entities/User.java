package br.com.escape.white.domain.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author super_000
 * 
 */
@Entity
@Table(name = "main_users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4461411468428368177L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private BigInteger id;

	@NotNull(message = "username.notNull")
	@Size(min = 7, max = 255)
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@NotNull(message = "name.notNull")
	@Size(min = 3, max = 255)
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "assistant", nullable = false)
	private Boolean userAssistant = true;

	@Column(name = "password", nullable = false)
	private String password;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "expiration", nullable = false)
	private DateTime expirationDate;

	@Column(name = "last_login")
	private DateTime lastLogin;

	@Column(name = "try_login", nullable = false)
	private int tryLogin = 0;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "doctor_assistant", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "assistant_id"))
	private List<User> assistants = new ArrayList<User>();

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
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName
	 *            the username to set
	 */
	public void setUsername(String userName) {
		this.username = userName;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the expirationDate
	 */
	public DateTime getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate
	 *            the expirationDate to set
	 */
	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the lastLogin
	 */
	public DateTime getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the tryLogin
	 */
	public int getTryLogin() {
		return tryLogin;
	}

	/**
	 * @param tryLogin
	 *            the tryLogin to set
	 */
	public void setTryLogin(int tryLogin) {
		this.tryLogin = tryLogin;
	}

	/**
	 * @return the assistants
	 */
	public List<User> getAssistants() {
		return Collections.unmodifiableList(assistants);
	}

	/**
	 * @param assistant
	 */
	public void addAssistant(User assistant) {
		if (assistant != null && assistant.getUserAssistant().equals(true)) {
			assistants.add(assistant);
		}
	}

	/**
	 * @param assistant
	 */
	public void removeAssitant(User assistant) {
		assistants.remove(assistant);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(username).append(name)
				.append(userAssistant).toHashCode();
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
		return new EqualsBuilder().append(id, other.id)
				.append(username, other.username).isEquals();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(username)
				.append(name).append(userAssistant).toString();
	}
}
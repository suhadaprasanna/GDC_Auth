/**
 * 
 */
package gdc.service.auth.datamanager.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author suhada
 *
 */
@Entity
@Table(name = "credentials", catalog = "gdc_person")
public class Credentials implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	@Column(name = "password", nullable = false, length = 500)
	private String password;
	@Column(name = "status", nullable = false, length = 5)
	private String status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person", nullable = false)
	private Person person;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", length = 10)
	private Date created_date;
	@Column(name = "account_non_expired")
	private boolean account_non_expired;
	@Column(name = "credentials_non_expired")
	private boolean credentials_non_expired;
	@Column(name = "account_non_locked")
	private boolean account_non_locked;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "credentials_role", 
    		joinColumns = {
    				@JoinColumn(name = "credentials", referencedColumnName = "id")
    				},
    		inverseJoinColumns = {
                    @JoinColumn(name = "role", referencedColumnName = "id")
                    }
    		)
    private List<Role> roles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public boolean getAccount_non_expired() {
		return account_non_expired;
	}
	public void setAccount_non_expired(boolean account_non_expired) {
		this.account_non_expired = account_non_expired;
	}
	public boolean getCredentials_non_expired() {
		return credentials_non_expired;
	}
	public void setCredentials_non_expired(boolean credentials_non_expired) {
		this.credentials_non_expired = credentials_non_expired;
	}
	public boolean getAccount_non_locked() {
		return account_non_locked;
	}
	public void setAccount_non_locked(boolean account_non_locked) {
		this.account_non_locked = account_non_locked;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}

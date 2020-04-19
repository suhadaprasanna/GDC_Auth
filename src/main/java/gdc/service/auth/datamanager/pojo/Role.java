/**
 * 
 */
package gdc.service.auth.datamanager.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author suhada
 *
 */
@Entity
@Table(name = "role", catalog = "gdc_person")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name = "role_permission", 
    		joinColumns = {
    				@JoinColumn(name = "role", referencedColumnName = "id")
            }, 
    		inverseJoinColumns = {
    				@JoinColumn(name = "permission", referencedColumnName = "id")
            }
    )
	private List<Permission> permissions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	
}

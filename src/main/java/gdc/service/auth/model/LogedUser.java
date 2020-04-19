/**
 * 
 */
package gdc.service.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import gdc.service.auth.datamanager.pojo.Credentials;
import gdc.service.auth.datamanager.pojo.Role;

/**
 * @author suhada
 *
 */
public class LogedUser implements UserDetails{

	private String username;
	private String password;
	List<Role> roles = null;
	private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
	
	public LogedUser(){}
	public LogedUser(Credentials selectedUser) {
		this.username = selectedUser.getUsername();
		this.password = selectedUser.getPassword();
		this.roles = selectedUser.getRoles();
		this.enabled = (selectedUser.getStatus().equalsIgnoreCase("Y")?true:false);
		this.accountNonExpired = selectedUser.getAccount_non_expired();
		this.credentialsNonExpired = selectedUser.getCredentials_non_expired();
		this.accountNonLocked = selectedUser.getAccount_non_locked();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        this.roles.forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
            });

        });
        return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}

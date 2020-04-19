/**
 * 
 */
package gdc.service.auth.datamanager.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author suhada
 *
 */
@Entity
@Table(name = "oauth_client_details", catalog = "gdc_person")
public class ClientDetails implements Serializable{

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String client_id;
	@Column(name = "client_secret", nullable = false, length = 255)
	private String client_secret;
	@Column(name = "web_server_redirect_url", length = 255)
	private String web_server_redirect_url;
	@Column(name = "scope", length = 255)
	private String scope;
	@Column(name = "access_token_validity")
	private int access_token_validity;
	@Column(name = "refresh_token_validity")
	private int refresh_token_validity;
	@Column(name = "resource_ids",length = 500)
	private String resource_ids;
	@Column(name = "authorized_grant_types",length = 500)
	private String authorized_grant_types;
	@Column(name = "authorities",length = 500)
	private String authorities;
	@Column(name = "additional_information",length = 500)
	private String additional_information;
	@Column(name = "autoapprove",length = 255)
	private boolean autoapprove;
	
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public String getWeb_server_redirect_url() {
		return web_server_redirect_url;
	}
	public void setWeb_server_redirect_url(String web_server_redirect_url) {
		this.web_server_redirect_url = web_server_redirect_url;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getAccess_token_validity() {
		return access_token_validity;
	}
	public void setAccess_token_validity(int access_token_validity) {
		this.access_token_validity = access_token_validity;
	}
	public int getRefresh_token_validity() {
		return refresh_token_validity;
	}
	public void setRefresh_token_validity(int refresh_token_validity) {
		this.refresh_token_validity = refresh_token_validity;
	}
	public String getResource_ids() {
		return resource_ids;
	}
	public void setResource_ids(String resource_ids) {
		this.resource_ids = resource_ids;
	}
	public String getAuthorized_grant_types() {
		return authorized_grant_types;
	}
	public void setAuthorized_grant_types(String authorized_grant_types) {
		this.authorized_grant_types = authorized_grant_types;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public String getAdditional_information() {
		return additional_information;
	}
	public void setAdditional_information(String additional_information) {
		this.additional_information = additional_information;
	}
	public boolean getAutoapprove() {
		return autoapprove;
	}
	public void setAutoapprove(boolean autoapprove) {
		this.autoapprove = autoapprove;
	}
	
	
}

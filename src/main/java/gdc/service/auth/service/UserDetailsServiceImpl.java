/**
 * 
 */
package gdc.service.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gdc.service.auth.datamanager.access.CredentialsAccess;
import gdc.service.auth.datamanager.pojo.Credentials;
import gdc.service.auth.model.LogedUser;

/**
 * @author suhada
 *
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private CredentialsAccess credentialsAccess;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			Credentials credentials = this.credentialsAccess.getByUsername(username);
			logger.debug("------>> credentials: "+credentials);
			if(credentials != null) {
				userDetails = new LogedUser(credentials);
			}
		} catch (Exception e) {
			logger.error("Error getting user details: ",e);
		}
		logger.debug("------>> userDetails: "+userDetails);
		return userDetails;
	}

}

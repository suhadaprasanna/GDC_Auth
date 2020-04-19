/**
 * 
 */
package gdc.service.auth.datamanager.access;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.service.auth.datamanager.dao.CredentialsRepository;
import gdc.service.auth.datamanager.pojo.Credentials;

/**
 * @author suhada
 *
 */
@Repository("credentialsAccess")
@Transactional
public class CredentialsAccess {

	private static final Logger logger = LoggerFactory.getLogger(CredentialsAccess.class);
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	public Credentials getByUsername(String username) {
		Credentials credentials = null;
		try {
			Optional<Credentials> result = this.credentialsRepository.findByUsername(username);
			result.orElseThrow(()->new UsernameNotFoundException("Username or Password wrong ("+username+")"));
			credentials = result.get();
		} catch (Exception e) {
			logger.error("Error while getting by username: ",e);
		}
		logger.debug("------>> credentials: "+credentials);
		return credentials;
	}
}

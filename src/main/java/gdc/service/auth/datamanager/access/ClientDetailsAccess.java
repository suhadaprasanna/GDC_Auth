/**
 * 
 */
package gdc.service.auth.datamanager.access;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.service.auth.datamanager.dao.ClientDetailsRepository;
import gdc.service.auth.datamanager.pojo.ClientDetails;

/**
 * @author suhada
 *
 */
@Repository("clientDetailsAccess")
@Transactional
public class ClientDetailsAccess {

	private static final Logger logger = LoggerFactory.getLogger(ClientDetailsAccess.class);
	
	@Autowired
	private ClientDetailsRepository clientDetailsRepository;
	
	public boolean save(ClientDetails clientDetails) throws Exception {
		this.clientDetailsRepository.save(clientDetails);
		return true;
	}
	
	public ClientDetails getById(String id) {
		ClientDetails clientDetails = null;
		try {
			Optional<ClientDetails> result = this.clientDetailsRepository.findById(id);
			logger.debug("------>> isPresent: "+result.isPresent());
			if(result.isPresent())
				clientDetails = result.get();
		} catch (Exception e) {
			logger.error("Error while getting by username: ",e);
		}
		logger.debug("------>> clientDetails: "+clientDetails);
		return clientDetails;
	}
}

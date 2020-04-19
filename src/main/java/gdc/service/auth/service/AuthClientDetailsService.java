/**
 * 
 */
package gdc.service.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdc.service.auth.common.form.ClientDetailsForm;
import gdc.service.auth.common.form.validation.FormValidationUtil.FormKey;
import gdc.service.auth.datamanager.access.ClientDetailsAccess;
import gdc.service.auth.datamanager.pojo.ClientDetails;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
@Service
public class AuthClientDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(AuthClientDetailsService.class);
	
	@Autowired
	private ClientDetailsAccess clientDetailsAccess;
	
	public DataTransfer addClient(DataTransfer dataTrans) {
		try {
			ClientDetailsForm form = (ClientDetailsForm)dataTrans.getInput("form");
			if(form == null) {
				dataTrans.setStatus(Status.MESSAGE);
				dataTrans.addOutput(Key.MESSAGE, "not found form details");
				return dataTrans;
			}
			
			if(!form.validate(FormKey.CLIENTDETAILSFORM, dataTrans)) {
				return dataTrans;
			}
			ClientDetails clientDetails = new ClientDetails();
			clientDetails = this.setClientDetails(form, clientDetails);
			
			boolean status = false;
			try {
				status = this.clientDetailsAccess.save(clientDetails);
			} catch (Exception e) {
				logger.error("Error in saving: ",e);
				dataTrans.setStatus(Status.ERROR);
				dataTrans.addOutput(Key.ERROR, "saving failed");
			}
			
			if(status) {
				dataTrans.setStatus(Status.SUCCESS);
			}else {
				dataTrans.setStatus(Status.FAIL);
				dataTrans.addOutput(Key.MESSAGE, "saving failed");
			}
			
		} catch (Exception e) {
			logger.error("Error : ",e);
			dataTrans.setStatus(Status.ERROR);
			dataTrans.addOutput(Key.ERROR, "something went wrong");
		}
		return dataTrans;
	}
	
	private ClientDetails setClientDetails(ClientDetailsForm form,ClientDetails clientDetails) {
		if(clientDetails==null) {			
			clientDetails = new ClientDetails();
		}
		clientDetails.setClient_id(form.getClient_id());
		clientDetails.setClient_secret(form.getClient_secret());
		clientDetails.setAccess_token_validity(form.getAccess_token_validity());
		clientDetails.setAdditional_information(form.getAdditional_information());
		clientDetails.setAutoapprove(form.getAutoapprove());
		clientDetails.setRefresh_token_validity(form.getRefresh_token_validity());
		clientDetails.setScope(form.getScope());
		clientDetails.setResource_ids(form.getResource_ids());
		clientDetails.setWeb_server_redirect_url(form.getWeb_server_redirect_uri());
		clientDetails.setAuthorized_grant_types(form.getAuthorized_grant_types());
		return clientDetails;
	}
}

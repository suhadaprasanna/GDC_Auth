/**
 * 
 */
package gdc.service.auth.common.form.validation;

import gdc.service.auth.common.form.ClientDetailsForm;
import gdc.service.auth.common.form.Form;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
public class ClientDetailsFormValidation implements FormValidation{

	/* (non-Javadoc)
	 * @see gdc.service.auth.common.form.validation.FormValidation#validate(gdc.service.auth.common.form.Form, gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public boolean validate(Form _form, DataTransfer dataTrans) {
		ClientDetailsForm form = (ClientDetailsForm)_form;
		boolean status = true;
		if(form.getClient_id() == null || form.getClient_id().equals("")) {
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING, "client id required");
			status=false;
		}
		if(form.getClient_secret() == null || form.getClient_secret().equals("")) {
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING, "client secret required");
			status=false;
		}
		return status;
	}

}

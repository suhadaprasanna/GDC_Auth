/**
 * 
 */
package gdc.service.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdc.service.auth.common.form.ClientDetailsForm;
import gdc.service.auth.service.AuthClientDetailsService;
import gdc.utility.dataservice.DataTransfer;

/**
 * @author suhada
 *
 */
@RestController
@RequestMapping("client")
public class ClientDetailsController {

	@Autowired
	private AuthClientDetailsService authClientDetailsService;
	
	public DataTransfer addClient(ClientDetailsForm form) {
		DataTransfer dataTransfer = new DataTransfer();
		dataTransfer.addInput("form", form);
		dataTransfer = this.authClientDetailsService.addClient(dataTransfer);
		return dataTransfer;
	}
}

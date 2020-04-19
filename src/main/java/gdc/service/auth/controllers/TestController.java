/**
 * 
 */
package gdc.service.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdc.service.auth.datamanager.access.ClientDetailsAccess;
import gdc.service.auth.datamanager.pojo.ClientDetails;

/**
 * @author suhada
 *
 */
@RestController
@RequestMapping(value= {"/test"})
public class TestController {

	@Autowired
	private ClientDetailsAccess clientDetailsAccess;
	
	@RequestMapping(value= {"","/"})
	public String test() {
		ClientDetails de = clientDetailsAccess.getById("web");
		return "test: "+de.getClient_secret();
	}
}

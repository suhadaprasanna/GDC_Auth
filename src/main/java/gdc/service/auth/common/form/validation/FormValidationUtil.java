
/**
 * 
 */
package gdc.service.auth.common.form.validation;


/**
 * @author suhada
 *
 */

public class FormValidationUtil {
	
	public enum FormKey {
		CLIENTDETAILSFORM
	}
	
	public static Class getFormClass(FormKey key) {
		if(key == FormKey.CLIENTDETAILSFORM) {
			return ClientDetailsFormValidation.class;
		}else {
			return null;
		}
	}
}

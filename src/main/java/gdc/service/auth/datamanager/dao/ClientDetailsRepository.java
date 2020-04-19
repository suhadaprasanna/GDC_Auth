/**
 * 
 */
package gdc.service.auth.datamanager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdc.service.auth.datamanager.pojo.ClientDetails;

/**
 * @author suhada
 *
 */
@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, String> {

}

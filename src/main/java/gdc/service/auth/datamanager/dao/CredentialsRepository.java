/**
 * 
 */
package gdc.service.auth.datamanager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gdc.service.auth.datamanager.pojo.ClientDetails;
import gdc.service.auth.datamanager.pojo.Credentials;

/**
 * @author suhada
 *
 */
@Repository
public interface CredentialsRepository extends JpaRepository<Credentials,Long>{

	@Query(value = "SELECT c FROM Credentials c WHERE c.username =:username")
	public Optional<Credentials> findByUsername(@Param("username") String username);
}

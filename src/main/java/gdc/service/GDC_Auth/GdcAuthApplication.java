package gdc.service.GDC_Auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@ComponentScan(value= {"gdc"})
@EntityScan("gdc.service.auth.datamanager")
@EnableJpaRepositories("gdc.service.auth.datamanager")
@EnableDiscoveryClient
@EnableAuthorizationServer
public class GdcAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdcAuthApplication.class, args);
	}

}

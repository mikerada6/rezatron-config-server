package org.rezatron.rezatron_config_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigServer
public class RezatronConfigServerApplication {

	    @Autowired
    private Environment environment;


	public static void main(String[] args) {
		SpringApplication.run(RezatronConfigServerApplication.class, args);
	}

	    @PostConstruct
    public void checkVaultUri() {
        String vaultUri = environment.getProperty("spring.cloud.vault.uri");
        System.out.println("Configured Vault URI: " + vaultUri);
    }

	@PostConstruct
public void checkActiveProfiles() {
    String[] activeProfiles = environment.getActiveProfiles();
    System.out.println("Active profiles: " + String.join(", ", activeProfiles));
}

}



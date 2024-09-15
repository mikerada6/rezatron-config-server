package org.rezatron.rezatron_config_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableConfigServer
public class RezatronConfigServerApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(RezatronConfigServerApplication.class, args);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "rezatron-config-server");
    }

}

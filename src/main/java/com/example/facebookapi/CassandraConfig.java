package com.example.facebookapi;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.facebookapi.repository")
public class CassandraConfig {
    // private final String username = System.getenv("AWS_MCS_SPRING_APP_USERNAME");
    // private final String password = System.getenv("AWS_MCS_SPRING_APP_PASSWORD");
    String keySpace = "facebook";
    DriverConfigLoader loader = DriverConfigLoader.fromClasspath("application.conf");

    @Primary
    public @Bean CqlSession session() {
        return CqlSession.builder()
                .withConfigLoader(loader)
                .withKeyspace(keySpace)
                .build();
        // withAuthCredentials(username, password).

    }

    // @Override
    public SchemaAction getSchemaAction() {
        // Create the tables if they do not exist, but do not drop them on startup
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

}
package com.example.facebookapi;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.facebookapi.repository")
public class CassandraConfig {
    @Value("${cassandra.keyspacename}")
    protected String keySpace;
    DriverConfigLoader loader = DriverConfigLoader.fromClasspath("application.conf");

    @Primary
    public @Bean CqlSession session() {
        return CqlSession.builder()
                .withConfigLoader(loader)
                .withKeyspace(keySpace)

                .build();
        // withAuthCredentials(username, password).

    }

    // local ca marche mais sur aws-keyspace auto-generation est impossible pour les
    // tables
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE;
    }

}
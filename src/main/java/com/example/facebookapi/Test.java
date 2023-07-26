package com.example.facebookapi;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class Test {
    public static void main(String[] args) {
        // Use DriverConfigLoader to load your configuration file
        System.out.println("Hey Cassandra");
        DriverConfigLoader loader = DriverConfigLoader.fromClasspath("application.conf");
        System.out.println(loader.toString());

        try (CqlSession session = CqlSession.builder()
                .withConfigLoader(loader)
                .build()) {

            ResultSet rs = session.execute("select * from system_schema.keyspaces");
            rs.all().stream().forEach(row -> System.out.println(row.getString("keyspace_name")));

        }
    }
}

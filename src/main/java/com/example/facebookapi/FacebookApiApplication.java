package com.example.facebookapi;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;

@SpringBootApplication
public class FacebookApiApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		SpringApplication.run(FacebookApiApplication.class, args);
		// use Java-based bean metadata to register an instance of a
		// com.datastax.oss.driver.api.core.CqlSession
		CqlSession cqlSession = new CassandraConfig().session();

		// The CqlTemplate can be used within a DAO implementation through direct
		// instantiation with a SessionFactory reference or be configured in
		// the Spring container and given to DAOs as a bean reference. CqlTemplate is a
		// foundational building block for CassandraTemplate
		ResultSet rs = cqlSession.execute("select * from system_schema.keyspaces");
		rs.all().stream().forEach(row -> System.out.println(row.getString("keyspace_name")));
		cqlSession.close();
	}

}

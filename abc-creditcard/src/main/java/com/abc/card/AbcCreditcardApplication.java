package com.abc.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = { CassandraAutoConfiguration.class, MongoAutoConfiguration.class },
        scanBasePackages = { "com.abc.card" })
public class AbcCreditcardApplication {
    public static void main(String[] args) {
        SpringApplication.run(AbcCreditcardApplication.class, args);
    }

}

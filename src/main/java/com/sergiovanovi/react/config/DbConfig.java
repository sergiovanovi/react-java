package com.sergiovanovi.react.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

@Data
@Configuration
@ConfigurationProperties("app.db")
@EnableR2dbcRepositories(basePackages = "com.sergiovanovi.react.repository")
public class DbConfig {

    private String host;
    private int port;
    private String dataBase;
    private String username;
    private String password;


    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(dataBase)
                .username(username)
                .password(password)
                .build());
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory factory) {
        return DatabaseClient.builder()
                .connectionFactory(factory)
                .build();
    }
}

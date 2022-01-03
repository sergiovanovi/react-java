package com.sergiovanovi.react.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.INITIAL_SIZE;
import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;

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
    private int initPoolSize;
    private int maxPoolSize;


    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER,"pool")
                .option(PROTOCOL,"postgresql") // driver identifier, PROTOCOL is delegated as DRIVER by the pool.
                .option(HOST,host)
                .option(PORT,port)
                .option(DATABASE,dataBase)
                .option(USER,username)
                .option(PASSWORD,password)
                .option(INITIAL_SIZE, initPoolSize)
                .option(MAX_SIZE, maxPoolSize)
                .build());
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory factory) {
        return DatabaseClient.builder()
                .connectionFactory(factory)
                .build();
    }
}

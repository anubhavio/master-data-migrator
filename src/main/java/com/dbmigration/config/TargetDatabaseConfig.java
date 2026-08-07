package com.dbmigration.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableConfigurationProperties(MigrationDataSourceProperties.class)
public class TargetDatabaseConfig {

    @Bean(name = "targetDataSource")
    public DataSource targetDataSource(MigrationDataSourceProperties properties) {

        DatabaseProperties target = properties.getTarget();

        String url = "jdbc:mysql://"
                + target.getHost()
                + ":"
                + target.getPort()
                + "/"
                + target.getDatabase();

        return DataSourceBuilder.create()
                .url(url)
                .username(target.getUsername())
                .password(target.getPassword())
                .build();
    }

    @Bean(name = "targetJdbcTemplate")
    public JdbcTemplate targetJdbcTemplate(DataSource targetDataSource) {
        return new JdbcTemplate(targetDataSource);
    }
}
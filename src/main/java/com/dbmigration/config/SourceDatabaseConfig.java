package com.dbmigration.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableConfigurationProperties(MigrationDataSourceProperties.class)
public class SourceDatabaseConfig {

    @Bean(name = "sourceDataSource")
    public DataSource sourceDataSource(MigrationDataSourceProperties properties) {

        DatabaseProperties source = properties.getSource();

        String url = "jdbc:mysql://"
                + source.getHost()
                + ":"
                + source.getPort()
                + "/"
                + source.getDatabase();

        return DataSourceBuilder.create()
                .url(url)
                .username(source.getUsername())
                .password(source.getPassword())
                .build();
    }

    @Bean(name = "sourceJdbcTemplate")
    public JdbcTemplate sourceJdbcTemplate(DataSource sourceDataSource) {
        return new JdbcTemplate(sourceDataSource);
    }
}
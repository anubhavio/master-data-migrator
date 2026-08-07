package com.dbmigration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "migration")
@Getter
@Setter
public class MigrationDataSourceProperties {

    private DatabaseProperties source;
    private DatabaseProperties target;
}

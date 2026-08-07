package com.dbmigration;

import com.dbmigration.config.MigrationDataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MigrationDataSourceProperties.class)
public class MasterDataMigratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterDataMigratorApplication.class, args);
	}

}

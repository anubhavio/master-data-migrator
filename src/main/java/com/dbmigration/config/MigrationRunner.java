package com.dbmigration.config;

import com.dbmigration.service.MigrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrationRunner implements CommandLineRunner {

    private final MigrationService migrationService;

    public MigrationRunner(MigrationService migrationService){
        this.migrationService = migrationService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================");
        System.out.println(" Master Data Migration Started ");
        System.out.println("==================================");

        migrationService.verifyConnections();
    }
}

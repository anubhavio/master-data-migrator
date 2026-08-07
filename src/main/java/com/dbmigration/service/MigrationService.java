package com.dbmigration.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MigrationService {

    private final JdbcTemplate sourceJdbcTemplate;

    private final JdbcTemplate targetJdbcTemplate;

    public MigrationService(
            @Qualifier("sourceJdbcTemplate") JdbcTemplate sourceJdbcTemplate,
            @Qualifier("targetJdbcTemplate") JdbcTemplate targetJdbcTemplate) {

        this.sourceJdbcTemplate = sourceJdbcTemplate;
        this.targetJdbcTemplate = targetJdbcTemplate;
    }


        public void verifyConnections() {

            Integer source = sourceJdbcTemplate.queryForObject(
                    "SELECT 1",
                    Integer.class);

            Integer target = targetJdbcTemplate.queryForObject(
                    "SELECT 1",
                    Integer.class);

            System.out.println("Source DB : " + source);
            System.out.println("Target DB : " + target);
        }


}

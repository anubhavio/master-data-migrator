package com.dbmigration.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseProperties {

    private String host;
    private int port;
    private String database;

    private String username;
    private String password;
}

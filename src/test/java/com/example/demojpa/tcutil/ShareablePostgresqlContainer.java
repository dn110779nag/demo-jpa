package com.example.demojpa.tcutil;

import org.testcontainers.containers.PostgreSQLContainer;

public class ShareablePostgresqlContainer extends PostgreSQLContainer<ShareablePostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:16.2";
    private static ShareablePostgresqlContainer container;

    private ShareablePostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static ShareablePostgresqlContainer getInstance() {
        if (container == null) {
            container = new ShareablePostgresqlContainer();
        }
        return container;
    }

//    @Override
//    public void start() {
//        super.start();
//        System.setProperty("DB_URL", container.getJdbcUrl());
//        System.setProperty("DB_USERNAME", container.getUsername());
//        System.setProperty("DB_PASSWORD", container.getPassword());
//    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}

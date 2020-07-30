package com.example.datasource;

public enum DataSourceType {

    DRIVER_SERVICE_MASTER("driver_service_master"),

    DRIVER_SERVICE_SLAVE("driver_service_slave");

    private String name;

    private DataSourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

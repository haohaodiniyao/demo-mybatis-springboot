package com.example.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author (yangbo)
 * @Date: 2019/5/27 21:51
 * @Description:(hikari多数据源配置)
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DbProperties {

    private HikariDataSource driverServiceMaster;

    private HikariDataSource driverServiceSlave;

    public HikariDataSource getDriverServiceMaster() {
        return driverServiceMaster;
    }

    public void setDriverServiceMaster(HikariDataSource driverServiceMaster) {
        this.driverServiceMaster = driverServiceMaster;
    }

    public HikariDataSource getDriverServiceSlave() {
        return driverServiceSlave;
    }

    public void setDriverServiceSlave(HikariDataSource driverServiceSlave) {
        this.driverServiceSlave = driverServiceSlave;
    }
}

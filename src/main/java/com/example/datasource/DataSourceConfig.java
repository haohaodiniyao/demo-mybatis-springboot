package com.example.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * /***
 * 根据自己的相关业务,后续需要增加其它数据源的时候直接在此类中读取配置文件进行初始化
 * 所有的切换数据源放在Service层进行切换
 *
 * @author yangbo
 * @Date: 2019/1/4 11:46
 * @Description:(容器初始化数据源配置类)
 */
@Configuration
public class DataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private DbProperties dbProperties;

    /**
     * 优先使用，多数据源
     * @return DataSource
     */
    @Bean(name="dynamicDataSource")
    @Primary
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        DataSource driverServiceMaster = dbProperties.getDriverServiceMaster();
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>driver_service主库,pool-name:{}",dbProperties.getDriverServiceMaster().getPoolName());

        DataSource driverServiceSlave = dbProperties.getDriverServiceSlave();
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>driver_service从库,pool-name:{}",dbProperties.getDriverServiceSlave().getPoolName());

        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(driverServiceMaster);
        //配置多数据源
        Map<Object,Object> map = new HashMap<>();
        //key需要跟ThreadLocal中的值对应
        map.put(DataSourceType.DRIVER_SERVICE_MASTER.getName(), driverServiceMaster);
        map.put(DataSourceType.DRIVER_SERVICE_SLAVE.getName(), driverServiceSlave);

        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }
}

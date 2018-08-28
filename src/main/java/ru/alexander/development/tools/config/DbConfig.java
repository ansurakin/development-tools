package ru.alexander.development.tools.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }
    
//    @Bean
//    @ConfigurationProperties(prefix = "spring.serviceDatasource")
//    public DataSource serviceDataSource(){
//        return DataSourceBuilder.create()
//                .url("")
//                .username("")
//                .password("")
//                .driverClassName("")
//                
//                .build();
//    }

}

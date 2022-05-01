package ru.belov.bookstore.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import ru.belov.bookstore.config.properties.DataSourceConfigurationProperties;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean
    public DataSourceTransactionManager txManager(@Qualifier("dataSource") final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(DataSourceConfigurationProperties properties) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName(properties.getPoolName());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setAutoCommit(properties.getAutoCommit());
        dataSource.setMinimumIdle(properties.getMinimumIdle());
        dataSource.setMaximumPoolSize(properties.getMaximumPoolSize());
        dataSource.setMaxLifetime(properties.getMaxLifetime());
        return dataSource;
    }

}

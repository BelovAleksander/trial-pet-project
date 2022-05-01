package ru.belov.bookstore.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlyWayConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway flyway(@Qualifier("dataSource") final DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setLocations("classpath:/migrations");
        flyway.setOutOfOrder(true);
        flyway.setBaselineOnMigrate(false);
        flyway.setDataSource(dataSource);
        return flyway;
    }
}

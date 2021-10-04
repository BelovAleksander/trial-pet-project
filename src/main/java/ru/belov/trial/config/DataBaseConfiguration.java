package ru.belov.trial.config;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "ru.belov.trial.dao.mybatis.mapper", sqlSessionFactoryRef = DataBaseConfiguration.SPIR_SQL_SESSION_FACTORY)
public class DataBaseConfiguration {
    public static final String SPIR_SQL_SESSION_FACTORY = "trialPetSqlSessionFactory";

    @Value("${system.default.lang:rus}")
    private String defaultLang;

    @Value("${jdbc.url}")
    private String jbdcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${spir.db.minIdle:10}")
    private Integer minIdle;

    @Value("${spir.db.maxPool:100}")
    private Integer maxPool;

    @Value("${spir.db.idleTimeout:600000}")
    private Long idleTimeout;

    @Value("${spir.db.maxLifeTime:1800000}")
    private Long maxLifeTime;

    @Value("${spir.db.connectionTimeout:5000}")
    private Long connectionTimeout;

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setPoolName("HikariCPSPIR");
        dataSource.setJdbcUrl(jbdcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setAutoCommit(true);
        dataSource.setMinimumIdle(minIdle);
        dataSource.setMaximumPoolSize(maxPool);
        dataSource.setIdleTimeout(idleTimeout);
        dataSource.setMaxLifetime(maxLifeTime);
        dataSource.setConnectionTimeout(connectionTimeout);
        return dataSource;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(@Qualifier("dataSource") final DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setLocations("classpath:/migrations");
        flyway.setOutOfOrder(true);
        flyway.setBaselineOnMigrate(false);
        flyway.setDataSource(dataSource);
        return flyway;
    }

    @Bean
    public DataSourceTransactionManager txManager(@Qualifier("dataSource") final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SPIR_SQL_SESSION_FACTORY)
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") final DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("defaultLang", defaultLang);

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigurationProperties(properties);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("ru/belov/trial/dao/mybatis/config.xml"));
        return sqlSessionFactoryBean;
    }

}

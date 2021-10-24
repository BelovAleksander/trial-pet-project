package ru.belov.trial.dao.configuration;

import io.zonky.test.db.postgres.embedded.PreparedDbProvider;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.postgresql.PGProperty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@MapperScan(value = { "ru.belov.trial.dao.mybatis.mapper", "test.mapper" },
        sqlSessionFactoryRef = MybatisTestConfiguration.TRIAL_SQL_SESSION_FACTORY)
public class MybatisTestConfiguration {
    public static final String TRIAL_SQL_SESSION_FACTORY = "trialSqlSessionFactory";

    @Bean
    public DataSource dataSource() throws SQLException {
        var datasource = PreparedDbProvider
                .forPreparer(
                        new CustomFlywayPreparer(),
                        Collections.singleton(builder ->
                                builder.setConnectConfig(PGProperty.STRING_TYPE.getName(), "unspecified")
                        ))
                .createDataSource();
        return datasource;
    }

    @Bean
    public DataSourceTransactionManager txManager(@Qualifier("dataSource") final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = TRIAL_SQL_SESSION_FACTORY)
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") final DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("defaultLang", "rus");

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigurationProperties(properties);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/ru/belov/trial/dao/mybatis/config.xml"));
        return sqlSessionFactoryBean;
    }
}
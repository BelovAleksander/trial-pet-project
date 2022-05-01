package ru.belov.bookstore.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "ru.belov.bookstore.infrastructure.dao.mybatis.mapper", sqlSessionFactoryRef = MyBatisConfiguration.SPIR_SQL_SESSION_FACTORY)
public class MyBatisConfiguration {
    public static final String SPIR_SQL_SESSION_FACTORY = "sqlSessionFactory";
    public static final String CONFIG_LOCATION = "ru.belov.bookstore.infrastructure.dao.mybatis/mapper/config.xml";

    @Value("${system.default.lang:rus}")
    private String defaultLang;

    @ConditionalOnProperty(prefix = "database", name = "framework", havingValue = "mybatis")
    @Bean(name = SPIR_SQL_SESSION_FACTORY)
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") final DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("defaultLang", defaultLang);

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigurationProperties(properties);
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(CONFIG_LOCATION));
        return sqlSessionFactoryBean;
    }
}

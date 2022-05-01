package ru.belov.bookstore.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfigurationProperties {

    @NotBlank
    private final String driverClassName;
    @NotBlank
    private final String url;
    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
    @NotBlank
    private final String poolName;
    @NotNull
    private final Integer maxLifetime;
    @NotNull
    private final Integer minimumIdle;
    @NotNull
    private final Integer maximumPoolSize;
    @NotNull
    private final Boolean autoCommit;
}

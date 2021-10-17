package ru.belov.trial.dao.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"test.helper", "test.util"})
public class TestCaseConfiguration {
}

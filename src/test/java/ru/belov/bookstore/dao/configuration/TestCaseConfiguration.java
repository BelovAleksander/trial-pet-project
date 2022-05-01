package ru.belov.bookstore.dao.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"test.infrastructure"})
public class TestCaseConfiguration {
}

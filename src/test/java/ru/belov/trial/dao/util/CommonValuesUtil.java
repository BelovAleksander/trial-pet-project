package ru.belov.trial.dao.util;

import com.github.javafaker.Faker;

public class CommonValuesUtil {

    private static final Faker faker = new Faker();

    public static String randomText() {
        return faker.harryPotter().location();
    }

    public static String randomCode() {
        return faker.regexify("[1-9]{6}");
    }
}

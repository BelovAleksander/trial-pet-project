package ru.belov.trial.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {
    RUS ("rus"),
    ENG("eng");

    private final String code;
}

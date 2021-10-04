package ru.belov.trial.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientType {
    FIZ("1"),
    UR("2");

    final String code;
}

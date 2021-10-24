package ru.belov.trial.infrastructure;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.belov.trial.constant.Language;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
@JsonSerialize(using = JsonLocalizedStringSerializer.class)
@JsonDeserialize(using = JsonLocalizedStringDeserializer.class)
@NoArgsConstructor
public class LocalizedString implements Serializable {
    private final Map<Language, String> strings = new HashMap<>();

    public String get(Language lang) {
        if (lang == null) {
            return null;
        } else {
            return this.strings.getOrDefault(lang, null);
        }
    }

    public void set(Language lang, String text) {
        if (text != null && lang != null) {
            this.strings.put(lang, text);
        }
    }

    public static LocalizedString from(Language lang, String text) {
        LocalizedString localizedString = new LocalizedString();
        localizedString.set(lang, text);
        return localizedString;
    }

    public static LocalizedString from(Map<Language, String> strings) {
        LocalizedString localizedString = new LocalizedString();
        strings.forEach(localizedString::set);
        return localizedString;
    }

    public Map<Language, String> getStrings() {
        return this.strings;
    }
}
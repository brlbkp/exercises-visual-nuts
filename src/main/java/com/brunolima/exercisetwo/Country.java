package com.brunolima.exercisetwo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Country {
    private final String alphaTwoCode;
    private final Set<Language> languages;

    public Country(String alphaTwoCode, List<String> languages) {
        this.alphaTwoCode = alphaTwoCode;
        this.languages = languages.stream().map(Language::new).collect(Collectors.toSet());
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public Set<Language> getLanguages() {
        return new HashSet<>(this.languages);
    }

    public int countLanguages() {
        return languages.size();
    }

    @Override
    public String toString() {
        return this.alphaTwoCode;
    }
}

package by.tut.ssmt.service;

import by.tut.ssmt.exceptions.LanguageException;

public class EngRusInputProcessor implements InputProcessor {


    public void validateEntryScript(String entry) throws LanguageException {
        if (entry == null || !entry.matches("^[a-zA-Z]+$")) {
            throw new LanguageException("Language Exception: incorrect input - only latin symbols are allowed");
        }

    }

    public void validateTranslationScript(String entry) throws LanguageException {
        if (entry == null || !entry.matches("^[а-яА-ЯёЁ]+$")) {
            throw new LanguageException("Language Exception: incorrect input - only cyrillic symbols are allowed");
        }
    }

}

package by.tut.ssmt.service;

import by.tut.ssmt.exceptions.LanguageException;

public final class InputProcessorEngRusImpl implements InputProcessor {

    public InputProcessorEngRusImpl() {
    }

    @Override
    public void validateEntryScript(String entry) throws LanguageException {
        if (entry == null || !entry.matches("^[a-zA-Z]+$")) {
            throw new LanguageException("Language Exception: incorrect input - only latin symbols are allowed");
        }

    }

    @Override
    public void validateTranslationScript(String entry) throws LanguageException {
        if (entry == null || !entry.matches("^[а-яА-ЯёЁ]+$")) {
            throw new LanguageException("Language Exception: incorrect input - only cyrillic symbols are allowed");
        }
    }

}

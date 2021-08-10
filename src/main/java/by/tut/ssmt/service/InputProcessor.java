package by.tut.ssmt.service;

import by.tut.ssmt.exceptions.LanguageException;

public interface InputProcessor {

    void validateEntryScript(String entry) throws LanguageException;
    void validateTranslationScript(String entry) throws LanguageException;

}

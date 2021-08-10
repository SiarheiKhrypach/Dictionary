package by.tut.ssmt;

import by.tut.ssmt.console.DictionaryConsoleApplication;
import by.tut.ssmt.exceptions.LanguageException;
import by.tut.ssmt.service.DictionaryProcessor;
import by.tut.ssmt.service.EngRusDictionaryProcessorWithQuiz;
import by.tut.ssmt.service.EngRusInputProcessor;
import by.tut.ssmt.dictionaries.EngRus;
import by.tut.ssmt.service.InputProcessor;

public class Main {
    public static void main(String[] args) throws LanguageException {

        final EngRus engRus = new EngRus();
        final DictionaryProcessor engRusDictionaryProcessor = new EngRusDictionaryProcessorWithQuiz(engRus.getEngRusDictionary());
        final InputProcessor engRusInputProcessor = new EngRusInputProcessor();
        final DictionaryConsoleApplication app = new DictionaryConsoleApplication(engRusDictionaryProcessor, engRusInputProcessor);
        app.start();

    }
}

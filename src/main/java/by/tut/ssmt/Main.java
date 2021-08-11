package by.tut.ssmt;

import by.tut.ssmt.console.DictionaryConsoleApplication;
import by.tut.ssmt.exceptions.LanguageException;
import by.tut.ssmt.service.DictionaryProcessor;
import by.tut.ssmt.service.DictionaryProcessorEngRusWithQuizImpl;
import by.tut.ssmt.service.InputProcessorEngRusImpl;
import by.tut.ssmt.dictionaries.EngRus;
import by.tut.ssmt.service.InputProcessor;

public class Main {
    public static void main(String[] args) throws LanguageException {

        final EngRus engRus = new EngRus();
        final DictionaryProcessor engRusDictionaryProcessor = new DictionaryProcessorEngRusWithQuizImpl(engRus.getEngRusDictionary());
        final InputProcessor engRusInputProcessor = new InputProcessorEngRusImpl();
        final DictionaryConsoleApplication app = new DictionaryConsoleApplication(engRusDictionaryProcessor, engRusInputProcessor);
        app.start();


    }
}

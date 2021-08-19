package by.tut.ssmt;

import by.tut.ssmt.console.DictionaryConsoleApplication;
import by.tut.ssmt.service.*;
import by.tut.ssmt.dictionaries.EngRus;

public class Main {
    public static void main(String[] args) {

        final EngRus engRus = new EngRus();
        final DictionaryProcessor engRusDictionaryProcessor = new DictionaryProcessorEngRusWithQuizImpl(engRus.getEngRusDictionary());
        final InputProcessor engRusInputProcessor = new InputProcessorEngRusImpl();
        final DictionaryConsoleApplication app = new DictionaryConsoleApplication(engRusDictionaryProcessor, engRusInputProcessor);
        app.start();
    }
}

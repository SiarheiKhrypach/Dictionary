package by.tut.ssmt.console;

import by.tut.ssmt.exceptions.LanguageException;
import by.tut.ssmt.service.DictionaryProcessor;
import by.tut.ssmt.service.InputProcessor;

import java.io.Closeable;
import java.util.Scanner;

public final class DictionaryConsoleApplication {

    public static final String WELCOME_MESSAGE = "Press:\n 0 - Exit" +
            "\n 1 - Add new word" +
            "\n 2 - EN-RU translation" +
            "\n 3 - RU-EN translation" +
            "\n 4 - Show the list size (words number)" +
            "\n 5 - Print the list" +
            "\n 6 - Exam";

    public static final int EXIT = 0, ADD_NEW_WORD = 1, EN_RU_TRANSLATION = 2, RU_EN_TRANSLATION = 3, LIST_SIZE = 4,
            LIST_PRINT = 5, EXAM = 6, RESTART_VALUE = 999;

    public static final String DELIMITER = "\n===================================================\n";

    private final Scanner scanner = new Scanner(System.in);

    private final Closeable[] closeables;
    private final DictionaryProcessor dictionaryProcessor;
    private final InputProcessor inputProcessor;

    public DictionaryConsoleApplication(DictionaryProcessor dictionaryProcessor, InputProcessor inputProcessor) {
        this.dictionaryProcessor = dictionaryProcessor;
        this.inputProcessor = inputProcessor;
        this.closeables = new Closeable[]{scanner};
    }

    public void start() {
        processMenu();
        cleanUpCloseables();
    }

    private void processMenu()  {
        boolean isRunning = true;
        while (isRunning) {
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);
            int consoleChoice = getConsoleChoice();
            switch (consoleChoice) {
                case EXIT:
                    isRunning = false;
                    printConsole("App closes.");
                    break;
                case ADD_NEW_WORD:
                    update();
                    break;
                case EN_RU_TRANSLATION:
                    translateEnRu();
                    break;
                case RU_EN_TRANSLATION:
                    translateRuEn();
                    break;
                case LIST_SIZE:
                    listSize();
                    break;
                case LIST_PRINT:
                    listPrint();
                    break;
                case EXAM:
                    takeExam();
                    break;

                default:
                    printConsole("Invalid choice, restarting app." + DELIMITER);
            }
        }
    }

    private int getConsoleChoice() {
        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            cleanScannerNextEnteredValue();
            choice = RESTART_VALUE;
        }
        return choice;
    }

    private void update() {
        printConsole("Enter a new word");
        String entry = scanner.next();
        try {
            inputProcessor.validateEntryScript(entry);
        } catch (LanguageException e) {
            printException(e.getMessage());
        } finally {
            printConsole("Enter the translation");
            String translation = scanner.next();
            try {
                inputProcessor.validateTranslationScript(translation);
            } catch (LanguageException e) {
                printException(e.getMessage());
            } finally {
            dictionaryProcessor.addNewWord(entry, translation);
            printConsole("Your word and translation got recorded");
            pressEnterToContinue();
        }
        }
    }

    private void translateEnRu() {
        try {
            printConsole("Enter the word you want to translate to russian");
            String entry = scanner.next();
            inputProcessor.validateEntryScript(entry);
            printConsole(dictionaryProcessor.translate(entry));
        } catch (LanguageException e) {
            printException(e.getMessage());
        } finally {
            pressEnterToContinue();
        }
    }

    private void translateRuEn() {
        try {
            printConsole("Enter the word you want to get the english translation of");
            String entry = scanner.next();
            inputProcessor.validateTranslationScript(entry);
            printConsole(dictionaryProcessor.reverseTranslate(entry));
        } catch (LanguageException e) {
            printException(e.getMessage());
        } finally {
            pressEnterToContinue();
        }
    }

    private void listSize() {
        printConsole("You chose to show the size of the list");
        printConsole(dictionaryProcessor.countEntries());
        pressEnterToContinue();
    }

    private void listPrint() {
        printConsole("You chose to print the list:");
        printConsole(dictionaryProcessor.showAll());
        pressEnterToContinue();
    }

    private void takeExam() {
        printConsole("You chose to exam");
        dictionaryProcessor.exam();
        pressEnterToContinue();
    }

    private void cleanScannerNextEnteredValue() {
        final String next = scanner.next();
        printConsole("Entered next=[" + next + "].");
    }

    private void printConsole(final String message) {
        System.out.println(message);
    }

    private void printException(final String message) {
        System.out.println(message);
    }

    private void pressEnterToContinue() {
        Scanner scan = new Scanner(System.in);
        printConsole("Press Enter to continue.");
        scan.nextLine();
    }

    private void cleanUpCloseables() {
        for (final AutoCloseable closeable : closeables) {
            try {
                closeable.close();
                System.out.println("Resource is closed, " + closeable.getClass());

            } catch (final Exception e) {
                System.out.println("Something went wrong during closing " + closeable.getClass());
                e.printStackTrace();
            }
        }
    }
}

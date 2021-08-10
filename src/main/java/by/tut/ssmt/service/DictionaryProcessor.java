package by.tut.ssmt.service;

public interface DictionaryProcessor {
    void addNewWord(String entry, String translation);
    String translate(String entry);
    String reverseTranslate(String entry);
    String countEntries();
    String showAll();
    void exam();
}

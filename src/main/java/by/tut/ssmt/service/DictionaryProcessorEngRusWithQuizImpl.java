package by.tut.ssmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class DictionaryProcessorEngRusWithQuizImpl implements DictionaryProcessor {

    private final Map<String, String> map;
    private final Scanner scanner = new Scanner(System.in);

    public final Map<String, String> getMap() {
        return map;
    }

    public DictionaryProcessorEngRusWithQuizImpl(Map map) {
        this.map = map;
    }

    @Override
    public void addNewWord(String entry, String translation) {
        map.put(entry, translation);
    }

    @Override
    public String translate(String entry) {
        return map.get(entry) == null ? "not found" : map.get(entry);
    }

    @Override
    public String reverseTranslate(String entry) {
        ArrayList listAnswers = prepareArrayListToFill();
        fillArrayList(entry, listAnswers);
        prepareArrayListToPrint(listAnswers);
        String reverseTranslation = String.join(", ", listAnswers);
        return reverseTranslation;
    }

    @Override
    public String countEntries() {
        return String.valueOf(map.size());
    }

    @Override
    public String showAll() {
        return map.toString();
    }

    public void exam() {
        System.out.println("The type of exam: quiz");
        Map<String, String> wrongAnswersMap = new HashMap<>();
        Map<String, String> cloneMap = copyMap(map);
        int rightAnswerCounter = 0;
        for (int i = 0; i < 5; i++) {
            String randomMapKey = getRandomMapKey(cloneMap);
            System.out.println("Enter the translation for the next word: " + randomMapKey);
            String entry = scanner.nextLine();
            if (entry.equals(cloneMap.get(randomMapKey))) {
                System.out.println("Your answer is correct!");
                rightAnswerCounter++;
            } else {
                wrongAnswersMap.put(randomMapKey, cloneMap.get(randomMapKey));
            }
            cloneMap.remove(randomMapKey);
        }
        System.out.println("You got the right answer for " + ((double)rightAnswerCounter/5)*100 + "% of questions. Have a look" +
                " at the mistakes you made: \n" + wrongAnswersMap);
    }

    private Map<String, String> copyMap(Map<String, String> map) {
        Map<String, String> cloneMap = new HashMap<>();
        cloneMap.putAll(map);
        return cloneMap;
    }

    private String getRandomMapKey(Map<String, String> map) {
        int randomNumber = (int) (Math.random() * map.size());
        return (String) map.keySet().toArray()[randomNumber];
    }

    private void fillArrayList(String entry, ArrayList listAnswers) {
        for (Map.Entry<String, String> ent : map.entrySet()) {
            if (ent.getValue().equals(entry)) {
                listAnswers.add(ent.getKey());
            }
        }
    }

    private void prepareArrayListToPrint(ArrayList listAnswers) {
        if (listAnswers.size()>1) {
            listAnswers.remove("not found");
        }
    }

    private ArrayList prepareArrayListToFill() {
        ArrayList listAnswers = new ArrayList();
        listAnswers.add("not found");
        return listAnswers;
    }

}

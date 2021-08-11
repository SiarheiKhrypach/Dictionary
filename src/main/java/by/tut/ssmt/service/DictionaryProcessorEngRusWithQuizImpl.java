package by.tut.ssmt.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryProcessorEngRusWithQuizImpl implements DictionaryProcessor {

    private final Map<String, String> map;
    private final Scanner scanner = new Scanner(System.in);

    public DictionaryProcessorEngRusWithQuizImpl(Map map) {
        this.map = map;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void addNewWord(String entry, String translation) {
        map.put(entry, translation);
    }

    public String translate(String entry) {
        return map.get(entry) == null ? "not found" : map.get(entry);
    }

    public String reverseTranslate(String entry) {
        String searchResult = "not found";
        for (Map.Entry<String, String> ent : map.entrySet()) {
            if (ent.getValue().equals(entry)) {
                searchResult = ent.getKey();
            }
        }
        return searchResult;
    }

    public String countEntries() {
        return String.valueOf(map.size());
    }

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

}

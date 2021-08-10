package by.tut.ssmt.dictionaries;

import java.util.HashMap;

public class EngRus {

    private final HashMap<String, String> EngRusDictionaryStartKit = new HashMap <String, String> () {{
        put("tree", "дерево");
        put("sun", "солнце");
        put("moon", "луна");
        put("weather", "погода");
        put("sky", "небо");
        put("snow", "снег");
        put("rain", "дождь");
        put("bird", "птица");
        put("skin", "кожа");
        put("hair", "волос");
    }};

    private final HashMap<String, String> engRusDictionary;

    public EngRus() {
        engRusDictionary = EngRusDictionaryStartKit;
    }

    public HashMap<String, String> getEngRusDictionary() {
        return engRusDictionary;
    }

}

package by.tut.ssmt.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DictionaryProcessorEngRusWithQuizImplTest {
    private DictionaryProcessorEngRusWithQuizImpl dictionaryProcessorEngRusWithQuizImpl;

    @Before
    public void setUp() {
        System.out.println("Test is starting...");

        HashMap<String, String> testEngRusDictionary = new HashMap<String, String>() {{
            put("tree", "дерево");
            put("sun", "солнце");
            put("moon", "луна");
        }};

        dictionaryProcessorEngRusWithQuizImpl = new DictionaryProcessorEngRusWithQuizImpl(testEngRusDictionary);

    }

    @Test
    public void testIfAddNewWordIncreaseMapSize() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().size(), is(3));
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("spoon", "ложка");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().size(), is(4));
    }

    @Test
    public void testIfAddNewWordValueMatchKey() {
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("spoon", "ложка");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().get("spoon"), is("ложка"));
    }

    @Test
    public void testTranslate() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.translate("tree"), is("дерево"));
    }

    @Test
    public void testTranslateOfMissingWord() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.translate("forest"), is("not found"));
    }

    @Test
    public void testReverseTranslate() {
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("spoon", "ложка");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.reverseTranslate("ложка"), is("spoon"));
    }

    @Test
    public void testReverseTranslateOfMissingWord() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.reverseTranslate("стол"), is("not found"));
    }

    @Test
    public void testIfDuplicateGetsRewritten() {
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("tree", "древо");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().get("tree"), is("древо"));
        assertThat(dictionaryProcessorEngRusWithQuizImpl.reverseTranslate("дерево"), is("not found"));
    }

    @Test
    public void testIfDuplicateGetsRewrittenAndInitialTranslationDisappear() {
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("tree", "древо");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().get("tree"), is("древо"));
        assertThat(dictionaryProcessorEngRusWithQuizImpl.reverseTranslate("дерево"), is("not found"));
    }

    @Test
    public void testCountEntries() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.countEntries(), is("3"));
    }

}
package by.tut.ssmt.service;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DictionaryProcessorEngRusWithQuizImplTest extends TestCase {
    private DictionaryProcessorEngRusWithQuizImpl dictionaryProcessorEngRusWithQuizImpl;

    @Before
    public void setUp() {
        System.out.println("Test is starting...");

        HashMap<String, String> testEngRusDictionary = new HashMap <String, String> () {{
            put("tree", "дерево");
            put("sun", "солнце");
            put("moon", "луна");
        }};

        dictionaryProcessorEngRusWithQuizImpl = new DictionaryProcessorEngRusWithQuizImpl(testEngRusDictionary);

    }

    public void testAddNewWord() {
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().size(), is(3));
        dictionaryProcessorEngRusWithQuizImpl.addNewWord("spoon", "ложка");
        assertThat(dictionaryProcessorEngRusWithQuizImpl.getMap().size(), is(4));
    }
}
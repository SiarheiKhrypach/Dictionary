package by.tut.ssmt.service;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngRusDictionaryProcessorWithQuizTest extends TestCase {
    private EngRusDictionaryProcessorWithQuiz engRusDictionaryProcessorWithQuiz;

    @Before
    public void setUp() {
        System.out.println("Test is starting...");

        HashMap<String, String> testEngRusDictionary = new HashMap <String, String> () {{
            put("tree", "дерево");
            put("sun", "солнце");
            put("moon", "луна");
        }};

        engRusDictionaryProcessorWithQuiz = new EngRusDictionaryProcessorWithQuiz(testEngRusDictionary);

    }

    public void testAddNewWord() {
        assertThat(engRusDictionaryProcessorWithQuiz.getMap().size(), is(3));
        engRusDictionaryProcessorWithQuiz.addNewWord("spoon", "ложка");
        assertThat(engRusDictionaryProcessorWithQuiz.getMap().size(), is(4));
    }
}
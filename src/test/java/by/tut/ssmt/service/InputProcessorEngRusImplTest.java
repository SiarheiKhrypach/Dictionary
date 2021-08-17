package by.tut.ssmt.service;

import by.tut.ssmt.exceptions.LanguageException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class InputProcessorEngRusImplTest {

    final InputProcessorEngRusImpl inputProcessorEngRusImpl = new InputProcessorEngRusImpl();

    @Test
    public void testValidateEntryScript() {
        Exception exception = assertThrows(LanguageException.class, () ->
                inputProcessorEngRusImpl.validateEntryScript("кпыв3325"));
        Assert.assertEquals("Language Exception: incorrect input - only latin symbols are allowed", exception.getMessage());
    }

    @Test
    public void testValidateTranslationScript() {
        Exception exception = assertThrows(LanguageException.class, () ->
                inputProcessorEngRusImpl.validateTranslationScript("sdgsdg23423"));
        Assert.assertEquals("Language Exception: incorrect input - only cyrillic symbols are allowed", exception.getMessage());
    }


}
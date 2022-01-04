import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VariableTest {
    @DisplayName("Check variable values are correct")
    @Test // this annotation
    void learnTheVariablesValidCase() {
        int osNum = 12;

        int expectedValue = 12;

        Assertions.assertEquals(expectedValue, osNum);
    }

    @DisplayName("Check variable values are incorrect")
    @Test
    void learVariablesInvalidCase() {
        int osNum = 12;
        int expectedValue = 13;
        Assertions.assertNotEquals(expectedValue, osNum);
    }
}





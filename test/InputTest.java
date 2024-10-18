import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTest {

    @Test
    void testUserInput() {
        // Simulate user input
        //Change Systems InputStream in to a ByteArrayInputStream instead
        String simulatedInput = "Test passed!";
        InputStream originalIn = System.in;
        ByteArrayInputStream simulatedIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedIn); //Change System.in to System.simulatedIn

        Input input = new Input();
        String result = input.getUserInput("Write: Test passed!");

        assertEquals("Test passed!", result);
        assertNotEquals("Test failed!", result);

        System.setIn(originalIn); //Restore System.in
    }
}

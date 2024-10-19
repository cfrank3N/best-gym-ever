package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {


    @Test
    void testUserInput() throws BestGymException {
        // Simulate user input
        //Change Systems InputStream in to a ByteArrayInputStream instead
        String simulatedInput = "    Test passed!   ";
        Scanner scan = new Scanner(simulatedInput);
        String result = Input.getUserInput("Write: Test passed!", scan);

        assertEquals("Test passed!", result);
        assertNotEquals("Test failed!", result);

    }
}

package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static inputoutput.Input.getUserInput;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {


    @Test
    void testUserInput() throws BestGymException {
        // Simulate user input
        String simulatedInput = "    Test passed!   ";
        Scanner scan = new Scanner(simulatedInput);
        String result = getUserInput("Write: Test passed!", scan);

        assertEquals("Test passed!", result);
        assertNotEquals("Test failed!", result);

    }
}

package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class InputTest {

    @Test
    void testUserInput() throws BestGymException {
        // Simulate user input
        //Change Systems InputStream in to a ByteArrayInputStream instead
        Scanner s = new Scanner(System.in);
        String simulatedInput = "Test passed!";
        InputStream originalIn = System.in;
        ByteArrayInputStream simulatedIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedIn); //Change System.in to System.simulatedIn

        String result = Input.getUserInput("Write: Test passed!", s);

        assertEquals("Test passed!", result);
        assertNotEquals("Test failed!", result);

        System.setIn(originalIn); //Restore System.in
    }

    @Test
    public void testThrowsException() {
        Scanner s = new Scanner(System.in);

        InputStream originalIn = System.in;
        System.setIn(null); //Change System.in to System.simulatedIn

        assertThrows(BestGymException.class, () -> Input.getUserInput("Write: Test passed!", s));

        System.setIn(originalIn); //Restore System.in
    }



}

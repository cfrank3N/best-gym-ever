package inputoutput;

import exceptions.BestGymException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {


    @Test
    void testUserInput() throws BestGymException {
        //Simulate user input
        //Change Systems InputStream in to a ByteArrayInputStream instead
        String simulatedInput = "   Test passed!   ";
        InputStream originalIn = System.in;
        ByteArrayInputStream simulatedIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(simulatedIn); //Change System.in to System.simulatedIn

        String result = Input.getUserInput("Write: Test passed!");

        assertEquals("Test passed!", result);
        assertNotEquals("Test failed!", result);

        System.setIn(originalIn); //Restore System.in
    }

    @Test
    public void testThrowsException() {
        InputStream originalIn = System.in;
        System.setIn(null); //Change System.in to null
        BestGymException e = assertThrows(BestGymException.class, () -> Input.getUserInput("Write: Test passed!"));
        System.err.println(e.getMessage());
        System.setIn(originalIn); //Restore System.in
    }

}

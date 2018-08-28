package packageDependency;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Place holder for your unit tests;
 * negative tests added here since they were not covered
 */
public class YourUnitTest extends BaseTest {

    @Test
    //DEPEND: no output for DEPEND
    public void testDependThrowsException() throws IOException {
        String[] input = {
                "DEPEND \n",
                "END\n"
        };

      try {
          runTest(input);
          fail("method did not throw illegalArgumentException");
      }
      catch (IllegalArgumentException ex){
          assertEquals(ex.getMessage(), "DEPEND needs alteast two packages. usage: DEPEND A B");

      }
    }

    @Test
    //REMOVE: remove the module
    public void testRemoveWithMoreArguments() throws IOException {
        String[] input = {
                "DEPEND A B\n",
                "INSTALL B\n",
                "INSTALL A\n",
                "REMOVE A D\n",
                "END\n"
        };

        String expectedOutput = "DEPEND A B\n" +
                "INSTALL B\n" +
                "Installing B\n" +
                "INSTALL A\n" +
                "Installing A\n" +
                "REMOVE A D\n" +
                "REMOVE supports only one package at a time. ignoring the rest\n" +
                "Removing A\n" +
                "END\n";

        runTest(expectedOutput, input);
    }

    @Test
    //REMOVE: remove the module
    public void testRemoveThrowsException() throws IOException {
        String[] input = {
                "REMOVE\n",
                "END\n"
        };
        try {
            runTest(input);
            fail("method did not throw illegalArgumentException");
        }
        catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "package not supplied; usage: REMOVE A");

        }
    }

    @Test
    public void testUnSupportedOperation() throws IOException {
        String[] input = {
                "ADD\n",
                "END\n"
        };
        try {
            runTest(input);
            fail("method did not throw illegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "ADD - unsupported operation. allowed ones are LIST, DEPEND, INSTALL, REMOVE");
        }

    }
}

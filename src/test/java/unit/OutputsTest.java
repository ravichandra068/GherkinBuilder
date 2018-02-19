package unit;

import com.coveros.Outputs;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputsTest {

    @Test(expectedExceptions = IOException.class)
    public void checkInputsNoneTest() throws IOException {
        Outputs.checkInputs(new String[0]);
    }

    @Test(expectedExceptions = IOException.class)
    public void checkInputsTwoTest() throws IOException {
        Outputs.checkInputs(new String[2]);
    }

    @Test(expectedExceptions = IOException.class)
    public void checkInputsBadLocationTest() throws IOException {
        Outputs.checkInputs(new String[]{"badLocation"});
    }

    @Test
    public void checkInputsGoodLocationTest() throws IOException {
        Assert.assertEquals(Outputs.checkInputs(new String[]{"src/test/java"}), new File("src/test/java"));
    }

    @Test
    public void listFilesForFolder() {
        Assert.assertEquals(Outputs.listFilesForFolder(new File("src/test/java")).size(), 3);
    }
}
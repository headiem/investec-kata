package za.co.tsheporachidi;

import org.junit.Assert;
import org.junit.Test;
import za.co.tsheporachidi.exception.HighestCommonDenominatorException;

public class HighestCommonFactorTest {

    @Test(expected = HighestCommonDenominatorException.class)
    public void testHighestCommonFactorException() {
        new HighestCommonFactor().highestCommonFactor(new int[]{0, 1});
    }

    @Test
    public void testHighestCommonFactor() {
        Assert.assertEquals("Testing for a single number", 90, new HighestCommonFactor()
                .highestCommonFactor(new int[]{90}));
        Assert.assertEquals("Testing for two numbers", 4, new HighestCommonFactor()
                .highestCommonFactor(new int[]{8,12}));
        Assert.assertEquals("Testing for three numbers", 500, new HighestCommonFactor()
                .highestCommonFactor(new int[]{500,4000, 2000}));

    }
}
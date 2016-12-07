import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTest
{
    private static final int[] NUMBERS = new int[]{ 0, 5, 13, -1, 0xAD, 0xB2A4 };
    
    
    @Test
    public void testContains()
    {
        Assert.assertTrue(ArrayUtils.contains(NUMBERS, 5));
        Assert.assertTrue(ArrayUtils.contains(NUMBERS, 13));
        Assert.assertFalse(ArrayUtils.contains(NUMBERS, 0xAA));
        Assert.assertTrue(ArrayUtils.contains(NUMBERS, 0xAD));
    }
}

import org.junit.Assert;
import org.junit.Test;

public class NumberTest
{
    @Test
    public void testEquivelancy()
    {
        short exampleItem = (short) 0xFF;
        int exampleItemValue = 255;
        
        Assert.assertEquals(exampleItem, exampleItemValue);
    }
}

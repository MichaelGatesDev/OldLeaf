import com.michaelgatesdev.OldLeaf.util.RegexUtil;
import org.junit.Assert;
import org.junit.Test;

public class RegexTest
{
    @Test
    public void testHex()
    {
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xFF").find());            // 0xFF = 255
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xAABBCC").find());        // Test of basic characters
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0xABCDEF").find());        // In-order characters
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x101010").find());        // Looks like binary, but it's obviously not
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x0000000").find());       // Has 7 digits
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("0x000000D").find());       // Has 7 digits
        Assert.assertTrue(RegexUtil.HEX_PATTERN.matcher("Has 0xFF").find());  // Has 7 digits
        
        Assert.assertFalse(RegexUtil.HEX_PATTERN.matcher("0xFG").find());           // G is not a valid value
        Assert.assertFalse(RegexUtil.HEX_PATTERN.matcher("Random 0x").find());         // random string
    }
}

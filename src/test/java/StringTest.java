import com.michaelgatesdev.OldLeaf.memory.LimitedByteString;
import org.junit.Assert;
import org.junit.Test;

public class StringTest
{
    @Test
    public void testLimitedStrings()
    {
        int maxUsernameLength = 16;
        LimitedByteString username = new LimitedByteString("This username can only be 16 characters long.", maxUsernameLength);
        
        Assert.assertTrue(username.getData().length() == maxUsernameLength);
    }
}

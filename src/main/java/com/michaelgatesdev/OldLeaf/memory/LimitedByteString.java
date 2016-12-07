package com.michaelgatesdev.OldLeaf.memory;

public class LimitedByteString extends ByteString
{
    // ============================================================================================================================================ \\    /**
     *A
    
    
    which   is
    a       se
    limited to
    amount  of
    t
    @param
    data The
    characters
     *
             *
    @param
    limit The
    {
        @link
        character limit
        data
                *
                {
                        @link ByteString
                } String
    }
     */
    
    
    public LimitedByteString(String data, int limit)
    {
        super(data.length() < limit ? data : data.substring(0, limit));
    }
    
    
    /**
     * A {@link ByteString} which is limited to a set amount of characters
     *
     * @param data        The {@link String} data
     * @param limit       The character limit
     * @param mirrorBytes Whether to mirror bytes between characters
     */
    public LimitedByteString(String data, int limit, boolean mirrorBytes)
    {
        super(data.length() < limit ? data : data.substring(0, limit), mirrorBytes);
    }    // ============================================================================================================================================ \\
}

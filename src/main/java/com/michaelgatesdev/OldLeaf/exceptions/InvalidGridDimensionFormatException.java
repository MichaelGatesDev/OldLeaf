package com.michaelgatesdev.OldLeaf.exceptions;

public class InvalidGridDimensionFormatException extends Exception
{
    public InvalidGridDimensionFormatException()
    {
    }
    
    
    public InvalidGridDimensionFormatException(String message)
    {
        super(message);
    }
    
    
    public InvalidGridDimensionFormatException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    public InvalidGridDimensionFormatException(Throwable cause)
    {
        super(cause);
    }
    
    
    public InvalidGridDimensionFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

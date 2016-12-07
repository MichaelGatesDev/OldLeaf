package com.michaelgatesdev.OldLeaf.exceptions;

public class SaveSizeInvalidException extends Exception
{
    /**
     * Thrown when a save is loaded and is an invalid size
     */
    public SaveSizeInvalidException()
    {
    }
    
    
    /**
     * Thrown when a save is loaded and is an invalid size
     */
    public SaveSizeInvalidException(String message)
    {
        super(message);
    }
    
    
    /**
     * Thrown when a save is loaded and is an invalid size
     */
    public SaveSizeInvalidException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    
    /**
     * Thrown when a save is loaded and is an invalid size
     */
    public SaveSizeInvalidException(Throwable cause)
    {
        super(cause);
    }
    
    
    /**
     * Thrown when a save is loaded and is an invalid size
     */
    public SaveSizeInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

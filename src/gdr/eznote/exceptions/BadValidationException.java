package gdr.eznote.exceptions;

/**
 *
 * @author GDR
 */
public class BadValidationException extends Exception {
    
    /**
     *
     * @param message
     */
    public BadValidationException(String message) { 
        super(message); 
    }

    /**
     *
     * @param message
     * @param cause
     */
    public BadValidationException(String message, Throwable cause) { 
        super(message, cause); 
    }

    /**
     *
     * @param cause
     */
    public BadValidationException(Throwable cause) { 
        super(cause); 
    }
    
}

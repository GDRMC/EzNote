package gdr.eznote.exceptions;

/**
 *
 * @author GDR
 */
public class OptionPaneValueOutOfBoundsException extends Exception {
    
    /**
     *
     * @param message
     */
    public OptionPaneValueOutOfBoundsException(String message) { 
        super(message); 
    }

    /**
     *
     * @param message
     * @param cause
     */
    public OptionPaneValueOutOfBoundsException(String message, Throwable cause) { 
        super(message, cause); 
    }

    /**
     *
     * @param cause
     */
    public OptionPaneValueOutOfBoundsException(Throwable cause) { 
        super(cause); 
    }
    
}

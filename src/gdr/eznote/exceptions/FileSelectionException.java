package gdr.eznote.exceptions;

/**
 *
 * @author GDR
 */
public class FileSelectionException extends Exception {
    /**
     *
     * @param message
     */
    public FileSelectionException(String message) { 
        super(message); 
    }

    /**
     *
     * @param message
     * @param cause
     */
    public FileSelectionException(String message, Throwable cause) { 
        super(message, cause); 
    }

    /**
     *
     * @param cause
     */
    public FileSelectionException(Throwable cause) { 
        super(cause); 
    }
}

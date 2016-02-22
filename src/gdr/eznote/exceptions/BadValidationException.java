package gdr.eznote.exceptions;

public class BadValidationException extends Exception {
    
    public BadValidationException(String message) { 
        super(message); 
    }
    public BadValidationException(String message, Throwable cause) { 
        super(message, cause); 
    }
    public BadValidationException(Throwable cause) { 
        super(cause); 
    }
    
}

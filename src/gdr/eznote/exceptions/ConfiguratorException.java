/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdr.eznote.exceptions;

/**
 *
 * @author GDR
 */
public class ConfiguratorException extends Exception {
    /**
     *
     * @param message
     */
    public ConfiguratorException(String message) { 
        super(message); 
    }

    /**
     *
     * @param message
     * @param cause
     */
    public ConfiguratorException(String message, Throwable cause) { 
        super(message, cause); 
    }

    /**
     *
     * @param cause
     */
    public ConfiguratorException(Throwable cause) { 
        super(cause); 
    }
}

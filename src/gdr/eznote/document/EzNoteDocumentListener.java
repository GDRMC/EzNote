package gdr.eznote.document;

import gdr.eznote.EzNoteFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Document Listener class
 * @author GDRMc
 */
public class EzNoteDocumentListener implements DocumentListener{
    
    private int changeCounter;
    private boolean changeIndicator;
    private EzNoteFrame parent;
    
    /**
     * Constructor
     * @param parent parent frame
     */
    public EzNoteDocumentListener(EzNoteFrame parent){
        super();
        this.changeCounter = 0;
        this.changeIndicator = false;
        this.parent = parent;
        notifyEvent("loaded");
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        this.changeIndicator = true;
        this.changeCounter++;
        notifyEvent("event insert");
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        this.changeIndicator = true;
        this.changeCounter++;
        notifyEvent("event remove");
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        this.changeIndicator = true;
        this.changeCounter++;
        notifyEvent("event change");
    }
    
    /**
     * Prints a string to the console (debug)
     * Deprecated, this will be removed in some releases
     * @param str
     */
    @Deprecated
    public void notifyEvent(String str){
        System.out.println("EzFrameDL dc > "+str);
    }
    
    public void debugChange(){
        System.out.println("EzFrameDL ch > "+this.getChangeIndicator()+" - "+this.getChangeCounter());
    }

    /**
     * Returns the change counter of the document
     * @return int counter change
     */
    public int getChangeCounter() {
        return changeCounter;
    }

    /**
     * Returns the change indicator of the document
     * @return boolean change indicator
     */
    public boolean getChangeIndicator() {
        return changeIndicator;
    }
    
    /**
     * Returns if the file has been changed or not
     * @return boolean file changed ?
     */
    public boolean isFileChanged(){
        return this.getChangeIndicator()==true && this.getChangeCounter()>0;
    }

    /**
     * Returns the parent window of the listener
     * @return parent window
     */
    public EzNoteFrame getParent() {
        return parent;
    }

    /**
     * Set the change counter of the document
     * Deprecated: will be replaced by resetChange, this is for
     * debug only
     * @param changeCounter
     */
    @Deprecated
    public void setChangeCounter(int changeCounter) {
        this.changeCounter = changeCounter;
    }

    /**
     * Set the change indicator
     * Deprecated: will be replaced by resetChange, this is for
     * debug only
     * @param changeIndicator
     */
    @Deprecated
    public void setChangeIndicator(boolean changeIndicator) {
        this.changeIndicator = changeIndicator;
    }
    
    /**
     * Resets the changes censors of the document
     */
    public void resetIndicators(){
        this.changeIndicator = false;
        this.changeCounter = 0;
    }
    
}

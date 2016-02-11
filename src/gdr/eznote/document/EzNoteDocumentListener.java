package gdr.eznote.document;

import gdr.eznote.EzNoteFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EzNoteDocumentListener implements DocumentListener{
    
    private int changeCounter;
    private boolean changeIndicator;
    private EzNoteFrame parent;
    
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
    
    public void notifyEvent(String str){
        System.out.println("EzFrameDL dc > "+str);
    }

    public int getChangeCounter() {
        return changeCounter;
    }

    public boolean getChangeIndicator() {
        return changeIndicator;
    }

    public EzNoteFrame getParent() {
        return parent;
    }

    public void setChangeCounter(int changeCounter) {
        this.changeCounter = changeCounter;
    }

    public void setChangeIndicator(boolean changeIndicator) {
        this.changeIndicator = changeIndicator;
    }
    
    
}

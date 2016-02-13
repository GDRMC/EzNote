package gdr.eznote.util;

import gdr.eznote.*;

public class EzNoteFrameUtil {

    private EzNoteFrame p;

    public EzNoteFrameUtil(EzNoteFrame parent) {
        this.p = parent;
    }

    public String getWindowTitle(boolean fileLoaded, String filename) {
        if (!filename.isEmpty()) {
            if (fileLoaded) {
                return "*"
                        + "<"+filename+">"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
            } else {
                return "<"+filename+">"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
            }
        } else {
            return "<Untitled>"
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.SOFTWARE_NAME
                        + " "
                        + EzNoteTexts.SOFTWARE_VERSION
                        + EzNoteTexts.TITLE_SEPARATOR
                        + EzNoteTexts.TITLE_TEXT1;
        }
        
    }
    
}

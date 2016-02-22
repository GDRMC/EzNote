package gdr.eznote.document;

import gdr.eznote.EzNoteFrame;
import gdr.eznote.exceptions.BadValidationException;
import java.io.FileNotFoundException;

public class EzNoteChangeValidator {
    
    public static final int FILE_OPEN = 0;
    public static final int FILE_QSAVE = 1;
    public static final int FILE_SAVEAS = 2;
    
    public static boolean validateAction(EzNoteDocument parent, int action) throws BadValidationException, FileNotFoundException{
        boolean ok = false;
        if(parent.getChangeIndicator() == true){
            ok = parent.saveQ();
        } 
        if(ok){
            if(action == FILE_OPEN){
                ok = parent.open();
            } else if(action == FILE_QSAVE){
                ok = parent.saveQ();
            } else if(action == FILE_SAVEAS){
                ok = parent.saveAs();
            } else {
                throw new BadValidationException(action+" is not defined as a file action");
            }
        }
        return ok;
    }
    
}

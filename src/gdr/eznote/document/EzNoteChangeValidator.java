package gdr.eznote.document;

import gdr.eznote.exceptions.BadValidationException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author GDR
 */
public class EzNoteChangeValidator {

    /**
     *
     */
    public static final int FILE_OPEN = 0;

    /**
     *
     */
    public static final int FILE_QSAVE = 1;

    /**
     *
     */
    public static final int FILE_SAVEAS = 2;

    /**
     *
     */
    public static final int FILE_NEW = 3;

    /**
     *
     * @param parent
     * @param action
     * @return
     * @throws BadValidationException
     * @throws FileNotFoundException
     */
    public static boolean validateAction(EzNoteDocument parent, int action) throws BadValidationException, FileNotFoundException {
        boolean ok = false;
        boolean execute = true;
        if (parent.getChangeIndicator() == true && action != FILE_SAVEAS && action != FILE_QSAVE) {
            int state = JOptionPane.showOptionDialog(null,
                    "You have unsaved changes, do you want to save them ?",
                    "Before you go further !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);
            if (state == JOptionPane.CANCEL_OPTION) {
                execute = false;
            } else if (state == JOptionPane.NO_OPTION) {
                ok = true;
            } else if (state == JOptionPane.YES_OPTION){
                ok = parent.saveQ();
            }
        } else {
            ok = true;
        }
        if (ok && execute) {
            switch (action) {
                case FILE_OPEN:
                    parent.getParent().getFileChooser().setDialogTitle("Open...");
                    ok = parent.open();
                    break;
                case FILE_QSAVE:
                    parent.getParent().getFileChooser().setDialogTitle("Save...");
                    ok = parent.saveQ();
                    break;
                case FILE_SAVEAS:
                    parent.getParent().getFileChooser().setDialogTitle("Save...");
                    ok = parent.saveAs();
                    break;
                case FILE_NEW:
                    ok = true;
                    break;
                default:
                    throw new BadValidationException(action + " is not defined as a file action");
            }
        }
        return ok;
    }

}

package gdr.eznote.document;

import gdr.eznote.exceptions.BadValidationException;
import gdr.eznote.exceptions.FileSelectionException;
import gdr.eznote.util.EzNoteFrameUtil;
import java.io.File;
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
    public static boolean validateAction(EzNoteTXT parent, int action) throws BadValidationException, FileNotFoundException, FileSelectionException {
        boolean ok = false;
        boolean execute = true;
        if (parent.changes > 0 && action != FILE_SAVEAS && action != FILE_QSAVE) {
            int state = JOptionPane.showOptionDialog(null,
                    "You have unsaved changes, do you want to save them ?",
                    "Before you go further !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, null, null);
            switch (state) {
                case JOptionPane.CANCEL_OPTION:
                    execute = false;
                    break;
                case JOptionPane.NO_OPTION:
                    ok = true;
                    break;
                case JOptionPane.YES_OPTION:
                    ok = parent.save();
                    break;
                default:
                    break;
            }
        } else {
            ok = true;
        }
        if (ok && execute) {
            switch (action) {
                case FILE_OPEN:
                    parent.getFrame().getFileChooser().setDialogTitle("Open...");
                    ok = parent.open();
                    break;
                case FILE_QSAVE:
                    parent.getFrame().getFileChooser().setDialogTitle("Save...");
                    ok = parent.save();
                    break;
                case FILE_SAVEAS:
                    parent.getFrame().getFileChooser().setDialogTitle("Save...");
                    ok = parent.saveAs();
                    break;
                case FILE_NEW:
                    parent.getFrame().getEditor().setText("");
                    parent.getFrame().setTitle(parent.getFrame().getUtilities().getWindowTitle(false, "Untitled"));
                    parent.getFrame().setDocument(new File("temp/tmp.txt"));
                    parent.getFrame().document.updateWindowTitle();
                    ok = true;
                    break;
                default:
                    throw new BadValidationException(action + " is not defined as a file action");
            }
        }
        return ok;
    }

}

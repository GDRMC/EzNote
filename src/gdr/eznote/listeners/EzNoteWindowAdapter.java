package gdr.eznote.listeners;

import gdr.eznote.exceptions.FileSelectionException;
import gdr.eznote.frames.EzNoteFrame;
import gdr.eznote.exceptions.OptionPaneValueOutOfBoundsException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Main frame event listener
 * @author GDR
 */
public class EzNoteWindowAdapter extends WindowAdapter{

    private EzNoteFrame parent;
    
    /**
     * Constructor with parent to listen
     * @param parent EzNoteFrame
     */
    public EzNoteWindowAdapter(EzNoteFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(this.parent.getDocument().changes > 0){
            try {
                int quitstate = JOptionPane.showConfirmDialog(parent, "It appears you have unsaved changes. Do you want to save them ?", "Oh !", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (quitstate) {
                    case JOptionPane.YES_OPTION:
                        boolean state = parent.getDocument().save();
                        System.out.println("Exit QSave: "+state);
                        System.exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                    default:
                        throw new OptionPaneValueOutOfBoundsException("Exit JOptionPane return value out of bounds");
                }
            } catch (OptionPaneValueOutOfBoundsException ex) {
                ex.printStackTrace();
                System.exit(1);
            } catch (FileSelectionException ex) {
                Logger.getLogger(EzNoteWindowAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(this.parent.getSize());
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}

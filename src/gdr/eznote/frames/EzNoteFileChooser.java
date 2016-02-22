package gdr.eznote.frames;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Custom FileChooser window
 * @author GDR
 */
public class EzNoteFileChooser extends JFileChooser {

    /**
     * Constructor using parent JFrame and name
     * @param parent parent JFrame
     * @param name name
     */
    public EzNoteFileChooser(JFrame parent, String name) {
        super(name);
        this.setVisible(true);
    }

    /**
     * Displays the open function of the filechooser
     * @param parent parent component
     */
    public void displayOpen(Component parent) {
        this.setDialogTitle("Open");
        this.showOpenDialog(parent);
    }

    /**
     * Displays the save function of the filechooser
     * @param parent parent component
     */
    public void displayClose(Component parent) {
        this.setDialogTitle("Save");
        this.showSaveDialog(parent);
    }
    
}

package gdr.eznote.frames;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class EzNoteFileChooser extends JFileChooser {

    public EzNoteFileChooser(JFrame parent, String name) {
        super(name);
        this.setVisible(true);
    }

    public void displayOpen(Component parent, int state) {
        this.setDialogTitle("Open");
        this.showOpenDialog(parent);
    }

    public void displayClose(Component parent) {
        this.setDialogTitle("Save");
        this.showSaveDialog(parent);
    }
    
}

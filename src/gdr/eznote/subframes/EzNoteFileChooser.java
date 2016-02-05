package gdr.eznote.subframes;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class EzNoteFileChooser extends JFileChooser {

    public EzNoteFileChooser(JFrame parent, String name) {
        super(name);
        this.setDialogTitle("Open/Close");
        this.setVisible(true);
    }

    public void displayOpen(Component c) {
        this.showOpenDialog(c);
    }

    public void displayClose(Component c) {
        this.showSaveDialog(c);
    }
}

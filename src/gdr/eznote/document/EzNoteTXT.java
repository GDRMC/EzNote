package gdr.eznote.document;

import gdr.eznote.exceptions.FileSelectionException;
import gdr.eznote.frames.EzNoteFileChooser;
import gdr.eznote.frames.EzNoteFrame;
import gdr.eznote.util.EzNoteFrameUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author GDR
 */
public class EzNoteTXT implements DocumentListener {

    private EzNoteFrameUtil util;
    private EzNoteFrame parent;
    private EzNoteFileChooser filechooser;

    private FileReader in;
    private FileWriter out;
    public File file;
    public File tmpFile = new File("temp/tmp.txt");

    //change counter of the file
    public int changes = 0;

    public EzNoteTXT(EzNoteFrame parent, File f) {
        this.util = new EzNoteFrameUtil(parent);
        this.parent = parent;
        this.filechooser = parent.getFileChooser();
        this.file = f;
        this.parent.setDocumentListener(this);
        updateWindowTitle();
    }

    public EzNoteFrame getFrame() {
        return parent;
    }

    public void newf() throws FileSelectionException {
        if (changes > 0) {
            this.save();
        }
        this.file = tmpFile;
        this.parent.getEditor().setText("");
        resetIndicator();
        parent.repaint();
    }

    public boolean open() throws FileSelectionException {
        boolean success = false;
        int state = filechooser.showOpenDialog(parent);
        switch (state) {
            case JFileChooser.APPROVE_OPTION:
                try {
                    this.in = new FileReader(filechooser.getSelectedFile());
                    this.parent.getEditor().setText(getTextFromStream(in));
                    in.close();
                    resetIndicator();
                    success = true;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Requested file cannot be opened (IOException)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("FILECHOOSER: OPEN CANCELLED BY USER");
                break;
            case JFileChooser.ERROR_OPTION:
                throw new FileSelectionException("Invalid return code");
        }
        parent.repaint();
        return success;
    }

    public boolean save() throws FileSelectionException {
        boolean success = false;
        try {
            if (this.file.getName().endsWith("tmp.txt")) {
                this.saveAs();
            } else {
                this.out = new FileWriter(EzNoteFrameUtil.getProperFileExtension(file));
                file.delete();
                file.createNewFile();
                out.append(parent.getEditor().getText());
                out.close();
                resetIndicator();
                success = true;
                JOptionPane.showMessageDialog(null, "Successfully quicksaved", "Quicksave", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Requested file has not been found while quicksaving (FileNotFoundException)", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Internal IO exception while quicksaving (IOException)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        parent.repaint();
        return success;
    }

    public boolean saveAs() throws FileSelectionException {
        boolean success = false;
        int overwrite = JOptionPane.CANCEL_OPTION;
        int state = filechooser.showSaveDialog(parent);
        switch (state) {
            case JFileChooser.APPROVE_OPTION:
                try {
                    if (this.filechooser.getSelectedFile().exists()) {
                        overwrite = JOptionPane.showConfirmDialog(null, "ecraser", "confirmer ?", JOptionPane.OK_CANCEL_OPTION);
                        switch (overwrite) {
                            case JOptionPane.OK_OPTION:
                                this.file = EzNoteFrameUtil.getProperFileExtension(filechooser.getSelectedFile());
                                this.out = new FileWriter(file);
                                file.delete();
                                file.createNewFile();
                                out.append(parent.getEditor().getText());
                                out.close();
                                resetIndicator();
                                success = true;
                                break;
                            case JOptionPane.CANCEL_OPTION:
                                System.out.println("FILECHOOSER: SAVEAS CANCELLED BY USER");
                                break;
                            default:
                                throw new FileSelectionException("Invalid return code");
                        }
                        //TODO
                    } else {
                        this.file = EzNoteFrameUtil.getProperFileExtension(filechooser.getSelectedFile());
                        this.out = new FileWriter(file);
                        file.delete();
                        file.createNewFile();
                        out.append(parent.getEditor().getText());
                        out.close();
                        resetIndicator();
                        success = true;
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Requested file has not been found while saving (FileNotFoundException)", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Internal IO exception while quicksaving (IOException)", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("FILECHOOSER: SAVEAS CANCELLED BY USER");
                break;
            case JFileChooser.ERROR_OPTION:
                throw new FileSelectionException("An error occured while selecting file");
            default:
                throw new FileSelectionException("Invalid return code");
        }
        if (!success) {
            JOptionPane.showMessageDialog(null, "Save cancelled by user", "Save", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Successfully saved" + this.file.getAbsolutePath(), "Save", JOptionPane.INFORMATION_MESSAGE);
        }
        parent.repaint();
        return success;
    }

    public static String getTextFromStream(FileReader in) {
        Scanner s = new java.util.Scanner(in).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.changes++;
        updateWindowTitle();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.changes++;
        updateWindowTitle();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.changes++;
        updateWindowTitle();
    }

    public void updateWindowTitle() {
        if (changes > 0) {
            if (this.file.getName().endsWith("tmp.txt")) {
                this.parent.setTitle(this.parent.getUtilities().getWindowTitle(true, "untitled"));
                this.parent.enableSaveButtons();
            } else {
                this.parent.setTitle(this.parent.getUtilities().getWindowTitle(true, this.file.getName()));
                this.parent.enableSaveButtons();
            }
            //INSERT HERE DISPLAY CODES
            this.parent.jLabel6.setText("" + changes);
        } else if (this.file.getName().endsWith("tmp.txt")) {
            this.parent.setTitle(this.parent.getUtilities().getWindowTitle(false, "untitled"));
            this.parent.disableSaveButtons();
        } else {
            this.parent.setTitle(this.parent.getUtilities().getWindowTitle(false, this.file.getName()));
            this.parent.disableSaveButtons();
        }
    }

    private void resetIndicator() {
        this.changes = 0;
        this.parent.jLabel6.setText("" + 0);
        updateWindowTitle();
    }
}

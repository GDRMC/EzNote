package gdr.eznote.document;

import gdr.eznote.EzNoteFrame;
import gdr.eznote.frames.*;
import gdr.eznote.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EzNoteDocument implements DocumentListener {

    private EzNoteFrameUtil util;
    private EzNoteFrame parent;
    
    private int changeCounter;
    private boolean changeIndicator;
    private boolean fresh;

    private File file;
    private String filename;
    
    private Scanner openScanner;

    public EzNoteDocument(EzNoteFrame parent) {
        this.util = new EzNoteFrameUtil(parent);
        parent.setDocumentListener(this);
        this.parent = parent;
        this.fresh = true;
    }

    public EzNoteFrameUtil getUtilities() {
        return this.util;
    }

    public File getFile() {
        return this.file;
    }
    
    public String getFilename() {
        return this.filename;
    }

    public boolean open() throws FileNotFoundException {
        //process booleans
        boolean complete = false;
        boolean empty;
        //filechooser filter update
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.parent.getFileChooser().setFileFilter(filter);
        //filechooser display with state getter
        int state = this.parent.getFileChooser().showSaveDialog(parent);
        //if the file has been successfully selected by the user within the GUI
        if (state == JFileChooser.APPROVE_OPTION) {
            //detect if the file is empty or not
            try {
                openScanner = new Scanner(this.parent.getFileChooser().getSelectedFile());
                openScanner.useDelimiter("\\Z").next();
                empty = false;
            } catch (NoSuchElementException e) {
                System.out.println("Selected file is empty");
                empty = true;
            }
            //get the selected file and change the current editing file in the class
            this.file = this.parent.getFileChooser().getSelectedFile();
            this.filename = this.parent.getFileChooser().getSelectedFile().getName();
            this.parent.setTitle(util.getWindowTitle(true, this.file.getName()));
            //if the file is not empty, load the content in the editor
            if(!empty){
                Scanner openScannerLoad = new Scanner(this.file).useDelimiter("\\Z");
                this.parent.getEditor().setText(openScannerLoad.next());
                complete = true;
                this.resetIndicators();
            } else {
                this.parent.getEditor().setText("");
                complete = true;
                this.resetIndicators();
            }
        //if the user closed the window without selecting any file, or cancelled the operation
        } else {
            System.out.println("Unable to load file");
            complete = false;
        }
        this.debugChange();
        this.openScanner.close();
        if(complete){
            //reset changes indicator if the file has been successfully loaded
            this.resetIndicators();
        }
        return complete;
    }

    public boolean saveQ() {
        boolean saved = false;
        PrintWriter writer;
        if (this.isFileChanged()) {
            if (this.filename == null){
                if(this.file.exists()){
                    try {
                        writer = new PrintWriter(file);
                        writer.print(this.parent.getEditor().getText());
                        writer.close();
                        JOptionPane.showMessageDialog(null, "File quick-saved !", "Save", JOptionPane.INFORMATION_MESSAGE);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Unable to quick-save, the file writer cannot find the file", "Save", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    boolean operation = this.saveAs();
                    if (operation) {
                        saved = true;
                    }
                }
            } else {
                //if the file is untitled and not saved
                boolean operation = this.saveAs();
                if (operation) {
                    saved = true;
                }
            }
        }
        this.debugChange();
        if(saved){
            this.resetIndicators();
        }
        return saved;
    }

    public boolean saveAs() {
        boolean complete = false;
        int state = this.parent.getFileChooser().showSaveDialog(parent);
        if (state == JFileChooser.APPROVE_OPTION) {
            file = this.parent.getFileChooser().getSelectedFile();
            EzNoteFrameUtil.debugFile(file);
            file = new File(EzNoteFrameUtil.getProperFileExtension(file.getAbsolutePath()));
            String path = file.getAbsolutePath();
            String filename = this.parent.getFileChooser().getName();
            //System.out.println(path + "\n" + filename);
            PrintWriter writer;
            if (!file.exists() && file != null) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    System.out.println("Impossible de créer le fichier !");
                }
                try {
                    writer = new PrintWriter(file);
                    writer.print(this.parent.getEditor().getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null, "File saved !", "Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Unable to save, the file writer cannot find the file", "Save", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "The file you are trying to save already exists, would you like to overwrite it ?", "Save", JOptionPane.WARNING_MESSAGE);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    try {
                        writer = new PrintWriter(file);
                        writer.print(this.parent.getEditor().getText());
                        writer.close();
                        complete = true;
                        JOptionPane.showMessageDialog(null, "File saved !", "Save", JOptionPane.INFORMATION_MESSAGE);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Unable to erase and save, the file writer cannot find the file", "Save", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Save cancelled", "Save", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            System.out.println("JFileChooser closed");
        }
        this.debugChange();
        return complete;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        this.fireUpdateEvent();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        this.fireUpdateEvent();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        this.fireUpdateEvent();
    }
    
    private void fireUpdateEvent(){
        this.changeIndicator = true;
        this.changeCounter++;
        this.updateTitle();
        this.parent.enableSaveButtons();
    }

    public void debugChange() {
        System.out.println("EzFrameDL ch > " + this.getChangeIndicator() + " - " + this.getChangeCounter());
    }

    public void updateTitle() {
        if (this.file != null) {
            this.parent.setTitle(this.parent.getUtilities().getWindowTitle(true, this.filename));
        } else {
            this.parent.setTitle(this.parent.getUtilities().getWindowTitle(true, "Untitled"));
        }
    }

    /**
     * Returns the change counter of the document
     *
     * @return int counter change
     */
    public int getChangeCounter() {
        return changeCounter;
    }

    /**
     * Returns the change indicator of the document
     *
     * @return boolean change indicator
     */
    public boolean getChangeIndicator() {
        return changeIndicator;
    }

    /**
     * Returns if the file has been changed or not
     *
     * @return boolean file changed ?
     */
    public boolean isFileChanged() {
        return this.getChangeIndicator() == true && this.getChangeCounter() > 0;
    }

    /**
     * Returns the parent window of the listener
     *
     * @return parent window
     */
    public EzNoteFrame getParent() {
        return parent;
    }

    /**
     * Resets the changes censors of the document
     */
    public void resetIndicators() {
        this.changeIndicator = false;
        this.changeCounter = 0;
        if(this.parent.getTitle().charAt(0) == '*'){
            this.parent.setTitle(this.parent.getTitle().substring(1));
        }
        if(this.parent.getTitle().contains("<-1>")){
            this.parent.getUtilities().getWindowTitle(false, "Untitled");
        }
        this.parent.disableSaveButtons();
        System.out.println("EzFrameDL ch > reset " + this.getChangeIndicator() + " - " + this.getChangeCounter());
    }

}

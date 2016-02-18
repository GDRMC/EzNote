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

    private File file;
    private String filename;
    
    private Scanner openScanner;

    public EzNoteDocument(EzNoteFrame parent) {
        //init frame utilities for this document to handler display of some things
        this.util = new EzNoteFrameUtil(parent);
        //sets the documentlistener of the frame handled automatically
        parent.setDocumentListener(this);
        this.parent = parent;
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
    
    public void disableSaveButtons(){
        //TODO
    }
    
    public void enableSaveButtons(){
        //TODO
    }

    public boolean open(File f, EzNoteFileChooser fc, int state) throws FileNotFoundException {
        boolean complete = false;
        boolean empty;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.parent.getFileChooser().setFileFilter(filter);
        this.openScanner = new Scanner(f);
        if (state == JFileChooser.APPROVE_OPTION) {
            try {
                this.parent.getEditor().setText(openScanner.useDelimiter("\\Z").next());
                empty = false;
            } catch (NoSuchElementException e) {
                System.out.println("Selected file is empty");
                empty = true;
            }
            this.file = this.parent.getFileChooser().getSelectedFile();
            this.filename = this.parent.getFileChooser().getSelectedFile().getName();
            this.parent.setTitle(util.getWindowTitle(true, this.file.getName()));
            if(!empty){
                Scanner openScannerLoad = new Scanner(f).useDelimiter("\\Z");
                this.parent.getEditor().setText(openScannerLoad.next());
                complete = true;
                this.resetIndicators();
            } else {
                this.parent.getEditor().setText("");
                complete = true;
                this.resetIndicators();
            }
        } else {
            System.out.println("Unable to load file");
            complete = false;
        }
        this.debugChange();
        this.openScanner.close();
        return complete;
    }

    public boolean saveQ() {
        boolean saved = false;
        if (this.isFileChanged()) {
            boolean operation = this.saveAs();
            if (operation) {
                saved = true;
            }
        } else {
            //manual save
        }
        this.debugChange();
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

            //initialise le flux d'enregistrement
            //si le fichier n'existe pas
            if (!file.exists() && file != null) {
                //crée le fichier
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

                //sinon demande l'autorisation pour écraser
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "The file you are trying to save already exists, would you like to overwrite it ?", "Save", JOptionPane.WARNING_MESSAGE);
                //Demande l'autorisation à l'utilisateur pour écraser le fichier
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
        this.changeIndicator = true;
        this.changeCounter++;
        this.updateTitle();
        notifyEvent("event insert");
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        this.changeIndicator = true;
        this.changeCounter++;
        this.updateTitle();
        notifyEvent("event remove");
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        this.changeIndicator = true;
        this.changeCounter++;
        this.updateTitle();
        notifyEvent("event change");
    }

    /**
     * Prints a string to the console (debug) Deprecated, this will be removed
     * in some releases
     *
     * @param str
     */
    @Deprecated
    public void notifyEvent(String str) {
        System.out.println("EzFrameDL dc > " + str);
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
     * Set the change counter of the document Deprecated: will be replaced by
     * resetChange, this is for debug only
     *
     * @param changeCounter
     */
    @Deprecated
    public void setChangeCounter(int changeCounter) {
        this.changeCounter = changeCounter;
    }

    /**
     * Set the change indicator Deprecated: will be replaced by resetChange,
     * this is for debug only
     *
     * @param changeIndicator
     */
    @Deprecated
    public void setChangeIndicator(boolean changeIndicator) {
        this.changeIndicator = changeIndicator;
    }

    /**
     * Resets the changes censors of the document
     */
    public void resetIndicators() {
        this.changeIndicator = false;
        this.changeCounter = 0;
        if(this.parent.getTitle().charAt(0) == '*'){
            this.parent.setTitle(this.parent.getTitle().substring(0));
        }
        System.out.println("EzFrameDL ch > reset " + this.getChangeIndicator() + " - " + this.getChangeCounter());
    }

}

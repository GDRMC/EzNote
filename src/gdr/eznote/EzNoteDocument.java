package gdr.eznote;

import gdr.eznote.document.EzNoteDocumentListener;
import gdr.eznote.util.EzNoteFrameUtil;
import gdr.eznote.util.EzNoteUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EzNoteDocument {
    
    private EzNoteDocumentListener dc;
    private EzNoteFrameUtil util;
    private EzNoteFrame parent;
    
    private File file;
    
    public EzNoteDocument(EzNoteFrame parent){
        //init event listener for this document
        this.dc = new EzNoteDocumentListener(parent);
        //init frame utilities for this document to handler display of some things
        this.util = new EzNoteFrameUtil(parent);
        //sets the documentlistener of the frame handled automatically
        parent.setDocumentListener(dc);
        this.parent = parent;
    }
    
    public EzNoteDocumentListener getDocumentListener(){
        return this.dc;
    }
    
    public boolean open(){
        boolean complete = false;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.parent.getFileChooser().setFileFilter(filter);
        this.parent.getFileChooser().displayOpen(parent);
        File f = this.parent.getFileChooser().getSelectedFile();
        //TODO: NEED UTIL SUPPORT FOR MAIN WINDOW
        //this.setTitle(f.getName() + this.TITLE_SUFFIX);
        if (f.canRead()) {
            try {
                System.out.println(f.toString());
                this.parent.getEditor().setText("");
                try {
                    this.parent.getEditor().setText(new Scanner(f).useDelimiter("\\Z").next());
                    complete = true;
                } catch (NoSuchElementException e) {
                    System.out.println("Selected file is empty");
                }
            } catch (NullPointerException | IOException e) {
                System.out.println("No file selected");
            }
        } else {
            System.out.println("Unable to load file");
        }
        return complete;
    }
    
    public boolean saveAs(){
        this.filecontent = this.editor.getText();
        int state = this.fc.showSaveDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            file = this.fc.getSelectedFile();
            EzNoteUtil.debugFile(file);
            file = new File(EzNoteUtil.getProperFileExtension(file.getAbsolutePath()));
            String path = file.getAbsolutePath();
            String filename = this.fc.getName();
            System.out.println(path + "\n" + filename);
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
                    writer.print(this.filecontent);
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
                        writer.print(this.filecontent);
                        writer.close();
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
        
        
    }
}

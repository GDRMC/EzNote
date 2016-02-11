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

//ed
public class EzNoteDocument {
    
    private EzNoteDocumentListener dc;
    private EzNoteFrameUtil util;
    
    public EzNoteDocument(EzNoteFrame parent){
        //init event listener for this document
        this.dc = new EzNoteDocumentListener(parent);
        //init frame utilities for this document to handler display of some things
        this.util = new EzNoteFrameUtil(parent);
        //sets the documentlistener of the frame handled automatically
        parent.setDocumentListener(dc);
    }
    
    public EzNoteDocumentListener getDocumentListener(){
        return this.dc;
    }
    
    public boolean open(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.fc.setFileFilter(filter);
        this.fc.displayOpen(this);
        File f = this.fc.getSelectedFile();
        this.setTitle(f.getName() + this.TITLE_SUFFIX);
        if (f.canRead()) {
            try {
                System.out.println(f.toString());
                this.editor.setText("");
                try {
                    this.filecontent = new Scanner(f).useDelimiter("\\Z").next();
                    this.editor.setText(this.filecontent);
                } catch (NoSuchElementException e) {
                    System.out.println("Selected file is empty");
                }
            } catch (NullPointerException | IOException e) {
                System.out.println("No file selected");
            }
        } else {
            System.out.println("Unable to load file");
        }
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

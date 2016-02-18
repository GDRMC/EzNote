package gdr.eznote;

import gdr.eznote.document.EzNoteDocument;
import gdr.eznote.frames.EzNoteFileChooser;
import gdr.eznote.frames.EzNoteFrameAbout;
import gdr.eznote.util.EzNoteFrameUtil;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;

public class EzNoteFrame extends javax.swing.JFrame {
    
    private EzNoteFileChooser fc;
    private EzNoteFrameAbout fab;
    private EzNoteFrameUtil util;
    private EzNoteDocument doc;

    public EzNoteFrame() {
        initComponents();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.fc = new EzNoteFileChooser(this,"test");
        this.fc.setFileFilter(filter);
        this.fab = new EzNoteFrameAbout();
        this.fab.dispose();
        this.util = new EzNoteFrameUtil(this);
        this.doc = new EzNoteDocument(this);
    }
    
    public void setDocumentListener(EzNoteDocument dc){
        this.editor.getDocument().addDocumentListener(dc);
    }
    
    public EzNoteFrameUtil getUtilities(){
        return this.util;
    }
    
    public EzNoteFileChooser getFileChooser(){
        return this.fc;
    }
    
    public EzNoteDocument getDocument(){
        return this.doc;
    }
    
    public String getFilename(){
        return this.doc.getFile().getName();
    }

    public JTextArea getEditor(){
        return this.editor;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jFileChooser1 = new javax.swing.JFileChooser();
        jSeparator6 = new javax.swing.JSeparator();
        editorPane = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        toolNew = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        toolQSave = new javax.swing.JButton();
        toolSave = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        buttonNew = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        buttonOpen = new javax.swing.JMenuItem();
        buttonSave = new javax.swing.JMenuItem();
        buttonSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        buttonExit = new javax.swing.JMenuItem();
        menuSettings = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editor.setColumns(20);
        editor.setRows(5);
        editorPane.setViewportView(editor);

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(0, 0, 0));
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(1000000, 32));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jToolBar1, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), jToolBar1, org.jdesktop.beansbinding.BeanProperty.create("minimumSize"));
        bindingGroup.addBinding(binding);

        jSeparator3.setOrientation(javax.swing.SwingConstants.HORIZONTAL);
        jSeparator3.setToolTipText("");
        jToolBar1.add(jSeparator3);

        toolNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_newfile.png"))); // NOI18N
        toolNew.setAlignmentX(0.5F);
        toolNew.setBorder(null);
        toolNew.setFocusable(false);
        toolNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolNew.setMaximumSize(new java.awt.Dimension(28, 28));
        toolNew.setMinimumSize(new java.awt.Dimension(28, 28));
        toolNew.setPreferredSize(new java.awt.Dimension(28, 28));
        toolNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolNewActionPerformed(evt);
            }
        });
        jToolBar1.add(toolNew);
        jToolBar1.add(jSeparator5);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_openfile.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        toolQSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile.png"))); // NOI18N
        toolQSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile_disabled.png"))); // NOI18N
        toolQSave.setEnabled(false);
        toolQSave.setFocusable(false);
        toolQSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolQSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolQSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolQSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(toolQSave);

        toolSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_saveasfile.png"))); // NOI18N
        toolSave.setFocusable(false);
        toolSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(toolSave);
        jToolBar1.add(jSeparator4);

        menuFile.setText("File");

        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        menuFile.add(buttonNew);
        menuFile.add(jSeparator2);

        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });
        menuFile.add(buttonOpen);

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        menuFile.add(buttonSave);

        buttonSaveAs.setText("Save As...");
        buttonSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(buttonSaveAs);
        menuFile.add(jSeparator1);

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        menuFile.add(buttonExit);

        menuBar.add(menuFile);

        menuSettings.setText("Preferences");
        menuBar.add(menuSettings);

        menuAbout.setText("About");
        menuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAboutMouseClicked(evt);
            }
        });
        menuBar.add(menuAbout);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editorPane, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editorPane, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveAsActionPerformed
        this.saveAsFile();
    }//GEN-LAST:event_buttonSaveAsActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        this.openFile();
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        this.newFile();
    }//GEN-LAST:event_buttonNewActionPerformed

    private void menuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseClicked
        this.fab.setVisible(true);
    }//GEN-LAST:event_menuAboutMouseClicked

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        this.saveFile();
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void toolNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolNewActionPerformed
        this.newFile();
    }//GEN-LAST:event_toolNewActionPerformed

    private void toolQSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolQSaveActionPerformed
        this.saveAsFile();
    }//GEN-LAST:event_toolQSaveActionPerformed

    private void toolSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSaveActionPerformed
        this.saveFile();
    }//GEN-LAST:event_toolSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.openFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void initializeStartup(){
        this.newFile();
    }
    
    ////ACTIONS
    private void newFile(){
        this.editor.setText("");
        this.setTitle(this.util.getWindowTitle(false, "Untitled"));
        this.doc.resetIndicators();
    }
    
    private void openFile(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.getFileChooser().setFileFilter(filter);
        int state = this.getFileChooser().showOpenDialog(this);
        if(this.getFileChooser().getSelectedFile().exists() && this.getFileChooser().getSelectedFile().isFile()){
            try {
                this.doc.open(this.getFileChooser().getSelectedFile(), this.getFileChooser(), state);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EzNoteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setTitle(this.util.getWindowTitle(false, this.doc.getFilename()));
        }
    }
    
    private void saveFile(){
        this.doc.saveQ();
        this.doc.resetIndicators();
    }
    
    private void saveAsFile(){
        this.doc.saveAs();
        this.doc.resetIndicators();
        this.util.getWindowTitle(true, this.getDocument().getFile().getName());
    }
    //////
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buttonExit;
    private javax.swing.JMenuItem buttonNew;
    private javax.swing.JMenuItem buttonOpen;
    private javax.swing.JMenuItem buttonSave;
    private javax.swing.JMenuItem buttonSaveAs;
    private javax.swing.JTextArea editor;
    private javax.swing.JScrollPane editorPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JButton toolNew;
    private javax.swing.JButton toolQSave;
    private javax.swing.JButton toolSave;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

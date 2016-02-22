package gdr.eznote;

import gdr.eznote.document.EzNoteChangeValidator;
import gdr.eznote.document.EzNoteDocument;
import gdr.eznote.exceptions.BadValidationException;
import gdr.eznote.frames.EzNoteFileChooser;
import gdr.eznote.frames.EzNoteFrameAbout;
import gdr.eznote.util.EzNoteFrameUtil;
import gdr.eznote.util.EzNoteWindowAdapter;
import java.awt.Color;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;

/**
 * Main Editor frame
 * @author GDR
 */
public class EzNoteFrame extends javax.swing.JFrame {

    private EzNoteFileChooser fc;
    private EzNoteFrameAbout fab;
    private EzNoteFrameUtil util;
    private EzNoteDocument doc;
    private EzNoteWindowAdapter wlis;

    /**
     * Constructor and manual components init
     */
    public EzNoteFrame() {
        initComponents();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        this.fc = new EzNoteFileChooser(this, "test");
        this.fc.setFileFilter(filter);
        this.fab = new EzNoteFrameAbout();
        this.fab.dispose();
        this.util = new EzNoteFrameUtil(this);
        this.doc = new EzNoteDocument(this);
        this.wlis = new EzNoteWindowAdapter(this);
        this.addWindowListener(wlis);
        this.themeApplyToolbar(Color.lightGray);
    }

    /**
     * Set the document listener of the window
     * @param dc EzNoteDocumentListener
     */
    
    public void setDocumentListener(EzNoteDocument dc) {
        this.editor.getDocument().addDocumentListener(dc);
    }

    /**
     * Returns the frame utilities class
     * @return EzNoteFrameUtil
     */
    public EzNoteFrameUtil getUtilities() {
        return this.util;
    }

    /**
     * Returns the filechooser of the window
     * @return EzNoteFileChooser
     */
    public EzNoteFileChooser getFileChooser() {
        return this.fc;
    }

    /**
     * Returns the document of the window
     * @return EzNoteDocument
     */
    public EzNoteDocument getDocument() {
        return this.doc;
    }

    /**
     * Returns the filename of the current document
     * @return String filename of the current document
     */
    public String getFilename() {
        return this.doc.getFile().getName();
    }

    /**
     * Returns the Editor component
     * @return JTextArea of the main frame
     */
    public JTextArea getEditor() {
        return this.editor;
    }

    public void themeApplyToolbar(Color background){
        this.jToolBar1.setBackground(background);
        this.toolNew.setBackground(background);
        this.toolQSave.setBackground(background);
        this.toolSaveAs.setBackground(background);
        this.toolOpen.setBackground(background);
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
        editorPane = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        toolNew = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        toolOpen = new javax.swing.JButton();
        toolQSave = new javax.swing.JButton();
        toolSaveAs = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        buttonNew = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        buttonOpen = new javax.swing.JMenuItem();
        buttonQSave = new javax.swing.JMenuItem();
        buttonSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        buttonExit = new javax.swing.JMenuItem();
        menuSettings = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 300));

        editor.setColumns(20);
        editor.setRows(5);
        editorPane.setViewportView(editor);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(0, 0, 0));
        jToolBar1.setBorderPainted(false);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.setMaximumSize(new java.awt.Dimension(1000000, 32));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jToolBar1, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), jToolBar1, org.jdesktop.beansbinding.BeanProperty.create("minimumSize"));
        bindingGroup.addBinding(binding);

        jSeparator3.setToolTipText("");
        jToolBar1.add(jSeparator3);

        toolNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_newfile.png"))); // NOI18N
        toolNew.setToolTipText("New File");
        toolNew.setAlignmentX(0.5F);
        toolNew.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        toolNew.setFocusable(false);
        toolNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolNew.setMaximumSize(new java.awt.Dimension(28, 28));
        toolNew.setMinimumSize(new java.awt.Dimension(28, 28));
        toolNew.setPreferredSize(new java.awt.Dimension(28, 28));
        toolNew.setRolloverEnabled(true);
        toolNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolNewActionPerformed(evt);
            }
        });
        jToolBar1.add(toolNew);
        jToolBar1.add(jSeparator5);

        toolOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_openfile.png"))); // NOI18N
        toolOpen.setToolTipText("Open File");
        toolOpen.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        toolOpen.setBorderPainted(false);
        toolOpen.setFocusable(false);
        toolOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolOpen.setMaximumSize(new java.awt.Dimension(28, 28));
        toolOpen.setMinimumSize(new java.awt.Dimension(28, 28));
        toolOpen.setPreferredSize(new java.awt.Dimension(28, 28));
        toolOpen.setRolloverEnabled(true);
        toolOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(toolOpen);

        toolQSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile.png"))); // NOI18N
        toolQSave.setToolTipText("Quicksave current file");
        toolQSave.setAlignmentX(0.5F);
        toolQSave.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        toolQSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile_disabled.png"))); // NOI18N
        toolQSave.setEnabled(false);
        toolQSave.setFocusable(false);
        toolQSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolQSave.setMaximumSize(new java.awt.Dimension(28, 28));
        toolQSave.setMinimumSize(new java.awt.Dimension(28, 28));
        toolQSave.setPreferredSize(new java.awt.Dimension(28, 28));
        toolQSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolQSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolQSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(toolQSave);

        toolSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_saveasfile.png"))); // NOI18N
        toolSaveAs.setToolTipText("Save file as...");
        toolSaveAs.setAlignmentX(0.5F);
        toolSaveAs.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        toolSaveAs.setFocusable(false);
        toolSaveAs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toolSaveAs.setMaximumSize(new java.awt.Dimension(28, 28));
        toolSaveAs.setMinimumSize(new java.awt.Dimension(28, 28));
        toolSaveAs.setPreferredSize(new java.awt.Dimension(28, 28));
        toolSaveAs.setRolloverEnabled(true);
        toolSaveAs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSaveAsActionPerformed(evt);
            }
        });
        jToolBar1.add(toolSaveAs);
        jToolBar1.add(jSeparator4);

        menuFile.setText("File");

        buttonNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        buttonNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_newfile.png"))); // NOI18N
        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });
        menuFile.add(buttonNew);
        menuFile.add(jSeparator2);

        buttonOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        buttonOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_openfile.png"))); // NOI18N
        buttonOpen.setText("Open");
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });
        menuFile.add(buttonOpen);

        buttonQSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        buttonQSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile.png"))); // NOI18N
        buttonQSave.setText("Save");
        buttonQSave.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_savefile_disabled.png"))); // NOI18N
        buttonQSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQSaveActionPerformed(evt);
            }
        });
        menuFile.add(buttonQSave);

        buttonSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_saveasfile.png"))); // NOI18N
        buttonSaveAs.setText("Save As...");
        buttonSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(buttonSaveAs);
        menuFile.add(jSeparator1);

        buttonExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        buttonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gdr/icons/m_exit.png"))); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        menuFile.add(buttonExit);

        menuBar.add(menuFile);

        menuSettings.setText("Preferences");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Appearance");
        menuSettings.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Settings");
        menuSettings.add(jMenuItem2);

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
                .addGap(0, 0, 0)
                .addComponent(editorPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveAsActionPerformed
        try {
            EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_SAVEAS);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonSaveAsActionPerformed

    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        try {
            EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_OPEN);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonOpenActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        boolean isValid = false;
        try {
            isValid = EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_NEW);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (isValid) {
            this.newFile();
        }
    }//GEN-LAST:event_buttonNewActionPerformed

    private void menuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseClicked
        this.fab.setVisible(true);
    }//GEN-LAST:event_menuAboutMouseClicked

    private void buttonQSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQSaveActionPerformed
        try {
            EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_QSAVE);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        this.saveFile();
    }//GEN-LAST:event_buttonQSaveActionPerformed

    private void toolNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolNewActionPerformed
        boolean isValid = false;
        try {
            isValid = EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_NEW);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (isValid) {
            this.newFile();
        }
    }//GEN-LAST:event_toolNewActionPerformed

    private void toolQSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolQSaveActionPerformed
        try {
            EzNoteChangeValidator.validateAction(doc, EzNoteChangeValidator.FILE_QSAVE);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_toolQSaveActionPerformed

    private void toolSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSaveAsActionPerformed
        try {
            EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_SAVEAS);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_toolSaveAsActionPerformed

    private void toolOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolOpenActionPerformed
        try {
            EzNoteChangeValidator.validateAction(this.doc, EzNoteChangeValidator.FILE_OPEN);
        } catch (BadValidationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_toolOpenActionPerformed

    /**
     * Initialize a new file while the program is starting, and locks the quick
     * save buttons
     */
    public void initializeStartup() {
        this.newFile();
        this.disableSaveButtons();
    }

    /**
     * Enables save buttons
     * @deprecated Will not support disabled buttons anymore
     */
    @Deprecated
    public void enableSaveButtons() {
        this.buttonQSave.setEnabled(true);
        this.toolQSave.setEnabled(true);
    }

    /**
     * Disables save buttons
     * @deprecated Will not support disabled buttons anymore
     */
    @Deprecated
    public void disableSaveButtons() {
        this.buttonQSave.setEnabled(false);
        this.toolQSave.setEnabled(false);
    }

    ////ACTIONS
    private void newFile() {
        this.editor.setText("");
        this.setTitle(this.util.getWindowTitle(false, "Untitled"));
        this.doc.resetIndicators();
    }

    private void openFile() throws FileNotFoundException {
        this.doc.open();
    }

    private void saveFile() {
        this.doc.saveQ();
    }

    private void saveAsFile() {
        this.doc.saveAs();

    }
    //////


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buttonExit;
    private javax.swing.JMenuItem buttonNew;
    private javax.swing.JMenuItem buttonOpen;
    private javax.swing.JMenuItem buttonQSave;
    private javax.swing.JMenuItem buttonSaveAs;
    private javax.swing.JTextArea editor;
    private javax.swing.JScrollPane editorPane;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JButton toolNew;
    private javax.swing.JButton toolOpen;
    private javax.swing.JButton toolQSave;
    private javax.swing.JButton toolSaveAs;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}

package gdr.eznote.frames;

import gdr.eznote.components.EzNoteComboBoxColorPicker;
import javax.swing.ListCellRenderer;
import gdr.eznote.components.EzNoteComboBoxColorChRenderer;
import gdr.eznote.components.EzNoteComboBoxThemeChRenderer;
import gdr.eznote.components.EzNoteComboBoxThemePicker;
import gdr.eznote.exceptions.ConfiguratorException;
import gdr.eznote.themes.EzNoteColor;
import gdr.eznote.themes.EzNoteColorCollection;
import gdr.eznote.themes.EzNoteTheme;
import gdr.eznote.themes.EzNoteThemeManager;

/**
 *
 * @author GDR
 */
public class EzNoteFrameSettings extends javax.swing.JFrame {
    
    private EzNoteFrame parent;
    private ListCellRenderer property1 = new EzNoteComboBoxColorChRenderer();
    private ListCellRenderer property2 = new EzNoteComboBoxColorChRenderer();
    private ListCellRenderer property3 = new EzNoteComboBoxColorChRenderer();
    private ListCellRenderer thproper1 = new EzNoteComboBoxThemeChRenderer();
    
    private final EzNoteThemeManager themeManager;
    
    private boolean changelocked;
    
    
    /**
     * Creates new form EzNoteFrameAppearance
     */
    public EzNoteFrameSettings(EzNoteFrame parent) {
        this.themeManager = EzNoteThemeManager.workstation;
        this.themeManager.link(this);
        this.parent = parent;
        initComponents();
        this.setAlwaysOnTop(true);
        //deactivates custom pickers
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
        this.jComboBox1.setSelectedIndex(3);
        this.jComboBox2.setSelectedIndex(0);
        this.jComboBox3.setSelectedIndex(2);
        this.changelocked = true;
    }
    
    public void changeThemeLockState(int i){
        if(i==0){
            //deactivate manual chooser group
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
            this.jComboBox3.setEnabled(false);
            //activate the automatic themes group
            this.jComboBox4.setEnabled(true);
        } else {
            //the exact opposite
            this.jComboBox1.setEnabled(true);
            this.jComboBox2.setEnabled(true);
            this.jComboBox3.setEnabled(true);
            this.jComboBox4.setEnabled(false);
        }
        if(getThemeLockState()){
            changelocked = false;
            this.jComboBox4.setSelectedIndex(0);
        } else {
            changelocked = true;
            this.jComboBox1.setSelectedIndex(3);
            this.jComboBox2.setSelectedIndex(0);
            this.jComboBox3.setSelectedIndex(3);
        }
    }
    
    public EzNoteFrame getMainFrame(){
        return this.parent;
    }
    
    public EzNoteThemeManager getThemeManager(){
        return this.themeManager;
    }
    
    public boolean getThemeLockState(){
        return this.changelocked;
    }
    
    public void resetLockState(){
        this.changelocked = true;
        this.jRadioButton1.setEnabled(changelocked);
    }
    
    public Integer[] getConfigurationArray(){
        return new Integer[] {
            (Integer)this.jComboBox1.getSelectedItem(),
            (Integer)this.jComboBox2.getSelectedItem(),
            (Integer)this.jComboBox3.getSelectedItem(),
            (Integer)this.jComboBox4.getSelectedItem(),
        };
    }
    
    public void applyNSave() throws ConfiguratorException{
        if(this.changelocked){
            this.parent.themeApply((EzNoteTheme)this.jComboBox4.getSelectedItem());
        } else {
            this.parent.themeApply(
                    new EzNoteTheme(
                            "",
                            (EzNoteColor)this.jComboBox1.getSelectedItem(),
                            (EzNoteColor)this.jComboBox2.getSelectedItem(),
                            (EzNoteColor)this.jComboBox3.getSelectedItem(),
                            EzNoteColorCollection.COLORS_CARET[0]
                    )
            );
        }
        this.setConfiguration();
        this.parent.getConfigurator().save();
    }
    
    public void setConfiguration(){
        if(this.jRadioButton1.isEnabled()){
            this.parent.getConfigurator().setConfigurationThemeMode(0);
        } else {
            this.parent.getConfigurator().setConfigurationThemeMode(1);
        }
        this.parent.getConfigurator().setConfigurationThemeChoose(this.jComboBox4.getSelectedIndex());
        this.parent.getConfigurator().setConfigurationThemeToolbarColor(this.jComboBox1.getSelectedIndex());
        this.parent.getConfigurator().setConfigurationThemeEditorColor(this.jComboBox2.getSelectedIndex());
        this.parent.getConfigurator().setConfigurationThemeFontColor(this.jComboBox3.getSelectedIndex());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        buttonConfirm = new javax.swing.JButton();
        buttonApply = new javax.swing.JButton();
        buttonDiscard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings - EzNote");
        setFocusCycleRoot(false);
        setLocationByPlatform(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new EzNoteComboBoxColorPicker(0));
        jComboBox1.setSelectedIndex(this.jComboBox1.getSelectedIndex());
        jComboBox1.setSelectedItem(this.jComboBox1.getSelectedItem());
        jComboBox1.setToolTipText("");
        jComboBox1.setName(this.jComboBox1.getSelectedItem().toString());
        jComboBox1.setNextFocusableComponent(jComboBox2);
        jComboBox1.setRenderer(this.property1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Toolbar color:");

        jComboBox2.setModel(new EzNoteComboBoxColorPicker(1));
        jComboBox2.setSelectedIndex(0);
        jComboBox2.setRenderer(this.property2);

        jLabel2.setText("Editor color:");

        jLabel3.setText("Editor text color:");

        jComboBox3.setModel(new EzNoteComboBoxColorPicker(2));
        jComboBox3.setRenderer(this.property3);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        radioGroup.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Use predefined EzNote theme");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        radioGroup.add(jRadioButton2);
        jRadioButton2.setText("Use your custom colors");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new EzNoteComboBoxThemePicker());
        jComboBox4.setRenderer(this.thproper1);

        jLabel4.setText("Caret color:");

        jComboBox5.setModel(new EzNoteComboBoxColorPicker(3));
        jComboBox5.setRenderer(new EzNoteComboBoxColorChRenderer());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(0, 262, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, 350, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Appearance", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        buttonConfirm.setBackground(new java.awt.Color(204, 255, 204));
        buttonConfirm.setText("Confirm");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        buttonApply.setText("Apply");
        buttonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonApplyActionPerformed(evt);
            }
        });

        buttonDiscard.setBackground(new java.awt.Color(255, 204, 204));
        buttonDiscard.setText("Discard");
        buttonDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDiscardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonDiscard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonApply)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonConfirm)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConfirm)
                    .addComponent(buttonApply)
                    .addComponent(buttonDiscard))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        try {
            this.applyNSave();
            this.dispose();
        } catch (ConfiguratorException ex) {
            ex = new ConfiguratorException("CONFIGURATOR: UNABLE TO SAVE CONFIGURATION FILE");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonApplyActionPerformed
        try {
            this.applyNSave();
        } catch (ConfiguratorException ex) {
            ex = new ConfiguratorException("CONFIGURATOR: UNABLE TO SAVE CONFIGURATION FILE");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonApplyActionPerformed

    private void buttonDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDiscardActionPerformed
        this.dispose();
        this.jComboBox1.setSelectedIndex(this.parent.getConfigurator().getConfigurationThemeToolbarColor());
        this.jComboBox2.setSelectedIndex(this.parent.getConfigurator().getConfigurationThemeEditorColor());
        this.jComboBox3.setSelectedIndex(this.parent.getConfigurator().getConfigurationThemeFontColor());
        this.jComboBox4.setSelectedIndex(this.parent.getConfigurator().getConfigurationThemeChoose());
        if(this.parent.getConfigurator().getConfigurationThemeMode()==0){
            this.jRadioButton1.setEnabled(true);
        } else {
            this.jRadioButton2.setEnabled(true);
        }
        
    }//GEN-LAST:event_buttonDiscardActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        this.changeThemeLockState(1);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        this.changeThemeLockState(0);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonApply;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonDiscard;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.ButtonGroup radioGroup;
    // End of variables declaration//GEN-END:variables
}

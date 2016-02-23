package gdr.eznote.components;

import gdr.eznote.themes.EzNoteColor;
import gdr.eznote.themes.EzNoteTheme;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author GDR
 */
public class EzNoteComboBoxThemeChRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public EzNoteComboBoxThemeChRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try {
            EzNoteTheme item = (EzNoteTheme) value;
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            setText(item.getName());
            if(isSelected){
                setBackground(Color.GRAY);
            }
        } catch (UnsupportedOperationException ex) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return this;
    }
}

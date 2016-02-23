package gdr.eznote.components;

import gdr.eznote.themes.EzNoteColor;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author GDR
 */
public class EzNoteComboBoxColorChRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public EzNoteComboBoxColorChRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        try {
            EzNoteColor item = (EzNoteColor) value;
            setBackground(item.getColor());
            setForeground(item.getTextColor());
            setText(item.getName());
        } catch (UnsupportedOperationException ex) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return this;
    }
}

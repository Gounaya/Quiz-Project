package view.wPanel.field;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Integer field but with a W
 */
public class WIntegerPanel extends JPanel implements ActionListener {

    /**
     * The field with the value
     */
    public JFormattedTextField field = null;

    /**
     * Button's pannel
     */
    JPanel buttons = new JPanel(new BorderLayout());

    /**
     * Increase the value
     */
    JButton plus = new JButton("+");

    /**
     * Decrease the value
     */
    JButton minus = new JButton("-");

    public WIntegerPanel() {
        setLayout(new BorderLayout());

        // TextArea Integer Specific
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance(Locale.KOREAN));
        formatter.setMinimum(Integer.MIN_VALUE);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setOverwriteMode(true);
        formatter.setCommitsOnValidEdit(true);
        field = new JFormattedTextField(formatter);
        field.setColumns(10);
        field.setText("0");

        plus.addActionListener(this);
        minus.addActionListener(this);
        buttons.add(plus, BorderLayout.WEST);
        buttons.add(minus, BorderLayout.EAST);
        plus.setMargin(new Insets(0, 0, 0, 0));

        plus.setPreferredSize(new Dimension(40, 20));
        minus.setPreferredSize(new Dimension(40, 20));

        add(field, BorderLayout.CENTER);
        add(plus, BorderLayout.WEST);
        add(minus, BorderLayout.EAST);
    }
    
    public String getText() {
        return field.getText().replaceAll(",", "");
    }
    

    public void actionPerformed(ActionEvent e) {
        try {
            int value = Integer.parseInt(getText());
            if (e.getSource() == plus) {
                value++;
            }
            if (e.getSource() == minus) {
                value--;
            }
            field.setText(value + "");
        } catch (Exception ex) {
            System.out.println("Input value is not integer, " + getText());
        }
    }

    public void reini() {
        field.setText("0");
    }

}

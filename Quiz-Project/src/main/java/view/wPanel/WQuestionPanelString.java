package view.wPanel;


import fil.coo.Constantes;
import quiz.Question;

import javax.swing.*;
import java.awt.*;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */
public class WQuestionPanelString extends WQuestionPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The text field
     */
    private JTextField field;

    public WQuestionPanelString(Question quest) {
        super(quest);
    }

    public WQuestionPanelString(Question quest, int index) {
        super(quest, index);
    }

    /**
     * Build the panel
     */
    public void buildIt() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(questionPanel(), BorderLayout.NORTH);
        add(answerPanel(), BorderLayout.SOUTH);
    }

    /**
     * Ask the question
     *
     * @return
     */
    protected JComponent questionPanel() {
        String label = ((index < 0) ? "" : index + "");
        label += " : " + quest.question + " - " + quest.point + " points";
        JComponent questionLabel = new JLabel(label);
        return questionLabel;
    }

    /**
     * Default for string answer
     *
     * @return
     */
    protected JComponent answerPanel() {
        JPanel panel = new JPanel();
        field = new JTextField(10);
        panel.add(field);
        return panel;
    }

    public void solve() {
        if (quest.answer.isCorrect(field.getText().toLowerCase())) {
            setBorder(BorderFactory.createLineBorder(Color.green));
            Constantes.point += quest.point;
        } else {
            setBorder(BorderFactory.createLineBorder(Color.red));
        }
    }

    public void reini() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        field.setText("");
    }

}

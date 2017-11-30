package view.wPanel;


import quiz.Question;

import javax.swing.*;
import java.awt.*;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

/**
 * JPanel with more arguments/methods to be adapted for our program Default
 * question/answer form are adapted for string questions
 */
public abstract class WQuestionPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The question
     */
    public Question quest = null;

    /**
     * Question number
     */
    public int index = -1;
    
    /**
     * The text field
     */
    @SuppressWarnings("unused")
	private JTextField field;

    public WQuestionPanel(Question quest) {
        setLayout(new BorderLayout());
        this.quest = quest;
    }

    public WQuestionPanel(Question quest, int index) {
        setLayout(new BorderLayout());
        this.quest = quest;
        this.index = index;
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
     */
    protected abstract JComponent answerPanel();

    /**
     * Solve the question with the response include in the field
     */
    public abstract void solve();

    /**
     * Reinitualise the question
     */
    public abstract void reini();

}

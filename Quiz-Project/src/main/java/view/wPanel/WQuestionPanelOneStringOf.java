package view.wPanel;

import fil.coo.Constantes;
import quiz.Question;

import javax.swing.*;

import answer.MultipleChoiceAnswer;

import java.awt.*;
import java.util.List;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

/**
 * Question Panel for the multiple choices answers
 */
public class WQuestionPanelOneStringOf extends WQuestionPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The list of answers
     */
    MultipleChoiceAnswer answer;

    /**
     * The group for RadioButton
     */
    ButtonGroup group;

    public WQuestionPanelOneStringOf(Question quest) {
        super(quest);
    }

    public WQuestionPanelOneStringOf(Question quest, int index) {
        super(quest, index);
    }

    @Override
    protected JComponent answerPanel() {
        JPanel panel = new JPanel();
        answer = (MultipleChoiceAnswer) quest.answer;
        List <String>answers = answer.getChoice();
        group = new ButtonGroup();
        for (String s : answers) {
            JRadioButton jrb = new JRadioButton(s);
            // Set action command allow to use the text in a ButtonModel because
            // there is no getText in ButtonModel
            jrb.setActionCommand(s);
            group.add(jrb);
            panel.add(jrb);
        }
        return panel;
    }

    @Override
    public void solve() {
        try {
            ButtonModel tmp = group.getSelection();
            if (quest.answer.isCorrect(tmp.getActionCommand().toLowerCase())) {
                setBorder(BorderFactory.createLineBorder(Color.green));
                Constantes.point += quest.point;
            } else {
                setBorder(BorderFactory.createLineBorder(Color.red));
            }
        } catch (NullPointerException e) {
            System.out.println("Question: " + index + ", no one was selected");
        }
    }


    public void reini() {
        group.clearSelection();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}

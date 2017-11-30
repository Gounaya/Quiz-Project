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

/**
 * Question Panel for the yes and no
 * 
 */
public class WQuestionPanelBoolean extends WQuestionPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * RadioButton true
     */
    JRadioButton vrai;

    /**
     * RadioButton false
     */
    JRadioButton faux;

    /**
     * The ButtonGroup who switch the true and the false RadioButton
     */
    ButtonGroup group;

    public WQuestionPanelBoolean(Question quest) {
        super(quest);
    }

    public WQuestionPanelBoolean(Question quest, int index) {
        super(quest, index);
    }

    @Override
    protected JComponent answerPanel() {
        JPanel panel = new JPanel();
        vrai = new JRadioButton("Vrai");
        faux = new JRadioButton("Faux");
        group = new ButtonGroup();
        group.add(vrai);
        group.add(faux);
        panel.add(vrai);
        panel.add(faux);
        return panel;
    }

    @Override
    public void solve() {
        String rep = (vrai.isSelected()) ? "vrai" : "faux";
        if (vrai.isSelected() || faux.isSelected()) {
            if (quest.answer.isCorrect(rep)) {
                setBorder(BorderFactory.createLineBorder(Color.green));
                Constantes.point += quest.point;
            } else {
                setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }

    @Override
    public void reini() {
        group.clearSelection();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}

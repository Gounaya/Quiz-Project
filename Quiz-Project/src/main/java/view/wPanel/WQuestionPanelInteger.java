package view.wPanel;

import view.wPanel.field.WIntegerPanel;
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
 * Question Panel for numerical
 */
public class WQuestionPanelInteger extends WQuestionPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The field
     */
    WIntegerPanel wif;

    public WQuestionPanelInteger(Question quest) {
        super(quest);
    }

    public WQuestionPanelInteger(Question quest, int index) {
        super(quest, index);
    }

    @Override
    protected JComponent answerPanel() {
        JPanel panel = new JPanel();
        wif = new WIntegerPanel();
        panel.add(wif);
        return panel;
    }

    @Override
    public void solve() {
        if (quest.answer.isCorrect(wif.getText())) {
            setBorder(BorderFactory.createLineBorder(Color.green));
            Constantes.point += quest.point;
        } else {
            setBorder(BorderFactory.createLineBorder(Color.red));
        }
    }

    public void reini() {
        wif.reini();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}

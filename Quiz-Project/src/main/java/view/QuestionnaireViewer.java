package view;
import fil.coo.Constantes;

import view.wPanel.QuestionPanelBuilder;
import view.wPanel.WQuestionPanel;
import quiz.Question;
import quiz.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */
/**
 * Main windows for ihm
 */
@SuppressWarnings("serial")
public class QuestionnaireViewer extends JFrame implements ActionListener {

    /**
     * The Questionnaire to use
     */
    @SuppressWarnings("unused")
	private Quiz q = null;

    /**
     * Main panel
     */
    private JPanel mainPanel = new JPanel();

    /**
     * Central panel for questions
     */
    private JPanel centralPanel = new JPanel();

    /**
     * South panel with submit button
     */
    private JPanel southPanel = new JPanel();

    /**
     * Submit button
     */
    private JButton submit = new JButton("Submit");

    /**
     * List of question panel to show and solve
     */
    private ArrayList<WQuestionPanel> awq = new ArrayList<WQuestionPanel>();

    /**
     * Boolean if false allow to tap the submit button
     */
    private boolean solved = false;

    public QuestionnaireViewer(Quiz q) {
        this.q = q;
        setDefaultCloseOperation(3);
        setSize(600, 600);
        setTitle("Questionnaire");
        setLocationRelativeTo(null);
        setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainPanel.setLayout(new BorderLayout());
        centralPanel.setLayout(new GridLayout(q.questions.size(), 1));

        int i = 1;
        for (Question quest : q.questions) {
            WQuestionPanel wq = QuestionPanelBuilder.buildMyPanel(quest, i);
            centralPanel.add(wq);
            awq.add(wq);
            i++;
        }
        JScrollPane jsp = new JScrollPane(centralPanel);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL, 10, 10, 0, 300));

        submit.addActionListener(this);
        southPanel.add(submit);
        mainPanel.add(jsp, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (!solved) {
            for (WQuestionPanel wq : awq) {
                wq.solve();
            }
            JOptionPane.showMessageDialog(this, "Tu as gagne " + Constantes.point + " point(s).");
            solved = true;
            submit.setText("Reinitialiser");
        } else {
            Constantes.point=0;
            for (WQuestionPanel wq : awq) {
                wq.reini();
            }
            solved = false;
            submit.setText("Submit");
        }
    }

}

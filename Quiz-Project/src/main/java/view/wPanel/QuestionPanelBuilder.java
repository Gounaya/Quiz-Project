package view.wPanel;

import quiz.Question;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

/**
 * Give the view of a question
 */
public class QuestionPanelBuilder {

    /**
     * Build the panel for one question
     * @param quest The question
     * @param index The index of the question, from 0 to MAX_INTEGER
     * @return build of the panel
     */
    public static WQuestionPanel buildMyPanel(Question quest, int index) {
        WQuestionPanel toBuild;
        switch (quest.answer.getTypeAnswer()) {
            case YESNO:
                toBuild = new WQuestionPanelBoolean(quest, index);
                break;
            case INTEGER:
                toBuild = new WQuestionPanelInteger(quest, index);
                break;
            case STRING:
            case MULTISTRING:
                // Both are same but I didn't separate them
                toBuild = new WQuestionPanelString(quest, index);
                break;
            case ONEOFSTRING:
                toBuild = new WQuestionPanelOneStringOf(quest, index);
                break;
            default:
                toBuild = new WQuestionPanelString(quest, index);
                break;
        }
        toBuild.buildIt();
        return toBuild;
    }

}

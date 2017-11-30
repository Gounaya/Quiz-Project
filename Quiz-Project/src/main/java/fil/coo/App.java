package fil.coo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import quiz.Quiz;
import quiz.QuizFactory;
import view.QuestionnaireViewer;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */


/**
 * the main class
 * 
 * */
public class App 
{

    @SuppressWarnings("unused")
	private static QuestionnaireViewer qv;

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
    	Quiz quiz = QuizFactory.INSTANCE.build("question_tolkien_2.txt");
        /**
         * the console version
         */
      //quiz.askAll();

	/**
	* In Graphic Version
	**/

        qv = new QuestionnaireViewer(quiz);

    }


}

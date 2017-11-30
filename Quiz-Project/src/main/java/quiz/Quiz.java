package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class Quiz {
	public List<Question> questions;
	private static Scanner scanner;
	
	/**
	 * the constructor of the class Quiz
	 * 
	 * */
	public Quiz() {
		this.questions = new LinkedList<Question>();
		Quiz.scanner = new Scanner(System.in);
	}
	/**
	 * 
	 * @param question
	 * 
	 * 
	 * the method will able to add a question in the list 
	 */
	public void add(Question question ) {
		questions.add(question);
	}
	/**
	 *@param Question question
	 *the method will see if the asnwer is correct the score will incream 
	 *
	 *@return return number of the result */
	private int ask(Question question) {
		int result=0;
		
		String playerAnswer;//=scanner.nextLine();
		System.out.println(question.getQuestion());
		do {
			System.out.println(question.getPrompt());
			playerAnswer= scanner.nextLine();
			
		}while(!question.isValid(playerAnswer));
		
		if(question.isCorrect(playerAnswer)) {
			result += question.getPoints();
		}

		return result;
	}
	/**
	 * @param int points
	 * 
	 * @return String the score of the player s*/
	private static String format(int points) {
		return "" + points + " point" +(points > 1?"s":"") ; 
	}
	/**
	 * ask all the questions
	 */
	public void askAll() {
		int result = 0;
		for(Question question : this.questions) {
			result += this.ask(question);
		}
		
		System.out.println("Votre résultat est :"+ format(result));	}
	
	
}

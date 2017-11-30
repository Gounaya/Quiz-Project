package quiz;

import java.util.Scanner;

import answer.Answer;
import fil.coo.Constantes;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class Question {
	public int point;
	public String question;
	public Answer answer;
	private Scanner scan;
	/**
	 *  the constructor of the class Question
	 *  
	 * @param text
	 * @param answer
	 * @param nbpoints
	 */
	public Question (String text, Answer answer,int  nbpoints){
		this.question = text;
		this.point= nbpoints; 
		this.answer = answer;
		
	}
	/**
	 * 
	 * @param questionText set the question
	 */
	public void setQuestion(String questionText) {
		this.question = questionText;
	}
	
	/**
	 *@param  s 
	 *
	 *the method see if the answer is correct or not 
	 *
	 *@return true if the answer is correct
	 */
	public boolean isCorrect(String s) {
		return answer.isCorrect(s);
	}
	/**
	 * @param s the question to test
	 * 
	 * 
	 * @return true if the answers are correct*/
	public boolean isValid(String s) {
		return answer.isValid(s);
	}
	/**
	 * @return the question*/
	public String getQuestion(){
		return this.question;
	}
	/**
	 * @return the format of the answer most be*/
	public String getPrompt( ) {
		return answer.getPrompt();
	}
	/**
	 * @return the number of points*/
	public int getPoints() {
		return this.point;
	}
	
	/**
	 * Ask and wait a response, if it's true, it gives some points to user
	 */
	public void askTextVersion() {

		scan = new Scanner(System.in);
		System.out.println(answer.getPrompt() + question);
		String rep = scan.next().toLowerCase();
		if (answer.isCorrect(rep)) {
			System.out.println("Good");
			Constantes.point += this.point;
		} else {
			System.out.println("False, it was " + answer);
		}
	}
	

}

package answer;

import answer.TypeAnswer;


/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class YesNoAnswer extends SingleAnswer {
	/**
	 * @param answer 
	 *  
	 * the constructor of the class YesNoAnswer
	 * */
	public YesNoAnswer(String answer) {
		super(answer);
	}
	/**
	 * the method return the form of the answer 
	 * 
	 * 
	 * @return oui/non
	 * */
	public String getPrompt() {
		return "oui/non";
	}
	/**
	 * @param  s
	 * 
	 * the method see if the answer is the right form or not
	 * 
	 * @return if is in the right form 
	 * */
	public boolean isValid(String s) {
		return (s.equalsIgnoreCase("oui")||s.equalsIgnoreCase("non"));	
	}
	
	/**
	 * @return retourne le type de la réponse
	 */
	@Override
	public TypeAnswer getTypeAnswer() {
		return TypeAnswer.YESNO;
	}
}

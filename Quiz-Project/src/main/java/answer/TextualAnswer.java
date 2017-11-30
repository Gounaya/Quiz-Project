package answer;

import answer.TypeAnswer;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class TextualAnswer extends SingleAnswer {
	/**
	 * @param answer 
	 * the constructor of the class 
	 * 
	 * */
	public TextualAnswer(String answer) {
		super(answer);
	}
	/**
	 * the method return the format of the answer most be 
	 * 
	 * @return String symbolique
	 * */
	public String getPrompt() {
		return "(symbolique)";
	}
	/**
	 * @param  s
	 * the method test if the answer is  the right form
	 * 
	 *  
	 * @return True*/
	public boolean isValid(String s) {		
		return true;
	}
	/**
	 * @return le type de la réponse 
	 */
	@Override
	public TypeAnswer getTypeAnswer() {
		return TypeAnswer.STRING;
	}

}

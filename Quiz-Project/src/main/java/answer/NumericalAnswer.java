package answer;

import answer.TypeAnswer;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class NumericalAnswer extends SingleAnswer {
	/**
	 * the constructor
	 * 
	 * @param  answer
	 * 
	 * */
	public NumericalAnswer(String answer) {
		super(answer);
	}
	/**
	 * the method will return the type of the questions 
	 * 
	 * @return numerique
	 * */
	@Override
	public String getPrompt() {
		return "(numerique)";
	}
	/**
	 * @param  s
	 * 
	 * 
	 * @return true */
	@Override
	public boolean isValid(String s) {
		// integer. parseINT si false = pas un numerical
		// toLowerCase().matches([0-9]*)
		for(int i =0; i< s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}	
	
	@Override
	public TypeAnswer getTypeAnswer() {
		return TypeAnswer.INTEGER;
	}

}

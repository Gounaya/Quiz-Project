package answer;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public abstract class SingleAnswer implements Answer {
	
	/**
	 * the constructor of the class
	 * @param  answer
	 * 
	 * */
	public SingleAnswer (String answer) {
		this.answer= answer;
	}
	
	public String answer;
	/**
	 * @param  s 
	 * 
	 * the method will test if the answer is correct or not
	 * 
	 * @return */
	public boolean isCorrect(String s) {
		return (answer.equalsIgnoreCase(s));
		}
	

}

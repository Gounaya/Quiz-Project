package answer;
/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public interface Answer {
	public String getPrompt();
	
	/**
	 * @param s
	 * this abstract method will see if the format of the s is valid wich means 
	 * the right form 
	 * 
	 * @return true if the answer is valid*/
	public boolean isValid(String s);
	
	/**
	 * @param s
	 * this abstract method will see if the answer is correct or not 
	 * 
	 * @return true if the answer is correct*/
	public boolean isCorrect(String s);
	public  abstract TypeAnswer getTypeAnswer(); 
}

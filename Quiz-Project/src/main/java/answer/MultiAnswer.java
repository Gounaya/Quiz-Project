package answer;
/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import answer.TypeAnswer;

public class MultiAnswer implements Answer {
	
	protected List<TextualAnswer> answer;
	/**
	 * the constructor of the class
	 *@param  answer
	 *
	 * 
	 * */
	public MultiAnswer(String answer) {
		
		this.answer = new ArrayList <TextualAnswer>();
		String[] answerArray= answer.split(" ; ");
		
		
		for ( String s :  answerArray){
			TextualAnswer tanswer = new TextualAnswer(s);
			this.answer.add(tanswer);
		}
	}
	/**
	 * @return the method returns the number of answer possible */
	@Override
	public String getPrompt() {
		return "(" + answer.size() +"réponses possibles)";
	}
	/**
	 * @param  s
	 * 
	 * the method return true if the answer is valid which means in right form 
	 * 
	 * @return True
	 * */
	@Override
	public boolean isValid(String s) {
		return answer.get(0).isValid(s);
	}
	/**
	 * @param  s 
	 * 
	 * the method return true if the answers are correct
	 * 
	 *  @return true */
	@Override
	public boolean isCorrect(String s) {
		for(TextualAnswer oneTa : this.answer){
			 if(oneTa.isCorrect(s))	
					 return true;
		}
		return false;
	}
	
	/**
	 * @return the type of the answer
	 */
	@Override
	public TypeAnswer getTypeAnswer() {
		return TypeAnswer.MULTISTRING;
	}

}

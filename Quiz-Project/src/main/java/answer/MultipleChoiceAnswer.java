package answer;
/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import answer.TypeAnswer;

public class MultipleChoiceAnswer extends TextualAnswer {
	
	protected List <String> choice;

	/**
	 * the constructor 
	 * @param answerishere
	 * 
	 * 
	 * */
	public MultipleChoiceAnswer(String answerishere) {
		super(answerishere.substring(0, answerishere.indexOf(" | ")));
		choice = new ArrayList<String>();
		String[] answerishereArray= answerishere.split(" \\| ");
		for ( String s :  answerishereArray){
			choice.add(s);
		}
		Collections.shuffle(choice);
	}
	/**
	 * 
	 * @return list of choices
	 */
	public List <String> getChoice(){
		return this.choice;
	}
	/**
	 * 
	 * 
	 * 
	 * @return  all the possible answers*/
	@Override
	public String getPrompt() {
		return "("+ String.join(", ", choice) +")";
	}
	/**
	 * @param s
	 * 
	 * 
	 * @return true if the answers are correct*/
	@Override
	public boolean isValid(String s){
		return choice.contains(s);
	}
	/**
	 * @return the type of the answer
	 */
  @Override
    public TypeAnswer getTypeAnswer() {
        return TypeAnswer.ONEOFSTRING;
    }
	
}

package answer;
/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AnswerFactory  {
	
	public final static AnswerFactory FACTORY = new AnswerFactory() ;
	
	public AnswerFactory() {}
	
	/**
	 * 
	 * @param answerText Le texte de la réponse
	 * @param className	la nom de la classe du réponse
	 * @return une nouvelle instance de réponse
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Answer build(String answerText, String className) // TODO test generer des exception
		throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> c = Class.forName("answer." + className);
		Constructor<?> constr = c.getConstructor(String.class);
		return (Answer) constr.newInstance(answerText);
	}
}

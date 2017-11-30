package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import answer.AnswerFactory;

/**
 * @author OUSSAMA GOUNAYA
 * 
 * 
 * */

public class QuizFactory {
	  public static final QuizFactory INSTANCE = new QuizFactory();
	  /**
	   * Crée une question
	   * @param text le texte de la question 
	   * @param answer la réponse de cette question
	   * @param points le nombre de points que la réponse apporte s'il est correcte
	   * @param typeAnswer le type de la réponse attendu
	   * @return la question 
	   * @throws IOException  Input/Output : si le chaine de caractére ne peux pas être interpreter
	   * @throws ClassNotFoundException classe non trouvé
	   * @throws NoSuchMethodException pas de méthode trouvé
	   * @throws SecurityException probleme de sécurité
	   * @throws InstantiationException il y a pas eu d'instance
	   * @throws IllegalAccessException acces illégal 
	   * @throws IllegalArgumentException argument illégal 
	   * @throws InvocationTargetException probleme dans l'invocation de la cible
	   */
    public Question createQuestion ( String text , String answer , String points, String typeAnswer )
	throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	try {
	    int nbPoints = Integer.parseInt(points);
	    return new Question( text , AnswerFactory.FACTORY.build(answer,typeAnswer),nbPoints );
	}
	catch(NumberFormatException e) {
	    throw new IOException("bad format");
	}
    }
    /**
     * methode pour construire un questionnaire
     * @param fileName le nom du fichier a partir duquel on va construire ce questionnaire
     * @return le questionnaire
     * @throws IOException Input/Output : si le chaine de caractére ne peux pas être interpreter
     * @throws ClassNotFoundException classe non trouvé
     * @throws NoSuchMethodException pas de méthode trouvé
     * @throws SecurityException probleme de sécurité
     * @throws InstantiationException il y a pas eu d'instance
     * @throws IllegalAccessException acces illégal
     * @throws IllegalArgumentException argument illégal 
     * @throws InvocationTargetException probleme dans l'invocation de la cible
     */
    public Quiz build ( String fileName) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	Quiz Quiz = new Quiz ( );
	File source = new File ( fileName );
	BufferedReader in = null ;
	try {
	    in = new BufferedReader(new FileReader ( source ) );
	    String text ;
	    // read block of 3 li n e s : text , answer and number of points
	    while (( text = in . readLine())!= null ) {
		String answer = in . readLine ( );
		String nbPoints = in . readLine ( );
		String typeAnswer = in.readLine();
		if (answer == null || nbPoints == null ) {
		    throw new IOException("bad format");
		}
		Quiz.add(this.createQuestion(text,answer,nbPoints,typeAnswer) );
	    }
	} catch (FileNotFoundException e) {
	    throw new IOException(e );
	}
	finally {
	    in.close( );
	}
	return Quiz ;
    }
}

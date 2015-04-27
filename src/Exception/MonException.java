package Exception;

public class MonException extends Exception{
	String erreur;
	
	public MonException(String e){
		super();
		erreur = e;
	}
	
	public String toString(){
		return(erreur);
	}
}

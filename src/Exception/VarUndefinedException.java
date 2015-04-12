package Exception;

public class VarUndefinedException extends Exception {
	 
	public VarUndefinedException(int varName){
		super("La variable possedant l'id : "+varName+" n'a pas été déclaré");
	}
}

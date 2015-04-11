package version_bis;

public class NodeContentAppel{
	
	private String id;
	
	private boolean hasReturn;
	
	// inutile, il suffit de compter les enfans
	private int nb_param;
	
	public NodeContentAppel(String i, int n){
		id=i;
		nb_param=n;
	}

	
	public NodeContentAppel(String id, boolean hasReturn, int nb_param) {
		super();
		this.id = id;
		this.hasReturn = hasReturn;
		this.nb_param = nb_param;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNb_param() {
		return nb_param;
	}

	public void setNb_param(int nb_param) {
		this.nb_param = nb_param;
	}
	
	public String toString(){
		return("appel "+" "+id+" "+nb_param+" "+hasReturn);
	}


	public boolean isHasReturn() {
		return hasReturn;
	}


	public void setHasReturn(boolean hasReturn) {
		this.hasReturn = hasReturn;
	}
	
	

}
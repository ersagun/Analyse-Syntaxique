package fr.ul.miage.projet;

public class NodeContentCondition {
	private String comparator;

	public NodeContentCondition(String comparator) {
		super();
		this.comparator = comparator;
	}
	
	public String toString(){
		return(comparator);
	}

	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}
	
	
	
}
package AST;

import java.util.ArrayList;

import TDS.TDS;

public class NListeParam extends NoeudElement {

	
	public ArrayList<NoeudElement> listeParam;
	
	public NListeParam() {
		super("listeparam");
		this.listeParam=new ArrayList<NoeudElement>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud ListeParam => #type : =listeparam";
	}

	public void addParam(NoeudElement a){
		this.listeParam.add(a);
	}
	
	public int size()
	{
		return this.listeParam.size();
	}
	
	
	
}

package AST;

import java.util.ArrayList;

import TDS.TDS;
import TDS.TdsElement;

public class NOutil extends NoeudElement {
	private ArrayList<TdsElement> list;
	private ArrayList<NoeudElement> instructions;
	
	public NOutil() {
		super("noutil");
		this.list=new ArrayList<TdsElement>();
		this.setInstructions(new ArrayList<NoeudElement>());
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TdsElement> getList() {
		return list;
	}

	public void setList(ArrayList<TdsElement> list) {
		this.list = list;
	}
	
	public void initializeInstructions(){
		this.getInstructions().clear();
	}

	public ArrayList<NoeudElement> getInstructions() {
		return instructions;
	}

	public void setInstructions(ArrayList<NoeudElement> instructions) {
		this.instructions = instructions;
	}

}

package AST;
import TDS.*;
import AST.NoeudElement;


public class NAffectation extends NoeudElement {
	String val;
	public NAffectation(String c) {
		super("affectation");
		this.val=c;
		
	}
	
	public NAffectation(NoeudElement idf,NExpression ne,String c){
		super("affectation");
		this.ajouterFG(idf);
		this.ajouterFD(ne);
		this.val=c;
	}
	
	/**
	public NAffectation(String var,int scope,String c,TDS tds,NExpression ne){
		super("affectation");
		this.val=c;
		
		boolean found=false;
		NoeudElement varr = null;
		TdsElement te=tds.searchVariable(var, scope);
		//il faut aller chercher
		if(	te instanceof Variable){
			varr=new NVariable(((Variable)te).getId(),((Variable)te).getScope());
			found=true;
		}
		if(	te instanceof Vlocale &&found==false){
			varr=new NVariable(((Variable)te).getId(),((Vlocale)te).getScope());
			found=true;
		}
		
		if(	te instanceof Parametre &&found==false){
			varr=new NVariable(((Variable)te).getId(),((Parametre)te).getScope());
			found=true;
		}
		this.ajouterFG(varr);
		this.ajouterFD(ne);
	
	}
	
	public NAffectation(String var,int scope,String c,int val,TDS tds, NExpression ne){
		super("affectation");
		this.val=c;
		
		boolean found=false;
		NoeudElement varr = null;
		TdsElement te=tds.searchVariable(var, scope);
		//il faut aller chercher
		if(	te instanceof Variable){
			varr=new NVariable(((Variable)te).getId(),((Variable)te).getScope());
			found=true;
		}
		if(	te instanceof Vlocale &&found==false){
			varr=new NVariable(((Variable)te).getId(),((Vlocale)te).getScope());
			found=true;
		}
		
		if(	te instanceof Parametre &&found==false){
			varr=new NVariable(((Variable)te).getId(),((Parametre)te).getScope());
			found=true;
		}
		this.ajouterFG(varr);
		this.ajouterFD(ne);
	
	}
	
	**/
	
	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud Affectation => #type : =";
	}

}

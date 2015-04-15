package AST;

import TDS.*;

public class NOperation extends NoeudElement {
	
	String val;
	
	//creation de noeud d'operation +,-,*,:,>,<
	public NOperation(String t) {
		super("operation");
		this.val=t;
		
	}	
	
	public NOperation(int i, String opp, String s,int scope,TDS tds){
		super("operation");
		this.val=opp;
		boolean found=false;
		NoeudElement var = null;
		TdsElement te=tds.searchVariable(s, scope);
		//il faut aller chercher
		if(	tds.searchVariable(s, scope) instanceof Variable){
			var=new NVariable(((Variable)te).getId(),((Variable)te).getScope());
			found=true;
		}
		if(	tds.searchVariable(s, scope) instanceof Vlocale &&found==false){
			var=new NVariable(((Variable)te).getId(),((Vlocale)te).getScope());
			found=true;
		}
		
		if(	tds.searchVariable(s, scope) instanceof Parametre &&found==false){
			var=new NVariable(((Variable)te).getId(),((Parametre)te).getScope());
			found=true;
		}
		
		NoeudElement constant=new NConstant(i);
		this.ajouterFG(constant);
		this.ajouterFD(var);
	
	}
	
	
	
	public NOperation(String i,int scope, String opp, int s, TDS tds){
		super("operation");
		this.val=opp;
		boolean found=false;
		NoeudElement var = null;
		TdsElement te=tds.searchVariable(i, scope);
		//il faut aller chercher
		if(	tds.searchVariable(i, scope) instanceof Variable){
			var=new NVariable(((Variable)te).getId(),((Variable)te).getScope());
			found=true;
		}
		if(	tds.searchVariable(i, scope) instanceof Vlocale &&found==false){
			var=new NVariable(((Variable)te).getId(),((Vlocale)te).getScope());
			found=true;
		}
		
		if(	tds.searchVariable(i, scope) instanceof Parametre &&found==false){
			var=new NVariable(((Variable)te).getId(),((Parametre)te).getScope());
			found=true;
		}
		
		NoeudElement constant=new NConstant(s);
		this.ajouterFG(var);
		this.ajouterFD(constant);
	
	}
	
	
	public NOperation(String i,int scope, String opp, String j,int scope2, TDS tds){
		super("operation");
		this.val=opp;
		boolean found=false;
		NoeudElement var = null;
		NoeudElement var2 = null;
		TdsElement te=tds.searchVariable(i, scope);
		TdsElement te2=tds.searchVariable(j, scope2);
		//il faut aller chercher var i
		if(	tds.searchVariable(i, scope) instanceof Variable){
			var=new NVariable(((Variable)te).getId(),((Variable)te).getScope());
			found=true;
		}
		if(	tds.searchVariable(i, scope) instanceof Vlocale &&found==false){
			var=new NVariable(((Variable)te).getId(),((Vlocale)te).getScope());
			found=true;
		}
		
		if(	tds.searchVariable(i, scope) instanceof Parametre &&found==false){
			var=new NVariable(((Variable)te).getId(),((Parametre)te).getScope());
			found=true;
		}
		
		
		//il faut aller chercher var j
				if(	tds.searchVariable(j, scope2) instanceof Variable){
					var2=new NVariable(((Variable)te2).getId(),((Variable)te2).getScope());
					found=true;
				}
				if(	tds.searchVariable(j, scope2) instanceof Vlocale &&found==false){
					var2=new NVariable(((Variable)te2).getId(),((Vlocale)te2).getScope());
					found=true;
				}
				
				if(	tds.searchVariable(j, scope2) instanceof Parametre &&found==false){
					var2=new NVariable(((Variable)te2).getId(),((Parametre)te2).getScope());
					found=true;
				}
				
		this.ajouterFG(var);
		this.ajouterFD(var2);
	}
	
	
	
	
	
	
	
	
	
	
	
	public NOperation(NoeudElement a,String operation,NoeudElement b){
		super("operation");
		this.val=operation;
		this.ajouterFG(a);
		this.ajouterFD(b);;
	}
	
	

	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud operation => #type : " + this.val;
	}


	public String getVal() {
		return val;
	}

}

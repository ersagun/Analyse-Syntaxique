package TDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Exception.VarExiste;
import Exception.VarUndefinedException;

/**
 * Cette classe nous permets de stocker toutes les informations 
 * concernant les variables locales, globales, les parametres effectifs, parametres normales, les fonctions etc..
 * @author Groupe : Complilation L3 MIAGE 2014-2015
 *
 */
public class TDS {

	ArrayList<TdsElement> table;
	public static Comparator<TdsElement> StuRollno = new Comparator<TdsElement>() {

		public int compare(TdsElement s1, TdsElement s2) {

		   int rollno1 = s1.getId();
		   int rollno2 = s2.getId();

		   return rollno1-rollno2;

	   }};
	   
	public TDS(){
		table=new ArrayList<TdsElement>();
	}
	
	
	public void ajoute(TdsElement te){
		if (this.table.contains(te)) {
		    try {
				throw new VarExiste();
			} catch (VarExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			table.add(te);
		}
	}
	
	
	
	// IDF et SCOPE
	public TdsElement search(int idfp,int scopep){
		int taille=this.table.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
		for(TdsElement n:this.table){
			if(n instanceof Variable){	
				if(((Variable)n).id==idfp && ((Variable)n).scope==scopep){
					a=n;
					trouve=true;
					break;
				}
			}
		}
	
		
		if(trouve==false){
			for(TdsElement n:this.table){
				if(n instanceof Vlocale){	
					if(((Vlocale)n).id==idfp && ((Vlocale)n).scope==scopep){
						a=n;
						trouve=true;
						break;
					}
				}
			}
				
			}
		if(trouve==false){
			 try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	
	public TdsElement searchVloc(int idfp,int scopep){
		int taille=this.table.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
			for(TdsElement n:this.table){
				if(n instanceof Vlocale){	
					if(((Vlocale)n).id==idfp && ((Vlocale)n).scope==scopep){
						a=n;
						trouve=true;
						break;
					}
				}
			}
		return a;
	}
	
	
	public TdsElement searchVloc(String i){
		int taille=this.table.size();
		TdsElement a=null;
		boolean trouve=false;
		
			for(TdsElement n:this.table){
				if(n instanceof Vlocale){	
					if(((Vlocale)n).nom.equals(i)){
						a=n;
						trouve=true;
						break;
					}
				}
			}
		return a;
	}
	
	
	//IDF
	public TdsElement search(int idfp){
		int taille=this.table.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
			for(TdsElement n:this.table){
					
					if(n.id==idfp){
						a=n;
						trouve=true;
						break;
					}
				}
			
		if(trouve==false){
			 try {
				throw new VarUndefinedException(idfp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	
	public TdsElement search(String nom){
	
		TdsElement a=null;
		boolean trouve=false;
		
			for(TdsElement n:this.table){
					
					if(n.getNom().equals(nom)){
						a=n;
						trouve=true;
						break;
					}
				}
			
		if(trouve==false){
			 try {
				 throw new VarUndefinedException(nom);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	


	//NOM et SCOPE
	public TdsElement searchVariable(String nom){
		TdsElement a=null;
		boolean trouve=false;
		
		outerloop:
		for(TdsElement n:this.table){
			if(n instanceof Variable && trouve==false){				
				if(((Variable)n).nom.equals(nom)){
					a=n;
					trouve=true;
					break outerloop;
				}
			}
		}
		if(trouve==false){
	    outerloop:
		for(TdsElement n:this.table){
			if(n instanceof Vlocale ){		
				if(((Vlocale)n).nom.equals(nom) ){
				a=n;
				trouve=true;
				break outerloop;
				}
			}
		}
		}
		if(trouve==false){
		outerloop:
		for(TdsElement n:this.table){
			if(n instanceof Parametre){		
				if(((Parametre)n).nom.equals(nom)){
				a=n;
				trouve=true;
				break outerloop;
				}
			}
		}
		}
		if(trouve==false){
		a=this.search(nom);
		}
		return a;
	}
	
	public TdsElement searchVGlob(String nom){
		TdsElement a=null;
		boolean trouve=false;
		
		outerloop:
		for(TdsElement n:this.table){
			if(n instanceof Variable && trouve==false){				
				if(((Variable)n).nom.equals(nom)){
					a=n;
					trouve=true;
					break outerloop;
				}
			}
		}
		return a;
	}
	
	
	//NOM et SCOPE
		public TdsElement searchVariable(String nom,int scope){
			TdsElement a=null;
			boolean trouve=false;
			
			outerloop:
			for(TdsElement n:this.table){
				if(n instanceof Variable && trouve==false){				
					if(((Variable)n).nom.equals(nom) && ((Variable)n).scope==scope){
						a=n;
						trouve=true;
						break outerloop;
					}
				}
			}
			if(trouve==false){
		    outerloop:
			for(TdsElement n:this.table){
				if(n instanceof Vlocale ){		
					if(((Vlocale)n).nom.equals(nom) && ((Vlocale)n).scope==scope){
					a=n;
					trouve=true;
					break outerloop;
					}
				}
			}
			}
			if(trouve==false){
			outerloop:
			for(TdsElement n:this.table){
				if(n instanceof Parametre){		
					if(((Parametre)n).nom.equals(nom) && ((Parametre)n).scope==scope){
					a=n;
					trouve=true;
					break outerloop;
					}
				}
			}
			}
			if(trouve==false){
			a=this.search(nom);
			}
			return a;
		}
		
	
	
	//NOM et SCOPE
		public TdsElement searchFonction(String nom){
			TdsElement a=null;
			boolean trouve=false;
			
			
			for(TdsElement n:this.table){
				if(n instanceof Fonction){				
					if(((Fonction)n).nom.equals(nom)){
						a=n;
						trouve=true;
						break;
					}
				}
			}
			return a;
		}
		
		public TdsElement searchParam(String nom){
			TdsElement a=null;
			boolean trouve=false;
			
			
			for(TdsElement n:this.table){
				if(n instanceof Parametre && trouve==false){				
					if(((Parametre)n).nom.equals(nom)){
						a=n;
						trouve=true;
						break;
					}
				}
			}
			return a;
		}
		
	
	
	public static TdsElement search(ArrayList<TdsElement> t,int idfp,int scopep){
		int taille=t.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
		for(TdsElement n:t){
			if(n.id==idfp && ((Variable)n).scope==scopep){
				a=n;
				trouve=true;
				break;
			}
		}
		
		if(trouve==false){
			for(TdsElement n:t){
				if(n.id==idfp){
					a=n;
					trouve=true;
					break;
				}
			}
		}
		if(trouve==false){
			 try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	public String afficheInformation(){
		return this.toString();
	}


	public ArrayList<TdsElement> getTable() {
		return table;
	}


	public void setTable(ArrayList<TdsElement> table) {
		this.table = table;
	}
	
	public String afficheTDS(){
		String s="";
		for (TdsElement tdse : this.table) {
		    System.out.println(tdse.toString());
		}
		return s;
	}

	
	public void tri(){
		Collections.sort(this.table, TDS.StuRollno);
	}
	

	
	
	

	public String searchVariable(int ref) {
		// TODO Auto-generated method stub
		return this.table.get(ref).toString();
	}


	public boolean searchDubleGlob(String string) {
		boolean val=false;
		Variable a=null;
		a=(Variable) this.searchVGlob(string);
		if(a!=null){
			val=true;
		}else{
			val=false;
		}
		return val;
	}
}

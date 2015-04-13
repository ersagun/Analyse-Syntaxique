package TDS;

import java.util.ArrayList;
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
	
	
	
	public TdsElement search(int idfp,int scopep){
		int taille=this.table.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
		for(TdsElement n:this.table){
			if(n.idf==idfp && ((Variable)n).scope==scopep){
				a=n;
				trouve=true;
				break;
			}
		}
		
		if(trouve==false){
			for(TdsElement n:this.table){
				if(n.idf==idfp){
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
	
	public TdsElement search(int idfp){
		int taille=this.table.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
		for(TdsElement n:this.table){
			if(n.idf==idfp){
				a=n;
				trouve=true;
				break;
			}
		}
		
		if(trouve==false){
			for(TdsElement n:this.table){
				if(n.idf==idfp){
					a=n;
					trouve=true;
					break;
				}
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
	
	
	
	
	public static TdsElement search(ArrayList<TdsElement> t,int idfp,int scopep){
		int taille=t.size();
		int i=0;
		TdsElement a=null;
		boolean trouve=false;
		
		for(TdsElement n:t){
			if(n.idf==idfp && ((Variable)n).scope==scopep){
				a=n;
				trouve=true;
				break;
			}
		}
		
		if(trouve==false){
			for(TdsElement n:t){
				if(n.idf==idfp){
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
}

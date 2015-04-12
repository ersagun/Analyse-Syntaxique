package TDS;

import java.util.ArrayList;

import Exception.VarUndefinedException;

/**
 * Cette classe nous permets de stocker toutes les informations 
 * concernant les variables locales, globales, les parametres effectifs, parametres normales, les fonctions etc..
 * @author Ersagun
 *
 */
public class TDS {

	ArrayList<TdsElement> table;
	
	public TDS(){
		table=new ArrayList<TdsElement>();
	}
	
	
	public void ajoute(TdsElement te){
		table.add(te);
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
}

package fr.ul.miage.java;


import java.util.ArrayList;
import java.util.Date;


public class Sessions {
	
	public static int id_session=0;

	public ArrayList<Session> list;
	
	public Sessions(){
		this.list=new ArrayList<Session>();
	}

	public void add(String ip, Date timestamp) {
		int sess_id=-1;
		//parcours de la liste des sessions
		if(this.list.size()!=0){
		for (Session s : list) {	
			
			//on verifie si l'ip correspond a la session
			if (s.getIp().equals(ip)) {
				// on verifie si l'evenement est dans les temps de la session
				if (s.isDateOk(timestamp.getTime())) {
					sess_id=s.getId_session();
					// on ajoute l'evenement
					s.add(new Evenement(ip,timestamp));
				}
			}
		}
		}
		if (sess_id==-1) {
			//on crée un nouvelle session si l'ip de l'evenement n'est pas dans les temps d'une session ou n'appartient a aucune session
			//System.out.println(ip+","+timestamp.getTime());
			id_session++;
			Session s=new Session(ip,id_session);
			s.add(new Evenement(ip,timestamp));
			list.add(s);
		}
	}
	
	/**
	 * Calcule le nombre de session
	 * @return
	 */
	public int getNbSession () {
		return list.size();
	}
	
	/**
	 * Calcule la moyenne : calcul -> date du dernier evenement - le premier evenement 
	 * de chaque session additionné pour chaque session et divisé par nombre de session
	 * @return
	 */
	public long getAvgTotal(){
		long tot=0;
		for (Session s : list) {
			tot=tot+s.getAvg();
		}
		return tot/list.size();
		}
}
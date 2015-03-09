package fr.ul.miage.java;
import java.util.Date;

/**
 * Cette classe represente un evenement, une ligne du fichier log apache
 * @author Ersagun
 *
 */
public class Evenement {
	/**
	 * Evenement detail
	 */
	public String id_event;
	/**
	 * Date de l'evenement
	 */
	public Date date;
/**
 * Un evenement a un nom et une date
 * @param id
 * @param d
 */
	public Evenement (String id, Date d) {
		this.id_event=id;
		this.date=d;
	}

	public String getId_event() {
		return id_event;
	}

	public void setId_event(String id_event) {
		this.id_event = id_event;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}


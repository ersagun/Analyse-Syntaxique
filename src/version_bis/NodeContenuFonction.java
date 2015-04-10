package fr.ul.miage.projet;
 
import java.util.HashMap;
 
public class NodeContenuFonction {
 
        private String id;
        private int nb_var_loc;
       
        public NodeContenuFonction(String i, int n){
                id=i;
                nb_var_loc=n;
        }
 
        public String getId() {
                return id;
        }
 
        public void setId(String id) {
                this.id = id;
        }
 
        public int getNb_var_loc() {
                return nb_var_loc;
        }
 
        public void setNb_var_loc(int nb_var_loc) {
                this.nb_var_loc = nb_var_loc;
        }
       
        public String toString(){
        	return(id+" "+nb_var_loc);
        }
       
}
package fr.ul.miage.projet;
import java.util.ArrayList;
import java.util.HashMap;
 
 
 
public class TDS{
 
        private HashMap<Double,Element> table;
 
        public TDS(){
                table = new HashMap<Double,Element>();
        }
 
        public double idUnique(String id,String categorie, String portee,String type){
                String concat = id+categorie+portee+type;
                double somme_ASCII=0;
                String concat_ASCII="";
 
                for(int j=0;j<concat.length();j++){
                        concat_ASCII = concat_ASCII + (int)concat.charAt(j);
                }
                somme_ASCII = Double.parseDouble(concat_ASCII);
 
                return (somme_ASCII);
        }
 
        public Element search(String id,String categorie, String portee,String type){
                Element el = null;
                double cle = idUnique(id,categorie,portee,type);
                if(table.containsKey(cle)){
                        el = table.get(cle);
                }
 
                return el;
        }
 
        public boolean searchB(String id,String categorie, String portee,String type){
                boolean retour = false;
                double cle = idUnique(id,categorie,portee,type);
                if(table.containsKey(cle)){
                        retour = true;
                }
 
                return retour;
        }
 
        public void insert(Element e) throws MonException{
                if(!searchB(e.getId(),e.getCategorie(),e.getPortee(),e.getType())){
                        double cle = e.idUnique();
                        table.put(cle, e);
                }else{
                		throw new MonException("erreur : double définition");
                }
        }
 
        public void display(){
                for(double cle : table.keySet()){
            		System.out.println(table.get(cle).toString());
                }
        }
 
        public ArrayList<Element> getGlobalVars(){
                ArrayList<Element> list = new ArrayList();
                Element elt;
                for (double cle : table.keySet()) {
                        elt = table.get(cle);
                        if(elt.getCategorie() == "variable" && elt.getPortee() == "globale"){
                                list.add(elt);
                        }
                }
                return list;
 
        }
}
package fr.ul.miage.projet;

public class Element {

	private String id;

	//variable ou fonction ou parametre ou main
	private String categorie;

	// globale ou nom de la fonction correspondant à la var ou au param
	private String portee;

	//nb param si type = fonction
	private int nbParam;

	//nb var locales si type = fonction
	private int nbVarLoc;

	//type, int ou void(seulement pour les fonctions)
	private String type;

	//valeur associée à la variable
	private int valeur;

	//
	private int indiceVar;


	//constructeur pour un élément variable
	public Element(String i, String c, String p, String t, int val,int ind){
		id=i;
		type=t;
		portee=p;
		nbParam=0;
		nbVarLoc=0;
		categorie = c;
		valeur = val;
		indiceVar=ind;
	}

	//constructeur pour un élément paramètre
	public Element(String i, String c, String p, String t,int ind){
		id=i;
		type=t;
		portee=p;
		nbParam=0;
		nbVarLoc=0;
		categorie = c;
		indiceVar=ind;

	}

	//constructeur pour un élément fonction
	public Element(String i, String c, String p,int nbp, int nbv, String t){
		id=i;
		type=t; 
		portee=p; 
		nbParam=nbp; 
		nbVarLoc=nbv;
		categorie = c;

	}


	public double idUnique(){
		String concat = id+categorie+portee+type;
		double somme_ASCII=0;
		String concat_ASCII="";

		for(int j=0;j<concat.length();j++){
			concat_ASCII = concat_ASCII + (int)concat.charAt(j);
		}
		somme_ASCII = Double.parseDouble(concat_ASCII);

		return (somme_ASCII);
	}

	public int id(){


		return (hashCode());
	}


	public String toString(){
		String s="";
		if(categorie.compareTo("fonction")==0 || categorie.compareTo("main")==0){
			s = "clé : "+idUnique()+" "+id+" de catégorie : "+categorie+" de portee : "+portee+" de type : "+type+" nombre de parametres : "+nbParam+" nombre de variables locales : "+nbVarLoc;
		}else if(categorie.compareTo("parametre")==0){
			s = "clé : "+idUnique()+" "+id+" de catégorie : "+categorie+" de portee : "+portee+" de type : "+type+" valeur associée : "+valeur+" indice du paramètre : "+indiceVar;
		}else{
			s = "clé : "+idUnique()+" "+id+" de catégorie : "+categorie+" de portee : "+portee+" de type : "+type+" valeur associée : "+valeur+" indice de la variable : "+indiceVar;
		}	
			return s;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCategorie() {
			return categorie;
		}

		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}

		public String getPortee() {
			return portee;
		}

		public void setPortee(String portee) {
			this.portee = portee;
		}

		public int getNbParam() {
			return nbParam;
		}

		public void setNbParam(int nbParam) {
			this.nbParam = nbParam;
		}

		public int getNbVarLoc() {
			return nbVarLoc;
		}

		public void setNbVarLoc(int nbVarLoc) {
			this.nbVarLoc = nbVarLoc;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getValeur() {
			return valeur;
		}

		public void setValeur(int valeur) {
			this.valeur = valeur;
		}

		public int getIndiceVar() {
			return indiceVar;
		}

		public void setIndiceVar(int indiceVar) {
			this.indiceVar = indiceVar;
		}

		


	}
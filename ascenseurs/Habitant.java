package fr.univ.jalift.ascenseur;
import java.util.ArrayList;
import java.util.List;
    /* Chaque habitant possède :
    Un étage de résidence,
    Des habitudes quotidiennes (heures de départ/retour),
    Une vitesse de déplacement à pied (escaliers).
    Les habitants peuvent :
    Quitter la tour (travail),
    Revenir,
    Rendre visite à d’autres habitants (relations d’amitié).
 
*/ 
    
   public class Habitant {
        private String nom;
        //private int floorbuilding;
        private int etageResidence;
        private int actualfloor;
        private int destination;
        private List<String> nomAmis; // pour fichier JSON
        private List<Habitant> amis;//pour la simulation//
        private List<VisiteData> visite;


       // habitudes
        private int leavinghour;
        private int cominghour;

        private int vitessepied;  // étages/minute


        public Habitant(String nom, int etageResidence, int leaving, int comingback, int vitesse) {
            this.nom = nom;
            this.leavinghour = leaving;
            this.cominghour = comingback;
            this.vitessepied = vitesse;
            this.destination = etageResidence; //par defaut
            //this.floorbuilding = etageResidence;
            this.etageResidence = etageResidence;
            this.nomAmis = new ArrayList<>();
            this.amis = new ArrayList<>();
            this.visite = new ArrayList<>();
    }
        public void leavingTour(){
              actualfloor=0;
        }
        public void comingback() {
            actualfloor = etageResidence;
        }

        public void visiter(Habitant ami) {
            actualfloor= ami.etageResidence;
        }
        public int getEtageResidence() {
        return etageResidence;
        }

        public void addAmis(Habitant ami) {
            amis.add(ami);
        }
        public void setVisite(List <VisiteData> visites) {
            this.visite=visites;
        }
        public void setRelationAmitie(List<String> relations) {
            this.nomAmis = relations;
        }
        public List<String> getNomAmis() {
            return nomAmis;
        }
        public String getNom() {
            return nom;
        }
        public List<Habitant> getAmis() {
            return amis;
        }
        public void setDestination(int etage) {
            this.destination = etage;
        }
        public int getDestination() {
            return destination;
        }
}
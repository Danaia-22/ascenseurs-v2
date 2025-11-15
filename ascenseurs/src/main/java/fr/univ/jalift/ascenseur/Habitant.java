package fr.univ.jalift.ascenseur;




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
    private int floorbuilding;
    private int etageResidence;
    private int actualfloor;

    // habitudes
    private int leavinghour;
    private int cominghour;

    private int vitessepied;  // étages/minute


    public Habitant(String nom, int etageResidence, int leaving, int comingback, int vitesse) {
        this.nom = nom;
        this.leavinghour = leaving;
        this.cominghour = comingback;
        this.vitessepied = vitesse;
        this.floorbuilding = etageResidence;
        this.etageResidence = etageResidence;
    }
    public void leavingTour(){
          actualfloor=0;
    }
    public void comingback() {
        actualfloor = floorbuilding;
    }

    public void visiter(Habitant ami) {
        actualfloor= ami.etageResidence;
    }
    public int getEtageResidence() {
    return etageResidence;
    }
}
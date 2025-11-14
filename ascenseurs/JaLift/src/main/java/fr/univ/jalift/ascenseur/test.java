package fr.univ.jalift.ascenseur;

public class test {
    public static void main(String[] args){

        Ascenseur asc1=new Ascenseur(1,9,4);
        //asc1.afficherEtat();
        //asc1.monter();
        asc1.deplacer(5);
        //System.out.println("L'ascenseur est monté à l'étage: "+asc1.getEtageActuel());
        asc1.embarquer("Alice");
        asc1.debarquer("bob");
    }
}

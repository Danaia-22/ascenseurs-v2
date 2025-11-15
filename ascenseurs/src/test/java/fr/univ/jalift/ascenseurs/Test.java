package fr.univ.jalift.ascenseurs;

import fr.univ.jalift.ascenseur.Ascenseur;
import fr.univ.jalift.ascenseur.ConfigData;
import fr.univ.jalift.ascenseur.ConfigLoader;
import fr.univ.jalift.ascenseur.HabitantData;
import fr.univ.jalift.ascenseur.VisiteData;

public class Test{
    public static void main(String[] args){

        Ascenseur asc1=new Ascenseur(1,9,4);
        //asc1.afficherEtat();
        //asc1.monter();
        asc1.deplacer(5);
        //System.out.println("L'ascenseur est monté à l'étage: "+asc1.getEtageActuel());
        asc1.embarquer("Awa");
        asc1.debarquer("Thilleli");
        //Partie Danaia pour tester les classes
         ConfigData data = ConfigLoader.load("config.json");

        if (data == null) {
            System.out.println("Erreur : impossible de charger config.json");
            return;
        }

        System.out.println(" TOUR ");
        System.out.println("Nombre d'étages : " + data.etages);

        System.out.println("\n HABITANTS ");

        for (HabitantData h : data.habitants) {
            System.out.println("\nHabitant : " + h.nom);
            System.out.println(" - Étage : " + h.etage);
            System.out.println(" - Départ : " + h.depart + "h");
            System.out.println(" - Retour : " + h.retour + "h");
            System.out.println(" - Vitesse : " + h.vitesse);

            // Relations d’amitié
            if (h.relations_amitie != null) {
                System.out.println(" - Amis : " + h.relations_amitie);
            }

            // Visites
            if (h.visites != null) {
                System.out.println(" - Visites prévues : ");
                for (VisiteData v : h.visites) {
                    System.out.println("    * Chez : " + v.ami +
                                       " | Jour : " + v.jour +
                                       " | Arrivée : " + v.arrivee +
                                       "h | Départ : " + v.depart + "h");
                }
            }
        }

        System.out.println("\nFIN DU TEST ");
    }
}

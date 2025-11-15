package fr.univ.jalift.ascenseur;

public class Main {
    public static void main(String[] args) {
        System.out.println("ascene urs");

         // Charge la configuration JSON
        ConfigData config = ConfigLoader.load("config.json");

        //  Créer le building avec le nombre d'étages
        Building building = new Building(config.etages);

        // Créer les habitants et leurs parametres et les ajouter
        for (HabitantData hd : config.habitants) {
            Habitant h = new Habitant(
                hd.nom,
                hd.etage,
                hd.depart,
                hd.retour,
                hd.vitesse
            );

            building.addHabitant(h);
        }

        System.out.println("Configuration chargée !");
    }
    }


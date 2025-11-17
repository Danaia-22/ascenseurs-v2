package fr.univ.jalift.ascenseur;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args){
        System.out.println("-----Configuration-----");
        ConfigData config = ConfigLoader.load("config.json"); //charger JSON
        if(config == null)return;
        // Création du building avec le nombre d'étages
        Building building = new Building(config.etages);
        //Creation des habitants
        Map<String,Habitant> habitantMap = new HashMap<>();
        for (HabitantData hd: config.habitants){
            Habitant h = new Habitant(
                    hd.nom,
                    hd.etage,
                    hd.depart,
                    hd.retour,
                    hd.vitesse
            );
            h.setRelationAmitie(hd.relations_amitie);// on stocke la liste des noms d’amis dans l’objet Habitant
            h.setVisite(hd.visites);

            building.addHabitant(h);//Ajouter l'habitant dans l étage où il habite
            habitantMap.put(h.getNom(),h);//transformer les noms en objet Habitant
        }

        //Lier les amis
        for (HabitantData hd: config.habitants) {
            Habitant h = habitantMap.get(hd.nom); //Récupérer l habitant objet
            if(hd.relations_amitie != null){
                for(String nomAmi: hd.relations_amitie){
                    Habitant ami=habitantMap.get(nomAmi);
                    if(ami!=null){
                        h.addAmis(ami); //Ajouter l'ami dans la liste des amis de l'habitant
                    }
                }
            }

        }
        System.out.println("Habitants: " + habitantMap.keySet());

        //Afficher les amitiés
        for(Habitant h: habitantMap.values()){
            System.out.println("Habitant: " + h.getNom());

            System.out.print("Amis: ");
            if(h.getAmis()!=null){
                for(Habitant ami: h.getAmis()){

                    System.out.print(ami.getNom()+" ");
                }
                System.out.println();
            }else{
                System.out.println("Aucun ami");
            }
        }


        Ascenseur asc1=new Ascenseur(1,9,4);
        //asc1.afficherEtat();
        //asc1.monter();
        //asc1.deplacer(5);

        //System.out.println("L'ascenseur est monté à l'étage: "+asc1.getEtageActuel());
        //asc1.embarquer("Alice");
        //asc1.debarquer("bob");
        Heuristique H3=new plusProche();

        asc1.appelerAscenseur(3);
        asc1.appelerAscenseur(7);
        asc1.appelerAscenseur(4);
        asc1.appelerAscenseur(1);

        for(int i=0; i<22 ; i++){
            H3.executer(asc1);
            System.out.println("etape:"+i+" etage:"+ asc1.getEtageActuel()+" direction:"+asc1.getDirection());
        }
    }
}

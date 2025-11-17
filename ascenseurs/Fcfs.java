package fr.univ.jalift.ascenseur;

import java.util.ArrayList;
import java.util.List;

public class Fcfs extends Heuristique{
    @Override
    public void executer(Ascenseur ascenseur){
        if(ascenseur.getDemandes().isEmpty()){
            System.out.println("Il n'y a pas de demandes");
            ascenseur.setDirection(Directions.ARRET);
            return;
        }
        else{
            int demande= ascenseur.getDemandes().get(0);
            if(ascenseur.getEtageActuel()==demande){
                //Debarquement
                for(Habitant h: new ArrayList<>(ascenseur.getPassagers())){
                    if(h.getDestination() == demande){
                        ascenseur.debarquer(h);
                    }
                }
                //Embarquement
                List<Habitant> file= ascenseur.getFileAttente(demande);
                for(Habitant h: new ArrayList<>(file)){
                    ascenseur.embarquer(h);
                    if(ascenseur.getPassagers().contains(h)){
                        file.remove(h);
                    }
                }
                ascenseur.getDemandes().remove(Integer.valueOf(demande));// On supprime la valeur correspondant à la 1ere demande
                if(ascenseur.getDemandes().isEmpty()){
                    ascenseur.setDirection(Directions.ARRET);
                    //return;
                }
                //return;
            }

            else if(ascenseur.getEtageActuel()< demande){
                ascenseur.setDirection(Directions.MONTEE);
                ascenseur.monter();
            }
            else{
                ascenseur.setDirection(Directions.DESCENTE);
                ascenseur.descendre();
            }
        }
    }
}


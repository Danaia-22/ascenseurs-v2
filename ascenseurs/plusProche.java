package fr.univ.jalift.ascenseur;

public class plusProche extends Heuristique {
    @Override
    public void executer(Ascenseur ascenseur){
        if(ascenseur.getDemandes().isEmpty()){
            System.out.println("Il n'y a pas de demandes");
            ascenseur.setDirection(Directions.ARRET);
            return;
        }
        else {
            int demandeProche=-1; //Initialisation à une valeur qui signifie que rien n'est trouvé au début
            int distanceMin= Integer.MAX_VALUE;

            for (int d : ascenseur.getDemandes()) {
                int distance = Math.abs( d - ascenseur.getEtageActuel());
                if(distance<distanceMin){
                    distanceMin=distance;
                    demandeProche=d;
                }
            }

            if(ascenseur.getEtageActuel() < demandeProche){
                ascenseur.setDirection(Directions.MONTEE);
                ascenseur.monter();
            } else if (ascenseur.getEtageActuel() > demandeProche) {
                ascenseur.setDirection(Directions.DESCENTE);
                ascenseur.descendre();
            } else {
                ascenseur.setDirection(Directions.ARRET);
                ascenseur.getDemandes().remove(Integer.valueOf(demandeProche));
                return;
            }

        }}
}

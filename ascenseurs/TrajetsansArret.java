package fr.univ.jalift.ascenseur;

public class TrajetsansArret extends Heuristique {
    @Override
    public void executer(Ascenseur ascenseur) {
        if (ascenseur.getDirection() == Directions.ARRET) {
            if (ascenseur.getEtageActuel() == 0) {
                ascenseur.setDirection(Directions.MONTEE);
            } else if (ascenseur.getEtageActuel() == ascenseur.getEtageMax()) {
                ascenseur.setDirection(Directions.DESCENTE);
            } else {
                ascenseur.setDirection(Directions.MONTEE);//par defaut

            }
            return;
        } else if (ascenseur.getDirection() == Directions.MONTEE) {
            if (ascenseur.getEtageActuel() != ascenseur.getEtageMax()) {
                ascenseur.monter();
                return;
            } else {
                ascenseur.setDirection(Directions.DESCENTE);
            }
        } else {
            if (ascenseur.getEtageActuel() != 0) {
                ascenseur.descendre();
                return;
            } else {
                ascenseur.setDirection(Directions.MONTEE);
            }

        }
    }
}


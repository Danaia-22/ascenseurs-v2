package fr.univ.jalift.ascenseur;

import java.util.*;

/**
 * Ce code représente la structure de l'ascenseur
 * @author AKLI Thilleli
 */
public class Ascenseur {
    private int id;
    private int etageActuel;
    private int etageMax;
    private int capaciteMax;
    private List<Habitant> passagers;
    private Directions direction;
    private List<Integer> demandes;
    private List<Integer> destinations;
    private double vitesseMax;
    private double acceleration;
    private double deceleration;
    private double tempsArret;
    private double energie;
    private Map<Integer, List<Habitant>> file;

    //Constructeur
    public Ascenseur(int id, int etageMax, int capaciteMax) {
        this.id = id;
        this.etageActuel = 0;
        this.etageMax = etageMax;
        //this.etageDestination= etageDestination;
        this.capaciteMax = capaciteMax;
        this.passagers = new ArrayList<>();
        this.direction = Directions.ARRET;
        this.demandes = new ArrayList<>();
        this.destinations = new ArrayList<>();
        this.file= new HashMap<>();

    }

    public void afficherEtat() {
        System.out.println("L'ascenseur " + id + " est à l'étage " + etageActuel);
    }

    public void monter() {
        if (etageActuel < etageMax) {
            etageActuel = etageActuel + 1;
        } else {
            System.out.println("On est déjà au dernier étage");
        }
    }

    public void descendre() {
        if (etageActuel > 0) {
            etageActuel = etageActuel - 1;
        } else {
            System.out.println("On est déjà au rez-de-chaussé");
        }
    }

    public void deplacer(int etageDestination) {
        if (etageActuel < 0 || etageDestination > etageMax) {
            System.out.println("L'étage demandé est invalide!");
            return;
        }
        if(etageDestination > etageActuel){
            direction=Directions.MONTEE;
        }else if(etageDestination < etageActuel){
            direction=Directions.DESCENTE;
        }else {
            direction=Directions.ARRET;
        }

        while (etageActuel != etageDestination) {
            if (direction == Directions.MONTEE) {
                monter();
            } else if (direction == Directions.DESCENTE) {
                descendre();
            }
            System.out.println("Etage actuel: " + etageActuel);
        }

        direction=Directions.ARRET;
        System.out.println("Arrivé à: " + etageDestination);
    }

    public void embarquer(Habitant h) {

        if (passagers.contains(h)) {
            System.out.println(h.getNom() + " est déjà dans l'ascenseur");
        } else if (passagers.size() < capaciteMax) {
            passagers.add(h);
            if(!destinations.contains(h.getDestination())) {
                destinations.add(h.getDestination());
            }
            System.out.println("Le passager " + h.getNom() + " a embarqué dans l'ascenseur");

        } else {
            System.out.println("L'ascenseur est plein " + h.getNom() + " doit attendre");
            return;
        }
    }

    public boolean vide() {
        return passagers.isEmpty();
    }

    public void debarquer(Habitant h) {
        if (vide()) {
            System.out.println("L'ascenseur est vide");
            return;
        } else if (!passagers.contains(h)) {
            System.out.println(h.getNom() + " n'est pas dans l'ascenseur");
            return;
        } else {
            passagers.remove(h);

            System.out.println("Le passager " + h.getNom()+ " a débarqué de l'ascenseur");

            boolean etagedouble = false;
            for (Habitant habitant : passagers) {
                if(habitant.getDestination()==h.getDestination()){
                    etagedouble = true;
                    break;
                }
            }
            if (!etagedouble) {
                destinations.remove(Integer.valueOf(h.getDestination()));
            }

        }
    }

    public boolean arreter(){
        return demandes.contains(etageActuel) || destinations.contains(etageActuel);
    }

    //------------------------------------------------ Appels----------------------------------------------------------

    public void appelerAscenseur(int demande) {
        if (demande < 0 || demande > etageMax) {
            System.out.println("L'étage est invalide");
        } else if (demandes.contains(demande)) {
            System.out.println("L'appel de l'ascenseur est déjà fait");
        } else  {
            demandes.add(demande);
            System.out.println("L'appel de l'ascenseur est enregistré");
        }
    }

    public void appelAscenseur(Habitant h, int etageAppel) {
        file.get(etageAppel).add(h);
        if(!demandes.contains(etageAppel)){
            demandes.add(etageAppel);
        }
    }
    //------------------------------------------------ Getters & setters (heuristiques)----------------------------------------------------------
    public int getEtageActuel(){
        return etageActuel;
    }
    public int getEtageMax(){
        return etageMax;
    }
    public List<Habitant> getPassagers(){
        return passagers;
    }
    public Directions getDirection(){
        return direction;
    }
    public List<Integer> getDestination(){
        return destinations;
    }

    public List<Integer> getDemandes(){
        return demandes;
    }
    public List<Habitant> getFileAttente(int etage){
        return file.computeIfAbsent(etage, k-> new ArrayList<>()); // si la clé etage existe dans la map sinon crée une nouvelle liste
    }

    public void setDirection(Directions d){
        this.direction = d;
    }

    public void addDestination(int etage){
        if(!destinations.contains(etage)){
            destinations.add(etage);
        }
    }

    public void addFileAttente(int etage, Habitant h){
        getFileAttente(etage).add(h);
    }



}
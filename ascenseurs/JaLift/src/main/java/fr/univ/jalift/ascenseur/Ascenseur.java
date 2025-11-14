package fr.univ.jalift.ascenseur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ce code représente la structure de l'ascenseur
 * @author AKLI Thilleli
 */
public class Ascenseur {
    private int  id;
    private int etageActuel;
    private int etageMax;
    private int etageDestination;
    private int capaciteMax;
    private List<String> passagers;
    private boolean mouvement;

    //Constructeur
    public Ascenseur(int id,int etageMax, int capaciteMax){
        this.id = id;
        this.etageActuel = 0;
        this.etageMax = etageMax;
        //this.etageDestination= etageDestination;
        this.capaciteMax = capaciteMax;
        this.passagers = new ArrayList<>();
        this.mouvement = false;
    }

    public void afficherEtat(){
        System.out.println("L'ascenseur "+id+ " est à l'étage "+etageActuel);
    }

    public void monter(){
        if(etageActuel < etageMax){
            etageActuel=etageActuel+1;
        }
        else{
            System.out.println("On est déjà au dernier étage");
        }
    }
    public void descendre(){
        if(etageActuel > 0){
            etageActuel=etageActuel-1;
        }
        else{
            System.out.println("On est déjà au rez-de-chaussé");
        }
    }
    public void deplacer(int etageDestination){
        if(etageActuel<0 || etageDestination> etageMax){
            System.out.println("L'étage demandé est invalide!");
            return;
        }

        while(etageActuel != etageDestination){
            if(etageActuel < etageDestination){
                monter();
            }
            else{
                descendre();
            }
            System.out.println("Etage actuel: "+etageActuel);
        }

        System.out.println("Arrivé à: "+etageDestination);
    }

    public void embarquer(String NomPassager){

        if(passagers.contains(NomPassager)){
        System.out.println(NomPassager+" est déjà dans l'ascenseur");
        }
        else if(passagers.size() < capaciteMax){
            passagers.add(NomPassager);
            System.out.println("Le passager "+NomPassager+" a embarqué dans l'ascenseur");
        }else{
            System.out.println("L'ascenseur est plein "+NomPassager+" doit attendre");
        }
    }
    public boolean vide(){
        return passagers.isEmpty();
    }
    public void debarquer(String NomPassager){
        if (vide()){
            System.out.println("L'ascenseur est vide");
        }
        else if(!passagers.contains(NomPassager)){
            System.out.println(NomPassager+" n'est pas dans l'ascenseur");
        }
        else{
            passagers.remove(NomPassager);
            System.out.println("Le passager "+NomPassager+" a débarqué de l'ascenseur");
        }
    }

    //public int getEtageActuel(){
    //    return etageActuel;
    //}


}

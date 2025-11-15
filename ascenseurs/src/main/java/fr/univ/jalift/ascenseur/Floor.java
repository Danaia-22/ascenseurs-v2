package fr.univ.jalift.ascenseur;
import java.util.List;
import java.util.ArrayList;


 public class Floor {
    private List<Habitant> residents = new ArrayList<>();
    private int number;

    Floor(int number) {
        this.number = number;
    }

    void addResident(Habitant x) {
        residents.add(x);
    }

    List<Habitant> getResidents() {
        return residents;
    }
}

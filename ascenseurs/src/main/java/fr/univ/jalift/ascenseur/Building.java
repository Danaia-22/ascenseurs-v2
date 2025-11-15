package fr.univ.jalift.ascenseur;
import java.util.List;
import java.util.ArrayList;


public class Building {
    private List<Floor> floors = new ArrayList<>();

    Building(int n) {
        for (int i = 0; i <= n; i++) {
            floors.add(new Floor(i));
        }
    }

    void addHabitant(Habitant h) {
        floors.get(h.getEtageResidence()).addResident(h);
    }
}

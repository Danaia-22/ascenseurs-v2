package fr.univ.jalift.ascenseur;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class ConfigLoader {

    public static ConfigData load(String fileName) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));
            Gson gson = new Gson();
            return gson.fromJson(json, ConfigData.class);

        } catch (IOException e) {
            System.out.println("Erreur de lecture du config.json");
            return null;
        }
    }
}


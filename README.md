  C'est une deuxieme version, une version à partir de mon code et Thilleli;
  pour voir les classes faut aller dans src->main/java/fr/univ/etc...
  
  vous pouvez l'ouvrir sur codespace et le compiler sur terminal avec:
  javac -cp "lib/gson-2.10.1.jar" -d target/classes $(find src/main/java -name "*.java")
java -cp "target/classes:lib/gson-2.10.1.jar" fr.univ.jalift.ascenseur.Main

Ensuite pour tester la classe test :
java -cp "target/classes:lib/gson-2.10.1.jar" fr.univ.jalift.ascenseurs.Test
RESULTAT ATTENDU POUR test:java -cp "target/classes:lib/gson-2.10.1.jar" fr.univ.jalift.ascenseurs.Test
Etage actuel: 1
Etage actuel: 2
Etage actuel: 3
Etage actuel: 4
Etage actuel: 5
Arrivé à: 5
Le passager Awa a embarqué dans l'ascenseur
Thilleli n'est pas dans l'ascenseur
 TOUR 
Nombre d'étages : 5

 HABITANTS 

Habitant : Thilleli
 - Étage : 2
 - Départ : 8h
 - Retour : 17h
 - Vitesse : 2
 - Amis : [Awa]
 - Visites prévues : 
    * Chez : Awa | Jour : mercredi | Arrivée : 19h | Départ : 22h

Habitant : Awa
 - Étage : 4
 - Départ : 7h
 - Retour : 18h
 - Vitesse : 3
 - Amis : [Thilleli]

3 classes pour pouvoir ajouter un fichier (config.json )avec les habitudes et parametres des habitants, toutes les classes qui se terminent par Data c est pour le fonctionnement de ce fichier.
C'est mieux de le tester sur codespace parce q j ai deja installer GSON.jar(vous pouvez le trouver dans lib)
C'est pas fini non plus je dois revoir mais en gros ca repond aux attentes 

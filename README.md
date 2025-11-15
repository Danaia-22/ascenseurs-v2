  C'est une deuxieme version, une version à partir de mon code et Thilleli;
  pour voir les classes faut aller dans src->main/java/fr/univ/etc...
  vous pouvez l'ouvrir sur codespace et le compiler sur terminal avec:javac -cp "lib/gson-2.10.1.jar" -d target/classes $(find src/main/java -name "*.java")
java -cp "target/classes:lib/gson-2.10.1.jar" fr.univ.jalift.ascenseur.Main
Ensuite pour tester la classe test :java -cp "target/classes:lib/gson-2.10.1.jar" fr.univ.jalift.ascenseurs.Test
3 classes pour pouvoir ajouter un fichier (config.json )avec les habitudes et parametres des habitants, toutes les classes qui se terminent par Data c est pour le fonctionnement de ce fichier.
C'est mieux de le tester sur codespace parce q j ai deja installer GSON.jar(vous pouvez le trouver dans lib)
C'est pas fini non plus je dois revoir mais en gros ca repond aux attentes 

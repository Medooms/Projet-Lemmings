import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int largeur = 30;
        int hauteur = 20;
        int entreeX = 0;
        int entreeY = 4;

        Jeu jeu = new Jeu(hauteur, largeur, entreeX, entreeY, 20, 4);

        // Ajout d'une ligne d'obstacles entre l'entrée et la sortie
        for (int x = 0; x < largeur; x++) {
            jeu.GetTerrain().AjouterObstacleIndestructible(x, 3);
        }

        // Ajout de lave sur la première ligne
        jeu.GetTerrain().AjouterLigneLave(0);

        jeu.GetTerrain().AjouterObstacleIndestructible(3, 4);
        jeu.GetTerrain().AjouterObstacleIndestructible(4, 5);
        jeu.GetTerrain().AjouterObstacleIndestructible(5, 6);
        jeu.GetTerrain().AjouterObstacleIndestructible(6, 7);
        
        // Création d'un mur pour tester la collision (On pourra enlever après pour continuer le test) :

        //jeu.GetTerrain().AjouterObstacleIndestructible(9, 4);
        //jeu.GetTerrain().AjouterObstacleIndestructible(9, 5);

        // Création d'un trou pour tester la fonctionnalité de mort avec la lave (On pourra enlever après pour continuer le test) :

        //jeu.GetTerrain().DestructionObstacle(10, 3);

        // Fenêtre d'affichage
        JFrame fenetre = new JFrame("Jeu des Poussins");
        Graphique graphique = new Graphique(jeu);
        fenetre.add(graphique);
        fenetre.pack();
        
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

        final int[] compteurTours = {0}; 
        int poussinsMax = 5; 

        // Simulation du jeu
        Timer timer = new Timer(250, e -> {
            compteurTours[0]++; // Incrémenter le compteur de tours
            
            // Ajouter un poussin seulement tous les 3 tours
            if (compteurTours[0] % 3 == 0 && compteurTours[0] / 3 <= poussinsMax) {
                jeu.AjouterPoussin(new Poussin(entreeX, entreeY, "droite"));
            }

            // Jouer un tour de jeu (déplacer les poussins, vérifier les sorties, etc.)
            jeu.JouerTour();
            graphique.rafraichir();
        });
        timer.start();
    }
}
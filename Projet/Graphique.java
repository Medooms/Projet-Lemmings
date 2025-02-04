import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Graphique extends JPanel {
    private Jeu jeu;
    private static final int TAILLE_CASE = 30;

    public Graphique(Jeu jeu) {
        this.jeu = jeu;
        setPreferredSize(new Dimension(jeu.GetTerrain().GetLargeur() * TAILLE_CASE, jeu.GetTerrain().GetHauteur() * TAILLE_CASE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Affichage du terrain
        for (int x = 0; x < jeu.GetTerrain().GetLargeur(); x++) {
            for (int y = 0; y < jeu.GetTerrain().GetHauteur(); y++) {
                int typeCase = jeu.GetTerrain().GetTypeCase(x, y);
                switch (typeCase) {
                    case 0: g.setColor(Color.BLUE); break;           // Vide
                    case 1: g.setColor(Color.ORANGE); break;          // Obstacle destructible
                    case 2: g.setColor(Color.GRAY); break;            // Obstacle indestructible
                    case 3: g.setColor(Color.RED); break;             // Lave
                    case 4: g.setColor(Color.GREEN); break;           // Entrée
                    case 5: g.setColor(Color.BLACK); break;            // Sortie
                }
                g.fillRect(x * TAILLE_CASE, (jeu.GetTerrain().GetHauteur() - y - 1) * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
            }
        }

        // Affichage des poussins
        ArrayList<Poussin> poussins = jeu.GetPoussins();
        for (Poussin poussin : poussins) {
            if (poussin.EstEnVie()) {
                g.setColor(Color.YELLOW);
                g.fillOval(poussin.GetX() * TAILLE_CASE, (jeu.GetTerrain().GetHauteur() - poussin.GetY() - 1) * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Poussins entrés : " + jeu.GetPoussinsEntrer(), 10, 20);
        g.drawString("Poussins morts : " + jeu.GetPoussinsMorts(), 10, 40);
    }

    public void rafraichir() {
        repaint();
    }
}

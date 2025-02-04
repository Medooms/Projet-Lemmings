import java.util.ArrayList;

public class Jeu {
    private TerrainJeu terrain;
    private ArrayList<Poussin> poussins;
    private int PoussinsEntrer;
    private int PoussinsMorts;
    private int entreeX, entreeY;
    private int sortieX, sortieY;

    public Jeu(int largeur, int hauteur, int entreeX, int entreeY, int sortieX, int sortieY) {
        this.terrain = new TerrainJeu(largeur, hauteur);
        this.poussins = new ArrayList<>();
        this.PoussinsEntrer = 0;
        this.PoussinsMorts = 0;
        this.entreeX = entreeX;
        this.entreeY = entreeY;
        this.sortieX = sortieX;
        this.sortieY = sortieY;

        terrain.AjouterEntree(entreeX, entreeY);
        terrain.AjouterSortie(sortieX, sortieY);
    }
    public void AjouterPoussin(Poussin poussin) {
        poussins.add(poussin);
    }
    public TerrainJeu GetTerrain() {
        return terrain;
    }
    public int GetPoussinsEntrer() {
        return PoussinsEntrer;
    }

    public int GetPoussinsMorts() {
        return PoussinsMorts;
    }
    public ArrayList<Poussin> GetPoussins() {
        return poussins;
    }
    public void JouerTour() {
        ArrayList<Poussin> poussinsRestants = new ArrayList<>();
        // Déplacer les poussins existants
        for (Poussin poussin : poussins) {
            poussin.deplacer(terrain);
    
            // Vérifier si le poussin est arrivé à la sortie
            if (poussin.GetX() + 1 == sortieX && poussin.GetY() == sortieY) {
                PoussinsEntrer++;  // Compte les poussins arrivés
            } else if (!poussin.EstEnVie()) {
                PoussinsMorts++;  // Compte les poussins morts
            } else {
                poussinsRestants.add(poussin);  // Garde les poussins encore actifs
            }
        }
    
        // Mettre à jour la liste des poussins actifs
        poussins = poussinsRestants;
    }
    
}

public class TerrainJeu {
    private final int[][] Terrain;
    private final int Hauteur;
    private final int Largeur;

    public TerrainJeu(int hauteur, int largeur) {
        this.Hauteur = hauteur;
        this.Largeur = largeur;
        this.Terrain = new int[Largeur][Hauteur];
    }

    // Vérifie si une case est vide (0 = vide)
    public boolean EstVide(int x, int y) {
        if (x < 0 || x >= Largeur || y < 0 || y >= Hauteur) {
            return false; // Hors des limites
        } else if (Terrain[x][y] != 0) {
            return false; // La case n'est pas vide
        } else {
            return true; // La case est forcément vide
        }
    }
    // Détruit un obstacle (0)
    public void DestructionObstacle(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            Terrain[x][y] = 0; // On vérifie si les valeurs sont dans les dimensions du terrain
        }
    }

    // Ajoute un obstacle destructible (1)
    public void AjouterObstacleDestructible(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            Terrain[x][y] = 1; // On vérifie si les valeurs sont dans les dimensions du terrain
        }
    }

    // Ajoute un obstacle indestructible (2)
    public void AjouterObstacleIndestructible(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            Terrain[x][y] = 2; // On vérifie si les valeurs sont dans les dimensions du terrain
        }
    }

    // Obtenir le type de case à une position donnée (0 = vide, 1 = destructible, 2 = indestructible)
    public int GetTypeCase(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            return Terrain[x][y];
        }
        return -1; // Si hors des limites, retourne -1
    }

    // Ajoute une ligne de lave (3)
    public void AjouterLigneLave(int y) {
        if (y >= 0 && y < Hauteur) {
            for (int x = 0; x < Largeur; x++) {
                Terrain[x][y] = 3; // Remplit la ligne entière avec de la lave
            }
        }
    }
    public void AjouterEntree(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            Terrain[x][y] = 4; // Case d'entrée
        }
    }

    public void AjouterSortie(int x, int y) {
        if (x >= 0 && x < Largeur && y >= 0 && y < Hauteur) {
            Terrain[x][y] = 5; // Case de sortie
        }
    }

    public int GetLargeur() {
        return Largeur;
    }

    public int GetHauteur() {
        return Hauteur;
    }
}

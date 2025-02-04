public class Poussin {
    private int X, Y;
    private String Direction; // Gauche ou Droite
    private boolean EnVie;

    public Poussin(int x, int y, String direction) {
        this.X = x;
        this.Y = y;
        this.Direction = direction;
        this.EnVie = true;
    }

    public boolean EstEnVie() {
        return EnVie;
    }

    public int GetX() {
        return X;
    }

    public int GetY() {
        return Y;
    }

    public void deplacer(TerrainJeu terrain) {
        if (!EnVie)
            return;

        int chute = 0; // Variable pour compter la chute

        // Si rien sous le poussin (case vide, représentée par 0), il tombe
        while (terrain.GetTypeCase(X, Y - 1) == 0) {
            Y--;
            chute++; // Compte combien de cases il tombe
            if (chute > 5) {
                EnVie = false; // Meurt si la chute est trop haute
                return;
            }
        }

        // Avance dans la direction actuelle si le poussin est toujours en vie
        if (Direction.equals("droite")) {
            if (terrain.GetTypeCase(X + 1, Y) == 2 && terrain.GetTypeCase(X + 1, Y + 1) == 2) {
                Direction = "gauche"; // Change de direction si obstacle
            } else {
                if (terrain.GetTypeCase(X + 1, Y) == 0) {
                    X++;
                } else if (terrain.GetTypeCase(X + 1, Y) != 0 && terrain.GetTypeCase(X + 1, Y + 1) == 0) {
                    Y++;
                    X++;
                }
            }
        } else if (Direction.equals("gauche")) {
            if (terrain.GetTypeCase(X - 1, Y) == 0) {
                X--;
            } else {
                Direction = "droite";
            }
        }

        if (terrain.GetTypeCase(X, Y - 1) == 3) { // Case 3 = lave
            EnVie = false; // Meurt dans la lave
            return;
        }
    }
}
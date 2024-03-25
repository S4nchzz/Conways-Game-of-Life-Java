package gameOfLife.game;

public class Rules {
    protected boolean alive (boolean gen [][], int x, int y, boolean alive) {
        int deathCell = 0;
        int aliveCell = 0;

        if (alive) {
            if (gen[x][y] && gen[x][y - 1]) { // anterior
                aliveCell++;
            }

            if (gen[x][y] && gen[x][y + 1]) { // posterior
                aliveCell++;
            }

            if (gen[x][y] && gen[x - 1][y]) { // iz
                aliveCell++;
            }

            if (gen[x][y] && gen[x + 1][y]) { // derecha
                aliveCell++;
            }

            if (gen[x][y] && gen[x - 1][y - 1]) { // anterior iz
                aliveCell++;
            }

            if (gen[x][y] && gen[x + 1][y - 1]) { // anterior der
                aliveCell++;
            }

            if (gen[x][y] && gen[x - 1][y + 1]) { // posterior iz
                aliveCell++;
            }

            if (gen[x][y] && gen[x + 1][y + 1]) { // posterior der
                aliveCell++;
            }

            if (aliveCell > 3) {
                return false;
            } else if (aliveCell < 2) {
                return false;
            }
            
            return true;
        } else {
            if (!gen[x][y] && gen[x][y - 1]) { // anterior
                deathCell++;
            }

            if (!gen[x][y] && gen[x][y + 1]) { // posterior
                deathCell++;
            }

            if (!gen[x][y] && gen[x - 1][y]) { // iz
                deathCell++;
            }

            if (!gen[x][y] && gen[x + 1][y]) { // derecha
                deathCell++;
            }

            if (!gen[x][y] && gen[x - 1][y - 1]) { // anterior iz
                deathCell++;
            }

            if (!gen[x][y] && gen[x + 1][y - 1]) { // anterior der
                deathCell++;
            }

            if (!gen[x][y] && gen[x - 1][y + 1]) { // posterior iz
                deathCell++;
            }

            if (!gen[x][y] && gen[x + 1][y + 1]) { // posterior der
                deathCell++;
            }

            if (deathCell == 3) {
                return true;
            }
        }
        return false;
    }
}

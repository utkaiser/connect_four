package de.uniwue.jpp.connect_four;

public class ConnectFour {

    private Color[][] board;
    private Player p1;
    private Player p2;
    private Player active;
    private Player last;

    /**
     * 
     * @param p1
     * @param p2
     */
    public ConnectFour(Player p1, Player p2) {
        if (p1.getColor().equals(p2.getColor())) {
            throw new IllegalArgumentException("Beide Spieler haben die gleiche Farbe");
        }
        this.board = new Color[6][7];
        this.p1 = p1;
        this.p2 = p2;
        this.active = p1;
    }

    /**
     * 
     * @param column
     * @return
     */
    public Player insert(int column) {

        if (column < 0 || column > getWidth() - 1) {
            throw new IllegalArgumentException("ungültige Spalte!");
        }
        if (board[0][column] != null) {
            throw new IllegalArgumentException("Spalte ist bereits voll!");
        }
        if (board[getHeight() - 1][column] == null) {
            board[getHeight() - 1][column] = active.getColor();
        } else {
            for (int i = 0; i < getHeight(); i++) {
                if (board[i][column] != null) {
                    board[i - 1][column] = active.getColor();
                    break;
                }
            }
        }

        if (active.equals(p1)) {
            return p2;
        } else {
            return p1;
        }

    }

    /**
     * 
     * @return
     */
    public boolean hasWon() {

        if (active.equals(p1)) {
            last = p2;
        } else {
            last = p1;
        }
        
        // Vertikal prüfen ob aktiver Spieler gewonnen hat
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    continue;
                }

                if (board[i][j].equals(last.getColor())) {
                    if (board[i + 1][j] == null || board[i + 2][j] == null
                            || board[i + 3] == null) {
                        continue;
                    }
                    if (board[i + 1][j].equals(last.getColor()) && board[i + 2][j].equals(last.getColor())
                            && board[i + 3][j].equals(last.getColor())) {
                        return true;
                    }
                }

            }
        }

        // Horizontal prüfen ob der aktive Spieler gewonnen hat
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {

                if (board[i][j] == null) {
                    continue;
                }
                if (board[i][j].equals(last.getColor())) {
                    if (board[i][j + 1] == null || board[i][j + 2] == null
                            || board[i][j + 3] == null) {
                        continue;
                    }
                    if (board[i][j + 1].equals(last.getColor()) && board[i][j + 2].equals(last.getColor())
                            && board[i][j + 3].equals(last.getColor())) {
                        return true;
                    }
                }

            }
        }
        
        // Diagonal rechts/unten prüfen ob der aktive Spieler gewonnen hat
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {

                if (board[i][j] == null) {
                    continue;
                }
                if (board[i][j].equals(last.getColor())) {
                    if (board[i + 1][j + 1] == null || board[i + 2][j + 2] == null
                            || board[i + 3][j + 3] == null) {
                        continue;
                    }
                    if (board[i + 1][j + 1].equals(last.getColor()) && board[i + 2][j + 2].equals(last.getColor())
                            && board[i + 3][j + 3].equals(last.getColor())) {
                        return true;
                    }
                }

            }
        }
        
        // Diagonal rechts/oben prüfen ob der aktive Spieler gewonnen hat
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {

                if (board[i][j] == null) {
                    continue;
                }
                if (board[i][j].equals(last.getColor())) {
                    if (board[i - 1][j + 1] == null || board[i - 2][j + 2] == null
                            || board[i - 3][j + 3] == null) {
                        continue;
                    }
                    if (board[i - 1][j + 1].equals(last.getColor()) && board[i - 2][j + 2].equals(last.getColor())
                            && board[i - 3][j + 3].equals(last.getColor())) {
                        return true;
                    }
                }

            }
        }
        return false;
        
        
        

    }

    /**
     * 
     */
    public String toString() {
        String back = "";
        for (int i = 0; i < board.length; i++) {
            if (i != 0) {
                back = back + "\n";
            }
            back = back + "|";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    back = back + " ";
                } else {
                    back = back + board[i][j].toString();
                }
                back = back + "|";

            }
        }
        return back;
    }
    
    public Player getActive() {
        return active;
    }
    
    public Player getLast() {
        return last;
    }
    
    public void setActive(Player active) {
        this.active = active;
    }
    
    public Player getPlayer1() {
        return p1;
    }
    
    public Player getPlayer2() {
        return p2;
    }

    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
    }

}

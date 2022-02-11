package de.uni.con.connect_four;

public class Player {
    
    private String name;
    private Color color;

    /**
     * Erzeugt einen neuen Spieler mit dem übergebenen Name und Farbe
     * @param name
     * @param color
     */
    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public String toString() {
        return name + "@" + color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        if (color != other.color) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }



}

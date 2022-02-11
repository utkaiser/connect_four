package de.uni.con.connect_four;

public enum Color {

    Red("X"), Yellow("O");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String toString() {
        return color;
    }

}

package de.uniwue.jpp.connect_four;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {

    /**
     * 
     * @param in
     * @param out
     * @param p1
     * @param p2
     */
    public void run(InputStream in, OutputStream out, Player p1, Player p2) {

        PrintWriter writer = new PrintWriter(out);


        Scanner scanner = new Scanner(in);
        String input = "";

        ConnectFour cfour = new ConnectFour(p1, p2);


        while (cfour.hasWon() == false) {

            writer.println(cfour.toString());
            writer.flush();

            writer.print(cfour.getActive().toString() + " enter your column:\n");
            writer.flush();
            input = scanner.nextLine();

            int column = Integer.parseInt(input);
            cfour.setActive(cfour.insert(column));
            


        }
        
        writer.print("Congratulations " + cfour.getLast().getName() + " you have won!\n");
        writer.println(cfour.toString());
        writer.flush();
        
        scanner.close();
        writer.close();

    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        Player p1 = new Player("p1", Color.Yellow);
        Player p2 = new Player("p2", Color.Red);

        Game connectFour = new Game();
        connectFour.run(System.in, System.out, p1, p2);

    }

}

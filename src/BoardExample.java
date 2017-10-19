
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bonsk5852
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a board
        Board b = new Board(8, 8);
        // Create pegs
        b.putPeg(Color.green, 3, 5);
        b.putPeg(Color.blue, 4, 5);
        // Remove a peg
        b.removePeg(3, 5);
        // Display a message
        b.displayMessage("Hello");
        while (true) {
            // Receive a click from the user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.putPeg(Color.yellow, clickRow, clickCol);
        }
    }
}


import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    // Create a board
    Board board = new Board(12, 12);
    // Create 3 Daleks
    Dalek dalek1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek dalek2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek dalek3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    // Create a Doctor
    Doctor doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
    // Create a counter to count how many moves the user made before losing/winning
    int counter = 0;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {

        // Place three Daleks on the board
        board.putPeg(Color.black, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.black, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.black, dalek3.getRow(), dalek3.getCol());

        // Place the Doctor on the board
        board.putPeg(Color.green, doctor.getRow(), doctor.getCol());
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        // Keep running as long as 1 dalek is still alive and the doctor hasn't been caught
        while (true) {
            // Stop the game and output a message if the doctor gets caught
            if ((doctor.getRow() == (dalek1.getRow()) && doctor.getCol() == dalek1.getCol())
                    || (doctor.getRow() == (dalek2.getRow()) && doctor.getCol() == dalek2.getCol())
                    || (doctor.getRow() == (dalek3.getRow()) && doctor.getCol() == dalek3.getCol())) {
                board.displayMessage("You Lost in " + counter + " moves! Your doctor got caught");
                break;
            }
            if (dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()) {
                board.displayMessage("You won the game in " + counter + " moves!");
                break;
            }
            // If dalek1 and dalek2 crash, set hasCrashed to true
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
                board.putPeg(Color.red, dalek1.getRow(), dalek1.getCol());
                dalek1.crash();
                dalek2.crash();
            }
            // If dalek1 and dalek3 crash, set hasCrashed to true
            if (dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()) {
                board.putPeg(Color.red, dalek1.getRow(), dalek1.getCol());
                dalek1.crash();
                dalek3.crash();
            }
            // If dalek2 and dalek3 crash, set hasCrashed to true
            if (dalek3.getRow() == dalek2.getRow() && dalek3.getCol() == dalek2.getCol()) {
                board.putPeg(Color.red, dalek2.getRow(), dalek2.getCol());
                dalek3.crash();
                dalek2.crash();
            }// Get a click from the user
            Coordinate click = board.getClick();
            // increase the counter by 1
            counter++;
            board.removePeg(doctor.getRow(), doctor.getCol());
            int newRow = click.getRow();
            int newCol = click.getCol();
            // Move the doctor
            doctor.move(newRow, newCol);
            // Remove the original peg than put down a new one in a new position
            board.putPeg(Color.green, doctor.getRow(), doctor.getCol());



            if (!dalek1.hasCrashed()) {
                // Advance dalek1 towards the doctor
                board.removePeg(dalek1.getRow(), dalek1.getCol());
                dalek1.advanceTowards(doctor);
                board.putPeg(Color.black, dalek1.getRow(), dalek1.getCol());
            }

            if (!dalek2.hasCrashed()) {
                // Advance dalek2 towards the doctor
                board.removePeg(dalek2.getRow(), dalek2.getCol());
                dalek2.advanceTowards(doctor);
                board.putPeg(Color.black, dalek2.getRow(), dalek2.getCol());
            }

            if (!dalek3.hasCrashed()) {
                // Advance dalek3 towards the doctor
                board.removePeg(dalek3.getRow(), dalek3.getCol());
                dalek3.advanceTowards(doctor);
                board.putPeg(Color.black, dalek3.getRow(), dalek3.getCol());
            }


        }
    }
}

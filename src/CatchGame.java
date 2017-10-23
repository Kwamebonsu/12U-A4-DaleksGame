
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

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
//        // If doctor spawns on the same position as one of the daleks respawn the doctor
//        while ((doctor.getCol() == dalek1.getCol() && doctor.getRow() == dalek1.getRow())
//                || (doctor.getCol() == dalek2.getCol() && doctor.getRow() == dalek2.getRow())
//                || (doctor.getCol() == dalek3.getCol() && doctor.getRow() == dalek3.getRow())) {
// 
//        }
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

        // Get a click from the user
        Coordinate click = board.getClick();
        board.removePeg(doctor.getRow(), doctor.getCol());
        int newRow = click.getRow();
        int newCol = click.getCol();
        // 
        //
        //
        //
        //
        //Doctor move method
        //
        // Move the doctor to the new Location
        // move the doctor 1 space or randomly generate a new spot
        if ((newRow == doctor.getRow() || newRow == doctor.getRow() + 1 || newRow == doctor.getRow() - 1)
                && (newCol == doctor.getCol() || newCol == doctor.getCol() + 1 || newCol == doctor.getCol() - 1)) {
        } else { // Teleport
            newRow = (int) (Math.random() * 12);
            newCol = (int) (Math.random() * 12);
        }
        // doctor move method ends
        //
        //
        //
        //
        //
        // Remove the original peg than put down a new one in a new position
        doctor = new Doctor(newRow, newCol);
        board.putPeg(Color.green, doctor.getRow(), doctor.getCol());
        // move the daleks towards the doctor
        dalek1.advanceTowards(doctor);
        //
        //
        //
        //
        //
        // AdvanceTowards methods
        // Move up left
        if (dalek1.getCol() > doctor.getCol() && dalek1.getRow() > doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1 = new Dalek(dalek1.getRow() - 1, dalek1.getCol() - 1);
            board.putPeg(Color.black, dalek1.getRow() - 1, dalek1.getCol() - 1);

        } // Move up
        else if (dalek1.getCol() == doctor.getCol() && dalek1.getRow() > doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1 = new Dalek(dalek1.getRow() - 1, dalek1.getCol());
        } // Move up right
        else if (dalek1.getCol() < doctor.getCol() && dalek1.getRow() > doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1 = new Dalek(dalek1.getRow() - 1, dalek1.getCol() + 1);
        } // Move right
        else if (dalek1.getCol() < doctor.getCol() && dalek1.getRow() == doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1 = new Dalek(dalek1.getRow(), dalek1.getCol() + 1);
        } // Move down right
        // Continue here
        //
        //
        //
        //
        else if (dalek1.getCol() < doctor.getCol() && dalek1.getRow() < doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1.getRow()++;
            dalek1.getCol()++;
        } // Move down
        else if (dalek1.getCol() == doctor.getCol() && dalek1.getRow() < doctor.getRow()) {
            dalek1.getRow()++;
        } // Move down left
        else if (dalek1.getCol() > doctor.getCol() && dalek1.getRow() < doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1.getRow() = dalek1.getRow() - 1;
            dalek1.getCol()--;
        } // Move left
        else if (dalek1.getCol() > doctor.getCol() && dalek1.getRow() == doctor.getRow()) {
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            dalek1.getCol()--;
        }
        // method ends
        //
        //
        //
        //

    }
}


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
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
    }
}

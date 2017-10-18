
import model.Game;
import view.*;
import controller.*;

/**
 *  Program entry point. Creates model (Game), view and controller (PlayGame),
 *  starts the game and continues running it until the player wants to quit.
 */
public class Program {

    public static void main(String[] a_args) {

        Game g = new Game();
        IView v = new SimpleView(); //new SwedishView();
        PlayGame ctrl = new PlayGame();

        while (ctrl.Play(g, v)) {
            ;
        }
    }
}
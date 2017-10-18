package controller;

import view.IView;
import model.Game;

/**
 *  Controller class. Controls the flow of the program depending on user input
 *  and game state.
 */
public class PlayGame {

    public boolean Play(Game a_game, IView a_view) {
        a_view.DisplayWelcomeMessage();

        a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
        a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

        if (a_game.IsGameOver()) {
            a_view.DisplayGameOver(a_game.IsDealerWinner());
        }

        a_view.ReadInput();

        if (a_view.WantsToPlay()) {
            a_game.NewGame();
        } else if (a_view.WantsToHit()) {
            a_game.Hit();
        } else if (a_view.WantsToStand()) {
            a_game.Stand();
        }
        else if (a_view.WantsToQuit()) {
            return false;
        }

        return true;
    }


}
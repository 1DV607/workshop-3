package controller;

import java.util.concurrent.TimeUnit;

import view.IView;
import model.Game;
import observer.CardDealtObserver;

/**
 *  Controller class. Controls the flow of the program depending on user input
 *  and game state.
 */
public class PlayGame implements CardDealtObserver {

    private Game m_game;
    private IView m_view;

    public PlayGame(Game a_game, IView a_view) {
        m_game = a_game;
        m_view = a_view;
    }

    public boolean Play() {
        m_game.SetObserver(this);

        m_view.DisplayWelcomeMessage();
        DisplayPlayerHands();

        if (m_game.IsGameOver()) {
            m_view.DisplayGameOver(m_game.IsDealerWinner());
        }

        m_view.ReadInput();

        if (m_view.WantsToPlay()) {
            m_game.NewGame();
        } else if (m_view.WantsToHit()) {
            m_game.Hit();
        } else if (m_view.WantsToStand()) {
            m_game.Stand();
        }
        else if (m_view.WantsToQuit()) {
            return false;
        }

        return true;
    }

    @Override
    public void CardDealt() {
        m_view.Clear();
        DisplayPlayerHands();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.err.println("Sleep interrupted.");
        }
    }

    private void DisplayPlayerHands() {
        m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
        m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
    }
}
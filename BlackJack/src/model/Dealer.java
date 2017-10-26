package model;

import model.rules.*;
import observer.CardDealtObserver;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IGameWinnerRule m_winRule;
    private CardDealtObserver m_observer;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.GetWinnerRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
    }


    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            DealCardTo(a_player, true, m_deck);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        return m_winRule.IsWinner(this, a_player);
    }

    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {
            return true;
        }
        return false;
    }

    public boolean Stand() {
        if (m_deck != null) {
            ShowHand();

            while (m_hitRule.DoHit(this)) {
                DealCardTo(this, true, m_deck);
            }
            return true;
        }

        return false;
    }

    public void DealCardTo(Player a_player, boolean a_cardVisible, Deck a_deck) {
        Card card = a_deck.GetCard();
        card.Show(a_cardVisible);
        a_player.DealCard(card);
        m_observer.CardDealt();
    }

    public void SetObserver(CardDealtObserver a_observer) {
        m_observer = a_observer;
    }

}
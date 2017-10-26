package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

        a_dealer.DealCardTo(a_player, true, a_deck);

        a_dealer.DealCardTo(a_dealer, true, a_deck);

        a_dealer.DealCardTo(a_player, true, a_deck);

        return true;
    }
}
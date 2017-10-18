package model.rules;

import model.Player;

/**
 *
 */
public interface IGameWinnerRule {

    boolean IsWinner(Player a_dealer, Player a_player);
}

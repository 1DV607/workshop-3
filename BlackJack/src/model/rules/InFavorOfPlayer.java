package model.rules;

import model.Player;

/**
 * Rule that decides who wins
 * This implementation is in favor of the Player, meaning that if the score is equal the Player will win.
 */
public class InFavorOfPlayer implements IGameWinnerRule {


    @Override
    public boolean IsWinner(Player a_dealer, Player a_player) {

        int m_maxScore = a_player.GetMaxScore();

        if (a_player.CalcScore() > m_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > m_maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();
    }
}

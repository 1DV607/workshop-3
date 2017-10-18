package model.rules;

import model.Card;
import model.Player;

/**
 * Dealer rule for Soft 17 strategy while hitting
 *
 * Soft 17:
 * If the total score is 17 and one card is an Ace then take a new card.
 */
public class Soft17HitStrategy implements IHitStrategy {

    private final int g_hitlimit = 17;

    @Override
    public boolean DoHit(Player a_dealer) {
        if (a_dealer.CalcScore() < g_hitlimit) {
            return true;
        }
        else if (a_dealer.CalcScore() == g_hitlimit) {

            for (Card c : a_dealer.GetHand()) {

                if (c.GetValue().equals(Card.Value.Ace)) {
                    return true;
                }
            }
        }

        return false;
    }
}

package view;

/**
 *  View interface which all available views implements. Provides methods the controller can use
 *  to control the views.
 */
public interface IView {
    void DisplayWelcomeMessage();

    void DisplayCard(model.Card a_card);

    void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);

    void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);

    void DisplayGameOver(boolean a_dealerIsWinner);

    void Clear();

    boolean WantsToPlay();

    boolean WantsToHit();

    boolean WantsToStand();

    boolean WantsToQuit();

    void ReadInput();
}
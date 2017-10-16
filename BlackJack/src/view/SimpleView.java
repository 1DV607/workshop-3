package view;

public class SimpleView implements IView {

    private int m_input;

    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;
        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
    }

    public void DisplayCard(model.Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Has: ");
        for (model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }

    @Override
    public boolean WantsToPlay() {
        return m_input == (int)'p';
    }

    @Override
    public boolean WantsToHit() {
        return m_input == (int)'h';
    }

    @Override
    public boolean WantsToStand() {
        return m_input == (int)'s';
    }

    @Override
    public boolean WantsToQuit() {
        return m_input == (int)'q';
    }


    public void ReadInput() {
        try {
            int i = System.in.read();
            while (i == '\r' || i == '\n') {
                i = System.in.read();
            }
            m_input = i;
        } catch (java.io.IOException e) {
            System.out.println("Wrong input please try again!");
            m_input = 0;
        }
    }
}

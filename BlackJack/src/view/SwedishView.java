package view;

/**
 *  Swedish command line/terminal view. Handles specifics on how things are displayed to the
 *  player and reads input from the player.
 */
public class SwedishView implements IView {

    private int m_input;

    public void DisplayWelcomeMessage() {

        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 's' för att Spela, 'g' för kort giv, 'n' om du är nöjd eller 'a' för att avsluta\n");
    }

    public void DisplayCard(model.Card a_card) {
        if (a_card.GetColor() == model.Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Har: " + a_score);
        for (model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }

    @Override
    public void Clear() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
    }

    @Override
    public boolean WantsToPlay() {
        return m_input == (int)'s';
    }

    @Override
    public boolean WantsToHit() {
        return m_input == (int)'g';
    }

    @Override
    public boolean WantsToStand() {
        return m_input == (int)'n';
    }

    @Override
    public boolean WantsToQuit() {
        return m_input == (int)'a';
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


package dealers;

import com.google.inject.Inject;
import essentials.Card;
import essentials.Pack;

public class Dealer {
    Pack pack;

    @Inject
    public Dealer(Pack pack) {
        this.pack = pack;
    }

    public Card deal() {
        Card card = pack.getCard();
        return card;
    }
}

package essentials;

import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Pack {
    private List<Card> cards;
    private Map<Card, Integer> map;
    private Random random;

    public Pack() {
        cards = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
        reinitializePack();
    }

    public void shuffle() {
        Collections.shuffle(cards);
        for (int i = 0; i < cards.size(); i++) {
            map.put(cards.get(i), i);
        }
    }

    private void reinitializePack() {
        String[] suits = {"Club", "Diamond", "Heart", "Spades"};
        for (int i = 2; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new Card(suits[j], Integer.toString(i)));
            }
        }
        for (int j = 0; j < 4; j++) {
            cards.add(new Card(suits[j], "Ace"));
        }
        for (int j = 0; j < 4; j++) {
            cards.add(new Card(suits[j], "Jack"));
        }
        for (int j = 0; j < 4; j++) {
            cards.add(new Card(suits[j], "King"));
        }
        for (int j = 0; j < 4; j++) {
            cards.add(new Card(suits[j], "Queen"));
        }
        shuffle();
    }

    public Card getCard() {
        int n = cards.size();
        int x = random.nextInt(n);
        Card c = cards.get(x);
        swap(x, n - 1);
        return c;
    }

    private void swap(int i, int j) {
        cards.set(i, cards.get(j));
        cards.remove(cards.size() - 1);
    }
}

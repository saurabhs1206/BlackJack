package gameImpl;

import com.google.inject.Inject;
import dealers.Dealer;
import essentials.Card;
import game.Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BlackJack implements Game {
    private Dealer dealer;
    public int dealerSum;
    public int playerSum;
    public List<Card> dealerCards;
    public List<Card> playerCards;
    private BufferedReader in;

    @Inject
    public BlackJack(Dealer dealer) {
        this.dealer = dealer;
        restartGame();
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private void restartGame() {
        dealerSum = playerSum = 0;
        dealerCards = new ArrayList<>();
        playerCards = new ArrayList<>();
    }

    @Override
    public void play() throws IOException {
        //Assuming a single player and a single dealer

        //Dealer deals one card each to him and the player face up
        Card c1 = dealer.deal();
        Card c2 = dealer.deal();
        System.out.println("Dealer gets " + c1.toString());
        System.out.println("Player gets " + c2.toString());
        dealerSum += c1.getValue();
        playerSum += c2.getValue();
        dealerCards.add(c1);
        playerCards.add(c2);

        c1 = dealer.deal();
        c2 = dealer.deal();
        System.out.println("Player gets " + c2.toString());
        dealerSum += c1.getValue();
        playerSum += c2.getValue();
        dealerCards.add(c1);
        playerCards.add(c2);

        while (true) {
            System.out.println("Do you want to deal more ? Press 1 for yes");
            int res = Integer.parseInt(in.readLine());
            if (res == 1) {
                Card c = dealer.deal();
                System.out.println("Player got " + c.toString());
                playerCards.add(c);
                playerSum += c.getValue();
                if (playerSum == 21) {
                    System.out.println("Player wins");
                    restartGame();
                    return;
                } else if (playerSum > 21) {
                    System.out.println("Player busts");
                    restartGame();
                    return;
                }
            } else {
                break;
            }
        }
        System.out.println("Dealer's other card was " + c1.toString());
        while (dealerSum <= 16) {
            Card c = dealer.deal();
            System.out.println("Dealer got " + c.toString());
            dealerSum += c.getValue();
            dealerCards.add(c);
            if (dealerSum > 21) {
                System.out.println("Player wins ");
                restartGame();
                return;
            }
        }
        if (dealerSum < playerSum) {
            System.out.println("Player wins ");
            restartGame();
            return;
        } else {
            System.out.println("Dealer wins ");
            restartGame();
            return;
        }
    }
}

package driver;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dealers.Dealer;
import essentials.Pack;
import game.Game;
import gameImpl.BlackJack;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Injector injector = Guice.createInjector(new BlackJackGuiceModule());
        Game game = injector.getInstance(Game.class);
        game.play();
/*
        Pack pack = new Pack();
        Dealer dealer = new Dealer(pack);
        Game game = new BlackJack(dealer);
        game.play();
*/
    }
}

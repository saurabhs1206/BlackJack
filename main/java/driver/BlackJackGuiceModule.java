package driver;

import game.Game;
import gameImpl.BlackJack;

public class BlackJackGuiceModule extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
        bind(Game.class).to(BlackJack.class);
    }
}

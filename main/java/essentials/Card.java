package essentials;

import org.apache.commons.lang3.StringUtils;

public class Card {
    private String suite;
    private String name;

    Card(String suite, String name) {
        this.suite = suite;
        this.name = name;
    }

    public int getValue() {
        if (StringUtils.equals(name, "Jack") || StringUtils.equals(name, "King") || StringUtils.equals(name, "Queen")) {
            return 10;
        } else if (StringUtils.equals(name, "Ace")) {
            return 1;
        } else {
            return Integer.parseInt(name);
        }
    }

    @Override
    public String toString() {
        return suite + name;
    }
}

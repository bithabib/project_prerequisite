package feast.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Lamb5 {

    private final Goat6 goat6;

    @Autowired
    public Lamb5(Goat6 goat6) {
        this.goat6 = goat6;
    }

    @Override
    public String toString() {
        return "which is stuffed inside a lamb, " + goat6.toString();
    }
}

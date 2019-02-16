
package ducksim;

import java.awt.Color;
import java.util.Observable;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        setColor(Color.RED);
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new QuackNormal());
    }

    @Override
    public String display() {
        return "Redhead";
    }

}

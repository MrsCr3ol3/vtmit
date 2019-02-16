
package ducksim;

import java.awt.Color;
import java.util.Observable;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setColor(Color.GREEN);
        setQuackBehavior(new QuackNormal());
        setFlyBehavior(new FlyWithWings());



    }

    @Override
    public String display() {
        return "Mallard";
    }

}


package ducksim;

import java.awt.Color;
import java.util.Observable;

public class RubberDuck extends Duck {

    public RubberDuck() {
        setColor(Color.YELLOW);
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new QuackSqueek());
    }

/*    @Override
    public void performFly() {
        //
    }*/

/*    @Override
    public String getQuack() {
        return "Squeek!";
    }*/

    @Override
    public String display() {
        return "Rubber";
    }

}

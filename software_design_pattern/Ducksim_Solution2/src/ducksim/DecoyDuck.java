package ducksim;

import java.awt.Color;
import java.util.Observable;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Baek
 *  @version Apr 30, 2017
 */
public class DecoyDuck
    extends Duck
{

    public DecoyDuck() {
        setColor(Color.ORANGE);
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new QuackNoWay());
    }

    @Override
    public String display() {
        return "Decoy";
    }
    
    @Override
    public void quack() {
        
    }

    



}

package ducksim;

import java.awt.Color;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Baek
 *  @version Apr 30, 2017
 */
public abstract class Bling
    extends Duck
{

    private Duck duck;

    public Bling(Duck d) {
        setFlyBehavior(d.getFlyBehavoir());
        setQuackBehavior(d.getQuackBehavoir());
        duck = d;
    }



    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract String display();

    @Override
    public Color getColor() {
        return duck.getColor();
    }

    @Override
    public String performQuack() {
        return duck.performQuack();

    }


    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}

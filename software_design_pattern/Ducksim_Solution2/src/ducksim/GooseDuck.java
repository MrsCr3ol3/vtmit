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
 *  @version May 1, 2017
 */
public class GooseDuck
    extends Duck
{
    private Goose goose;
    private QuackBehavior quackBehavior;

    public GooseDuck() {
        super();
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new QuackNormal());
        this.quackBehavior = getQuackBehavoir();
        goose = new Goose();
        setColor(Color.BLUE);

    }

    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public String display()
    {
        // TODO Auto-generated method stub
        return goose.getName();
    }

    @Override
    public String performQuack() {

       

        if (isFree())
        {
            System.out.print(quackBehavior.quack());
            return goose.getHonk();

        }

        return "";

    }


}

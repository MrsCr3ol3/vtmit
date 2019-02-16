package ducksim;

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Baek
 * @version Apr 30, 2017
 */
public class MoonBling
    extends Bling
{
    private Duck duck;
    // ----------------------------------------------------------
    /**
     * Create a new MoonBling object.
     * @param d
     */
    public MoonBling(Duck d)
    {
        super(d);
        duck = d;
    }





    @Override
    public String display()
    {
        return duck.display() + ":)";
    }

}

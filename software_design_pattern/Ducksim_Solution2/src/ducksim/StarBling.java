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
public class StarBling
    extends Bling
{
    private Duck duck;
    // ----------------------------------------------------------
    /**
     * Create a new StarBling object.
     * @param d
     */
    public StarBling(Duck d)
    {
        super(d);
        duck = d;
    }




    @Override
    public String display()
    {
        return duck.display() + ":*";
    }


}

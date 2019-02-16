package ducksim;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Baek
 *  @version Apr 30, 2017
 */
public class FlyWithWings
    implements FlyBehavior
{

    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public State fly()
    {
        return State.FLYING;

    }
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}

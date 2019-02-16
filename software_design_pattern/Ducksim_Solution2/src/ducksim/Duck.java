
package ducksim;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public abstract class Duck
    implements Observer
{

    private Color         color;
    private State         state;
    private boolean       isFree;
    private boolean       isOnDSWC;

    private FlyBehavior   flyBehavior;
    private QuackBehavior quackBehavior;
    private DuckFactory duckFactory;


    public Duck()
    {
        color = Color.BLACK;
        state = State.SWIMMING;
        isFree = true;
        isOnDSWC = false;

    }


    // typical duck commands

    public void swim()
    {
        state = State.SWIMMING;
    }


    public void quack()
    {
        state = State.QUACKING;
    }


    /*
     * public String getQuack() { return "Quack!"; }
     */

    public void setQuackBehavior(QuackBehavior qb)
    {
        quackBehavior = qb;
    }


    public void setFlyBehavior(FlyBehavior fb)
    {
        flyBehavior = fb;
    }


    public String performQuack()
    {

        if (isFree)
        {

            return quackBehavior.quack();
        }

        return "";
    }


    public void performFly()
    {
        if (isFree)
        {
            state = flyBehavior.fly();
        }
        else
        {
            state = State.SWIMMING;
        }
    }


    public FlyBehavior getFlyBehavoir()
    {
        return flyBehavior;
    }


    public QuackBehavior getQuackBehavoir()
    {
        return quackBehavior;
    }


    public State getState()
    {
        return state;
    }


    public void setState(State state)
    {
        this.state = state;
    }


    public void setColor(Color c)
    {
        color = c;
    }


    public Color getColor()
    {
        return color;
    }


    // join / quit and capture / release commands

    public void joinDSWC()
    {
        isOnDSWC = true;
    }


    public void quitDSWC()
    {
        isOnDSWC = false;
    }


    public boolean isOnDSWC()
    {
        return isOnDSWC;
    }


    public void capture()
    {
        isFree = false;
    }


    public void release()
    {
        isFree = true;
    }


    public boolean isFree()
    {
        return isFree;
    }


    public abstract String display();

    @Override
    public void update(Observable o, Object arg)
    {

        // System.out.println("update success!");
        if (isOnDSWC() && !isFree())
        {
            setState(State.SWIMMING);
        }
        else
        {
            setState(State.WELCOMING);
        }

    }

}

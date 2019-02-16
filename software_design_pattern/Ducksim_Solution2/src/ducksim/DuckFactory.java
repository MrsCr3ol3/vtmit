package ducksim;

import java.util.Observable;
import java.util.Observer;


// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Baek
 * @version Apr 30, 2017
 */
public class DuckFactory extends Observable
{
    private static DuckFactory instance = new DuckFactory();
    private Duck duck;

    private DuckFactory() {};

    public static DuckFactory getInstance(){
        return instance;
     }


    public Duck createDuck(
        String duckType,
        int starCount,
        int moonCount,
        int crossCount)
    {

        switch (duckType)
        {
            case "Mallard":
                duck = new MallardDuck();

                while (starCount > 0)
                {
                    duck = new StarBling(duck);
                    starCount--;
                }

                while (moonCount > 0)
                {
                    duck = new MoonBling(duck);
                    moonCount--;
                }

                while (crossCount > 0)
                {
                    duck = new CrossBling(duck);
                    crossCount--;
                }

                break;
            case "Redhead":
                duck = new RedheadDuck();

                while (starCount > 0)
                {
                    duck = new StarBling(duck);
                    starCount--;
                }

                while (moonCount > 0)
                {
                    duck = new MoonBling(duck);
                    moonCount--;
                }

                while (crossCount > 0)
                {
                    duck = new CrossBling(duck);
                    crossCount--;
                }

                break;

            case "Rubber":
                duck = new RubberDuck();

                while (starCount > 0)
                {
                    duck = new StarBling(duck);
                    starCount--;
                }

                while (moonCount > 0)
                {
                    duck = new MoonBling(duck);
                    moonCount--;
                }

                while (crossCount > 0)
                {
                    duck = new CrossBling(duck);
                    crossCount--;
                }

                break;

            case "Decoy":
                duck = new DecoyDuck();

                while (starCount > 0)
                {
                    duck = new StarBling(duck);
                    starCount--;
                }

                while (moonCount > 0)
                {
                    duck = new MoonBling(duck);
                    moonCount--;
                }

                while (crossCount > 0)
                {
                    duck = new CrossBling(duck);
                    crossCount--;
                }

                break;

            case "Goose":
                duck = new GooseDuck();

                while (starCount > 0)
                {
                    duck = new StarBling(duck);
                    starCount--;
                }

                while (moonCount > 0)
                {
                    duck = new MoonBling(duck);
                    moonCount--;
                }

                while (crossCount > 0)
                {
                    duck = new CrossBling(duck);
                    crossCount--;
                }

                break;

            default:
                duck = null;

        }

        setChanged();
        notifyObservers();
        return duck;
    }




}

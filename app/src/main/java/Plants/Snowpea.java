package Plants;

import Position.Positition;

public class Snowpea extends Plant{

    public Snowpea()
    {
        super("Snow pea", 50, 100, 25, 1, -1, 10,  new Positition(0, 0));
    }
    
    @Override
    public void useAbility()
    {
        System.out.println("Snow pea shoots frozen peas!");
    }

}

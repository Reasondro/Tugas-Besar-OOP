package Plants;

import Position.Positition;

public class Squash  extends Plant{
    
    public Squash()
    {
        super("Squash", 50, 100, 5000, 0, 1, 20,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Squash explodes!");
    }
    

}

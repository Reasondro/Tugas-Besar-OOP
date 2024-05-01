package Plants;

import Position.Position;

public class Squash  extends Plant{
    
    public Squash()
    {
        super("Squash", 50, 100, 5000, 0, 1, 20,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Squash explodes!");
    }
    

}

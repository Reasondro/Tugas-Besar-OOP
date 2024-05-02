package Plants;

import Position.Position;
import PlantAbility.*;


public class Squash  extends Plant implements PlantAbility{
    
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

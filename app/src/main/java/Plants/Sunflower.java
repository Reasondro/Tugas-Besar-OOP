package Plants;

import Position.Position;
import PlantAbility.*;


public class Sunflower extends Plant implements PlantAbility  {
    
    public Sunflower()
    {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  new Position(0, 0));
    }
    
    @Override
    public void useAbility() {
        System.out.println("Sunflower generates sunlight");
    }
    

}

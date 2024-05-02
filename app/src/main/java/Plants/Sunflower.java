package Plants;

import Position.Position;
import PlantAbility.*;
import Sun.*;


public class Sunflower extends Plant implements PlantAbility  {

    // private int sunCooldown = 0;
    
    public Sunflower()
    {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  new Position(0, 0));
    }
    
    @Override
    public void useAbility() 
    {
        // if(sunCooldown > 0)
        // {
        //     sunCooldown--;
        //     return;
        // }
        // else if(sunCooldown == 0)
        // {
        //     sunCooldown = 5;
        // }
        Sun sun = Sun.getInstance();
        sun.addSunPoints(25);
    
    }
    

}

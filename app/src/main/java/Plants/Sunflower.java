package Plants;

import Position.Position;
import PlantAbility.*;
import Sun.*;


public class Sunflower extends Plant implements PlantAbility  {

    private float sunCooldown = 0;
    
    public Sunflower()
    {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  new Position(0, 0));
    }
    
    @Override
    public void useAbility() 
    {
        //TODO use synchronized block/threading
        Sun sun = Sun.getInstance();
        sun.addSunPoints(25);
    
    }
    @Override
    public void checkToUseAbility()
    {
        if(sunCooldown == 0)
        {
            sunCooldown = 3;
            useAbility();
        }
        else if(sunCooldown > 0)
        {
            sunCooldown--;
            return;
        }

    }
    

}

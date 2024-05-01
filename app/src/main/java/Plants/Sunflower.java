package Plants;

import Position.Position;

public class Sunflower extends Plant{
    
    public Sunflower()
    {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  new Position(0, 0));
    }
    
    // public void generate_sunlight()
    // {
    //     System.out.println("Sunflower generates sunlight");
    // }

    @Override
    public void useAbility() {
        System.out.println("Sunflower generates sunlight");
    }
    

}

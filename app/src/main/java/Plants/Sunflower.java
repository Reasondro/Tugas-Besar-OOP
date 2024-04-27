package Plants;

import Position.Positition;

public class Sunflower extends Plant{
    
    public Sunflower()
    {
        super("Sunflower", 50, 100, 0, 0, 0, 10,  new Positition(0, 0));
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

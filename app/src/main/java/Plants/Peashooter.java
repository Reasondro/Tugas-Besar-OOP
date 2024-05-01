package Plants;

import Position.Position;

public class Peashooter extends Plant{
    
    public Peashooter()
    {
        super("Peashooter", 100, 100, 25, 1, -1, 10,  new Position(0, 0));
    }
    
    public void useAbility()
    {
        System.out.println("Peashooter shoots peas!");
    }

}

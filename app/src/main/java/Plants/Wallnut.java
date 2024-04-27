package Plants;

public class Wallnut extends Plant{
    
    public Wallnut()
    {
        super("Wall nut", 50, 1000, 0, 0, 0, 20);
    }

    @Override
    public void useAbility()
    {
        System.out.println("Wall nut takes a lot of damage!");
    }
}

package Plants;

public class Squash  extends Plant{
    
    public Squash()
    {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }

    @Override
    public void useAbility()
    {
        System.out.println("Squash explodes!");
    }
    

}

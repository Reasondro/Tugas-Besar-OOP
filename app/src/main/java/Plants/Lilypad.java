package Plants;

public class Lilypad extends Plant{
    
    public Lilypad()
    {
        super("Lilypad", 25, 100, 0, 0, 0, 10);
    }
    
    @Override
    public void useAbility()
    {
        System.out.println("Lilypad floats!");
    }
   
}

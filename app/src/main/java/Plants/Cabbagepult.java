package Plants;

import Position.Positition;


public class Cabbagepult extends Plant{
    
    public Cabbagepult()
    {
        super("Cabbagepult", 100, 100, 25, 1, -1, 10,  new Positition(0, 0)); // masih tentatif damage dia berapa
    }
    
    public void useAbility()
    {
        System.out.println("Cabbagepult shoots peas!");
    }

}

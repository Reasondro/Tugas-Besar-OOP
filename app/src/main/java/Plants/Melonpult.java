package Plants;

import Position.Positition;


public class Melonpult extends Plant{
    
    public Melonpult()
    {
        super("Melonpult", 100, 100, 25, 1, -1, 10,  new Positition(0, 0)); // masih tentatif damage dia berapa
    }
    
    public void useAbility()
    {
        System.out.println("Melonpult shoots peas!");
    }

}

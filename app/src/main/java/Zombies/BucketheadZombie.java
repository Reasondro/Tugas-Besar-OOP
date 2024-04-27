package Zombies;

import Position.Positition;

public class BucketheadZombie extends Zombie{

    public BucketheadZombie()
    {
        super("Buckethead Zombie", 300, 100, 1, false,  new Positition(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Buckethead Zombie has a bucket on its head!");
    }
    
}

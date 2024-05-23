package ZombieFactory;

import Zombies.Zombie;
import Zombies.BucketheadZombie;

public class BucketheadZombieFactory extends ZombieFactory{
    
    private static int bucketheadZombieCount = 0;
    
    public Zombie createZombie()
    {
        bucketheadZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new BucketheadZombie();
    }

    public static int getBucketheadZombieCount()
    {
        return bucketheadZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        bucketheadZombieCount = 0;
    }
    
}

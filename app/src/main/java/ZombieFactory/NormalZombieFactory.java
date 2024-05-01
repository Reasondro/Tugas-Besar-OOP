package ZombieFactory;

import Zombies.Zombie;
import Zombies.NormalZombie;

public class NormalZombieFactory extends ZombieFactory {


    private static int normalZombieCount = 0;
    public Zombie createZombie()
    {
        normalZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new NormalZombie();
    }

    public static int getNormalZombieCount()
    {
        return normalZombieCount;
    }
    
}

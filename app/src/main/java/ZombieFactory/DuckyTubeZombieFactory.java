package ZombieFactory;

import Zombies.Zombie;
import Zombies.DuckyTubeZombie;

public class DuckyTubeZombieFactory  extends ZombieFactory{

    private static int duckyTubeZombieCount = 0;
    public Zombie createZombie()
    {
        duckyTubeZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new DuckyTubeZombie();
    }

    public static int getDuckyTubeZombieCount()
    {
        return duckyTubeZombieCount;
    }
    
}

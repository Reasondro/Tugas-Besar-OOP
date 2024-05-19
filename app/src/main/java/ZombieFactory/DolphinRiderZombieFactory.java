package ZombieFactory;

import Zombies.Zombie;
import Zombies.DolphinRiderZombie;

public class DolphinRiderZombieFactory extends ZombieFactory {

    private static int dolphinRiderZombieCount = 0;
    public Zombie createZombie()
    {
        dolphinRiderZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new DolphinRiderZombie();
    }

    public static int getDolphinRiderZombieCount()
    {
        return dolphinRiderZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        dolphinRiderZombieCount = 0;
    }
    
}

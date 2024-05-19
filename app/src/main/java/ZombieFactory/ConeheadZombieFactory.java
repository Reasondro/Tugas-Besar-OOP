package ZombieFactory;

import Zombies.Zombie;
import Zombies.ConeheadZombie;

public class ConeheadZombieFactory extends ZombieFactory {
    
    private static int coneheadZombieCount = 0;
    public Zombie createZombie()
    {
        coneheadZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new ConeheadZombie();
    }

    public static int getConeheadZombieCount()
    {
        return coneheadZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        coneheadZombieCount = 0;
    }

}

package ZombieFactory;

import Zombies.Zombie;
import Zombies.RegenerativeZombie;

public class RegenerativeZombieFactory extends ZombieFactory{

    private static int regenerativeZombieCount=0;

    public Zombie createZombie(){
        regenerativeZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new RegenerativeZombie();
    }

    public static int getRegenerativeZombieCount()
    {
        return regenerativeZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        regenerativeZombieCount = 0;
    }
}
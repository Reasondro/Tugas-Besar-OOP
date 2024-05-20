package ZombieFactory;

import Zombies.Zombie;

public abstract class ZombieFactory {

    private static int zombieCount = 0;
    public abstract Zombie createZombie();

    public static int getZombieCount()
    {
        return zombieCount;
    }

    public static void incrementZombieCount()
    {
        zombieCount++;
    }

    public void resetFactory()
    {
        zombieCount = 0;
    }


}

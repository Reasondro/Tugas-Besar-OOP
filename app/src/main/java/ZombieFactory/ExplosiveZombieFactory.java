package ZombieFactory;

import Zombies.Zombie;
import Zombies.ExplosiveZombie;

public class ExplosiveZombieFactory extends ZombieFactory {
    private static int explosiveZombieCount=0;

    public Zombie createZombie() {
        explosiveZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new ExplosiveZombie();
    }

    public static int getExplosiveZombieCount()
    {
        return explosiveZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        explosiveZombieCount = 0;
    }

}
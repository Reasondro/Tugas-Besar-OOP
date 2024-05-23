package ZombieFactory;

import Zombies.Zombie;
import Zombies.DoubleAttackZombie;

public class DoubleAttackZombieFactory extends ZombieFactory {

    private static int doubleAttackZombieCount=0;

    public Zombie createZombie() {
        doubleAttackZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new DoubleAttackZombie();
    }

    public static int getDoubleAttackZombieCount()
    {
        return doubleAttackZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        doubleAttackZombieCount = 0;
    }


}
    
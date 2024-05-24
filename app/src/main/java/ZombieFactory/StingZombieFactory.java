package ZombieFactory;

import Zombies.Zombie;
import Zombies.StingZombie;

public class StingZombieFactory extends ZombieFactory {

    private static int stingZombieCount=0;

    public Zombie createZombie(){
        stingZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new StingZombie();
    }

    public static int getStingZombieCount()
    {
        return stingZombieCount;
    }

    public void resetFactory()
    {
        super.resetFactory();
        stingZombieCount = 0;
    }
}
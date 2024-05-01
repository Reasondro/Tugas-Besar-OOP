package ZombieFactory;

import Zombies.Zombie;
import Zombies.PoleVaultingZombie;


public class PoleVaultingZombieFactory {
    
    private static int poleVaultingZombieCount = 0;
    public Zombie createZombie()
    {
        poleVaultingZombieCount++;
        ZombieFactory.incrementZombieCount();

        return new PoleVaultingZombie();
    }

    public static int getPoleVaultingZombieCount()
    {
        return poleVaultingZombieCount;
    }

}

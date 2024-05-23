package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class ButterBullet extends Bullet {
    private int damage;
    private boolean wornOut = false;

    public ButterBullet(int damage) {
        super(damage);
    }

    public void hit(Petak p)
    {

        synchronized(p)
        {
           for(Zombie z : p.getZombies())
           {
            z.reduceHealth(getDamage());
            z.setFrozenTimer(10);
            if(z.isFrozen() == false)
            {
                z.setFrozen(true);
                z.setWalkSpeedInSeconds(z.getWalkSpeedInSeconds() * 2);
            }
           }
        }
           setWornOut(true);

    }
}

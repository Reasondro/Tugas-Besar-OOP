package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class KernelBullet {

    private int damage;
    private boolean stopzomb = false;

    public KernelBullet(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isStopZomb() {
        return stopzomb;
    }

    public void setStopZomb(boolean stopzomb) {
        this.stopzomb = stopzomb;
    }

    public void hit(Petak p)
    {
           for(Zombie z : p.getZombies())
           {
            int originalHealth = z.getHealth();
            z.reduceHealth(getDamage());
            z.setFrozenTimer(10);
            if(z.isFrozen() == false)
            {
                z.setFrozen(true);
                z.setWalkSpeedInSeconds(z.getWalkSpeedInSeconds() * 2);
                z.reduceHealth(getDamage()); // ini karena kalopun dia udah freeze kena mentega, plant ini ttp akan nyerang pake peluru jagung2 kecil
            }
            System.out.printf("Hit %s with damage %d\n", z.getName(), getDamage());
            // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
            // System.out.printf("%s is frozen\n", z.getName());
            // System.out.printf("%s's walk speed is now %.2f seconds/Petak\n", z.getName(), z.getWalkSpeedInSeconds());
           }
           setStopZomb(true);

    }
    
}

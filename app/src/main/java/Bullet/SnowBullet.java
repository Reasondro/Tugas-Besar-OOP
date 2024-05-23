package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class SnowBullet {

    private int damage;
    private boolean wornOut = false;

    public SnowBullet(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isWornOut() {
        return wornOut;
    }

    public void setWornOut(boolean wornOut) {
        this.wornOut = wornOut;
    }

    public void hit(Petak p) {

        synchronized (p) {
            for (Zombie z : p.getZombies()) {
                z.reduceHealth(getDamage());
                z.setFrozenTimer(3);
                if (z.isFrozen() == false) {
                    z.setFrozen(true);
                    z.setWalkSpeedInSeconds(z.getWalkSpeedInSeconds() * 2);
                }
            }
        }
        setWornOut(true);

    }

}
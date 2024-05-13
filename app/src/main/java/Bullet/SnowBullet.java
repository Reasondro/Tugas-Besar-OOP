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

    public void hit(Petak p)
    {
           for(Zombie z : p.getZombies())
           {
            int originalHealth = z.getHealth();
            z.reduceHealth(getDamage());
            z.setFrozenTimer(3);
            if(z.isFrozen() == false)
            {
                z.setFrozen(true);
                z.setWalkSpeed(z.getWalkSpeed() / 2);
            }
            System.out.printf("Hit %s with damage %d\n", z.getName(), getDamage());
            System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
            System.out.printf("%s is frozen\n", z.getName());
            System.out.printf("%s's walk speed is now %f\n", z.getName(), z.getWalkSpeed());
            
           }
           setWornOut(true);

    }
    
}

package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class KernelBullet {

    private int damage;
    private boolean stopzomb = false;
    private boolean isButter = false; // To track if the bullet is butter
    private long lastShotTime; // To track the time of the last shot

    public KernelBullet(int damage) {
        this.damage = damage;
        this.lastShotTime = System.currentTimeMillis(); // Initialize the last shot time
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

    public boolean isButter() {
        return isButter;
    }

    public void setButter(boolean isButter) {
        this.isButter = isButter;
    }

    public void hit(Petak p) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastShotTime) >= 5000) { // Check if 5 seconds have passed
            setButter(true);
            lastShotTime = currentTime; // Reset the timer
        } else {
            setButter(false);
        }

        for (Zombie z : p.getZombies()) {
            if (isButter()) {
                z.reduceHealth(getDamage()); // Apply damage
                z.setFrozenTimer(10); // Set frozen timer for 10 seconds
                if (!z.isFrozen()) {
                    z.setFrozen(true);
                }
            } else {
                z.reduceHealth(getDamage()); // Apply damage with corn kernel
            }
            System.out.printf("Hit %s with damage %d\n", z.getName(), getDamage());
        }

        setStopZomb(true);
    }
}

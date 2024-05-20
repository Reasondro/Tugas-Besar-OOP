package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class KernelBullet extends Bullet {

    private int damage;
    private boolean stopzomb = false;
    private boolean isButter = false; // Untuk melacak apakah peluru adalah mentega

    private long lastShotTime; // TUntuk melacak waktu tembakan terakhir

    public KernelBullet(int damage) {
        super(damage);
        this.damage = damage;
        this.lastShotTime = System.currentTimeMillis(); 
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
        if ((currentTime - lastShotTime) >= 5000) { // Cek apakah 5 detik telah berlalu
            setButter(true);
            lastShotTime = currentTime; // Reset  timer
        } else {
            setButter(false);
        }

        for (Zombie z : p.getZombies()) {
            if (isButter()) {
                z.reduceHealth(getDamage()); // Apply damage
                if (!z.isFrozen()) {
                    z.setFrozen(true);
                    z.setFrozenTimer(10); // Set frozen timer for 10 seconds
                }
                System.out.printf("Hit %s with butter causing freeze\n", z.getName());
            } else {
                z.reduceHealth(getDamage()); // Apply damage with corn kernel
                System.out.printf("Hit %s with corn kernel causing damage %d\n", z.getName(), getDamage());
            }
        }

        setStopZomb(true);
    }
}

package Bullet;
import Petak.Petak;

public abstract class Bullet {

    private int damage;
    private boolean wornOut = false;

    public Bullet(int damage) {
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

    public abstract void hit(Petak petak);

    
}

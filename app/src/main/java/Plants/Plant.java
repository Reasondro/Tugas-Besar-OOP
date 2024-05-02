package Plants;

import Position.*;
// import PlantAbility.*;
import Creature.*;


public abstract class Plant extends Creature {

    private int cost;
    private int range;
    private int cooldown;
    Position pos;

    //TODO tambahin input user buat ngatur posisi di konstruktor (ga default 0 , 0)

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, Position pos )
    {

        super(name, health, attack_damage, attack_speed);
        this.cost = cost;
        this.range = range;
        this.cooldown = cooldown;
        this.pos = pos;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void reduceCooldown()
    {
        cooldown--;
    }


    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }


    public void displayStatus()
    {
        System.out.println("Name: " + getName());
        System.out.println("Cost: " + getCost());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("Attack Speed: " + getAttackSpeed());
        System.out.println("Range: " + getRange());
        System.out.println("Cooldown: " + getCooldown());
        System.out.printf("Position: X = %d, Y = %d\n", pos.getX(), pos.getY());
    }

}

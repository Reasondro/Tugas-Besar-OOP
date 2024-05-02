package Zombies;
import Position.*;
import Creature.*;


public abstract class Zombie extends Creature{


    private int walkSpeed;
    private boolean is_aquatic;
    private Position pos;

    //TODO tambahin input user buat ngatur posisi di konstruktor (ga default 0 , 0)

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, Position pos)
    {
        super(name, health, attack_damage, attack_speed);
        this.walkSpeed = 5;
        this.is_aquatic = is_aquatic;
        this.pos = pos;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public boolean isIs_aquatic() {
        return is_aquatic;
    }

    public void setIs_aquatic(boolean is_aquatic) {
        this.is_aquatic = is_aquatic;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void attack(); //TODO masukin logic yg kmrin ke attack sini
    public void walk(); //TODO ini sama aku aja yg walk


    public void displayStatus()
    {
        System.out.println("Name: " +  getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("Attack Speed: " + getAttackSpeed());
        System.out.println("Is Aquatic: " + isIs_aquatic());
        System.out.printf("Position: X = %d, Y = %d\n", pos.getX(), pos.getY());
    }

}

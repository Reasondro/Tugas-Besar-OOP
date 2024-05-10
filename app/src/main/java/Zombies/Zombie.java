package Zombies;

import Creature.*;
import Position.*;

import Plants.Plant;


public abstract class Zombie extends Creature{


    private float walkSpeed;
    private boolean aquatic;
    private boolean frozen = false;
    private float frozenTimer = 0;
    //TODO add Range as an attribute
  
    public Zombie(String name, int health, int attackDamage, float attackSpeed, int range, boolean aquatic, Position pos)
    {
        super(name, health, attackDamage, attackSpeed, range, pos);
        this.walkSpeed = 5;
        this.aquatic = aquatic;
   
    }

    public float getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(float walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public void setAquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public float getFrozenTimer() {
        return frozenTimer;
    }

    public void setFrozenTimer(float frozenTimer) {
        this.frozenTimer = frozenTimer;
    }

    public void reduceFrozenTimer()
    {
        if(frozenTimer < 0)
        {
            return;
        }
        else if(frozenTimer == 0)
        {
            setFrozen(false);
            setWalkSpeed(5);
        }
        else if(frozenTimer > 0)
        {
            frozenTimer--;
        }

    }



    public void attackPlant(Plant p)
    {
        p.reduceHealth(getAttackDamage());
    }

    // public void walk(); //TODO ini sama aku aja yg walk


    public void displayStatus()
    {
        System.out.println("Name: " +  getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("Attack Speed: " + getAttackSpeed());
        System.out.println("Range: " + getRange());
        System.out.println("Is Aquatic: " + isAquatic());
        System.out.println("Walk Speed: " + getWalkSpeed());
        System.out.println("Is Frozen: " + isFrozen());
        System.out.println("Frozen Timer: " + getFrozenTimer());
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }

}

package Zombies;

import Creature.*;
import Position.*;

import Plants.Plant;
import GameMap.GameMap;
import Petak.Petak;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;


public abstract class Zombie extends Creature
{

    private float walkSpeedInSeconds = 5.0f;
    private float walkTimer = 0;
    private boolean aquatic;
    private boolean frozen = false;
    private float frozenTimer = 0;
  
    public Zombie(String name, int health, int attackDamage, float attackSpeed, int range, boolean aquatic, Position pos)
    {
        super(name, health, attackDamage, attackSpeed, range, pos);
        this.aquatic = aquatic;
   
    }

    public float getWalkSpeedInSeconds() {
        return walkSpeedInSeconds;
    }

    public void setWalkSpeedInSeconds(float walkSpeedInSeconds) {
        this.walkSpeedInSeconds = walkSpeedInSeconds;
    }

    public float getWalkTimer() {
        return walkTimer;
    }

    public void setWalkTimer(float walkTimer) {
        this.walkTimer = walkTimer;
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
            setWalkSpeedInSeconds(5);
        }
        else if(frozenTimer > 0)
        {
            frozenTimer--;
        }

    }

    public boolean isPlantsInSamePetak()
    {
        return !(GameMap.getInstance().getPetak(getPos()).getPlants().isEmpty());
    }

    public void attackPlant(List<Plant> plants)
    {
        for(Plant p : plants)
        {
            int originalHealth = p.getHealth();
            p.reduceHealth(getAttackDamage());
            System.out.printf("%s attacked %s with damage %d\n", getName(), p.getName(), getAttackDamage());
            System.out.printf("%s went from %d HP to %d HP\n", p.getName(), originalHealth, p.getHealth());
        }
        setAttackTimer(getAttackSpeed());
    }

    public void checkToAttack()
    {
        if(getAttackTimer() == 0)
        {
            attackPlant(GameMap.getInstance().getPetak(getPos()).getPlants());
            setAttackTimer(getAttackSpeed());
        }
        else if(getAttackTimer() > 0)
        {
            setAttackTimer(getAttackTimer()-1);
        }
    }

    public void walk()
    {
        GameMap map = GameMap.getInstance();
        Position pos = getPos();
        
        GameMap.getInstance().getPetak(pos).removeCreature(this);
        pos.setY(pos.getY() - 1);
        GameMap.getInstance().getPetak(pos).addCreature(this);

        setWalkTimer(getWalkSpeedInSeconds());
    }

    public void checkToWalk()
    {
        if(getWalkTimer() == 0)
        {
            walk();
        }
        else if(getWalkTimer() > 0)
        {
            setWalkTimer(getWalkTimer()-1);
        }
    }


    public void refreshCreature()
    {
        super.refreshCreature();
        //TODO implement this method with Threading
        reduceFrozenTimer();
    }

    public void displayStatus()
    {
        System.out.println("Name: " +  getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("Attack Speed: " + getAttackSpeed());
        System.out.println("Range: " + getRange());
        System.out.println("Is Aquatic: " + isAquatic());
        System.out.println("Walk Speed: " + getWalkSpeedInSeconds());
        System.out.println("Is Frozen: " + isFrozen());
        System.out.println("Frozen Timer: " + getFrozenTimer());
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }

}

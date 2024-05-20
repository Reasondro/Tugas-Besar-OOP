package Creature;

import GameMap.GameMap;
import Position.*;



//TODO Make position an attribute of Creature
//TODO Clean the attributes and methods of this class

public abstract class Creature {
    private String name;
    private int health;
    private int attackDamage;
    private float attackSpeed;
    private float attackTimer = 0;
    private Position pos;
    private int range;

    //TODO add Range as an attribute

    
    // Constructor
    public Creature(String name, int health, int attackDamage, float attackSpeed, int range, Position pos) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.pos = pos.copyPos();

    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    public void reduceHealth(int damage) {
        health -= damage;

        if(health <= 0)
        {
            health = 0;
            GameMap.getInstance().getPetak(pos).removeCreature(this);
        }
    }
    
    public int getAttackDamage() {
        return attackDamage;
    }
    
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(float attackTimer) {
        this.attackTimer = attackTimer;
        if(attackTimer < 0)
        {
            this.attackTimer = 0;
        }
    }

    public void reduceAttackTimer()
    {
      
        if(attackTimer < 0)
        {
            return;
        }
        else if(attackTimer == 0)
        {
            setAttackTimer(attackSpeed);
        }
        else if(attackTimer > 0)
        {
            attackTimer--;
        }

    }
    

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    // public void refreshCreature()
    // {
    //     //TODO implement this method with Threading
    //     reduceAttackTimer();
    // }
    
}

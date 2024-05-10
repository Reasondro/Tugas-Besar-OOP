package Creature;

import Position.*;



//TODO Make position an attribute of Creature
//TODO Clean the attributes and methods of this class

public abstract class Creature {
    private String name;
    private int health;
    private int attackDamage;
    private int attackSpeed;
    private Position pos;

    
    // Constructor
    public Creature(String name, int health, int attackDamage, int attackSpeed, Position pos) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.pos = pos;

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
    }
    
    public int getAttackDamage() {
        return attackDamage;
    }
    
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
    
}

package Creature;


//TODO Make position an attribute of Creature
//TODO Clean the attributes and methods of this class

public abstract class Creature {
    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;

    
    // Constructor
    public Creature(String name, int health, int attack_damage, int attack_speed) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;

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
        return attack_damage;
    }
    
    public void setAttackDamage(int attack_damage) {
        this.attack_damage = attack_damage;
    }

    public int getAttackSpeed() {
        return attack_speed;
    }

    public void setAttackSpeed(int attack_speed) {
        this.attack_speed = attack_speed;
    }
    
}

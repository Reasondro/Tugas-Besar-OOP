package Zombies;

import Creature.*;
import Position.*;

import Plants.Plant;


public abstract class Zombie extends Creature{


    private int walkSpeed;
    private boolean aquatic;
    private boolean frozen = false;
    private int frozenTimer = 0;
  
    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean aquatic, Position pos)
    {
        super(name, health, attack_damage, attack_speed, pos);
        this.walkSpeed = 5;
        this.aquatic = aquatic;
   
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public void setaquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public int getFrozenTimer() {
        return frozenTimer;
    }

    public void setFrozenTimer(int frozenTimer) {
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
        System.out.println("Is Aquatic: " + isAquatic());
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return health;
    }

    public void setAttackDamage(int attack_damage){
        this.attack_damage = attack_damage;
    }

    public int getAttackDamage(){
        return attack_damage;
    }

    public void setAttackSpeed(int attack_speed){
        this.attack_speed = attack_speed;
    }

    public int getAttackSpeed(){
        return attack_speed;
    }

    public void setAquatic(boolean is_aquatic){
        this.is_aquatic = is_aquatic;
    }

    public boolean getAquatic(){
        return is_aquatic;
    }

    public void setPosition(Positition pos){
        this.pos = pos;
    }

    public Positition getPosition(){
        return pos;
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
        System.out.println("Is Aquatic: " + isAquatic());
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }
    
}

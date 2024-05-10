package Plants;

import Creature.*;
import Position.*;



public abstract class Plant extends Creature {

    private int cost;
    // private int range;
    private float cooldown;
    private float originalCooldown;
    // private boolean isPlanted = false;
    


    public Plant(String name, int cost, int health, int attackDamage, float attackSpeed, int range, float cooldown, Position pos )
    {

        super(name, health, attackDamage, attackSpeed,range , pos);
        this.cost = cost;
        // this.range = range;
        this.cooldown = cooldown;
        this.originalCooldown = cooldown;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // public int getRange() {
    //     return range;
    // }

    // public void setRange(int range) {
    //     this.range = range;
    // }

    public float getCooldown() {
        return cooldown;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
    }

    public void reduceCooldown()
    {
        if(cooldown<0)
        {
            return;
        }
        else if(cooldown == 0)
        {
            refreshCooldown();
        }
        else if(cooldown > 0) //TODO implement a way so if user haven't planted the plant/card yet, the cooldown will not be reduced
        {
        cooldown--;
        }
        
    }

    public void refreshCooldown()
    {
        cooldown = originalCooldown;;
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
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }
// #TES
    public void reduceCooldown(){
        cooldown-= 1;
    }

    public void specialAbility(Zombie z){
        z.decreaseHP(this);
    }

    public void attackZombie(Zombie z)
    {
        z.reduceHealth(getAttackDamage());
    }
    
    
    public void decreaseHP(Zombie z){
        health -= z.getAttack_damage();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth (int health) throws Exception{
        if (health > 0){
            this.health = health;
        } else {
            throw new Exception(String.format("Health sudah mencapai batas bawah, yaitu 0"));
        }
    }


    public int getAttack_damage(){
        return attack_damage;
    }

    public void setAttack_damage(int attack_damage){
        this.attack_damage = attack_damage;
    }

    public int getAttack_speed(){
        return attack_speed;
    }

    public void setAttack_speed(int attack_speed){
        this.attack_speed = attack_speed;
    }

    public int getRange(){
        return range;
    }

    public void setRange(int range){
        this.range = range;
    }
    
    public int getCooldown(){
        return cooldown;
    }

    public void setCooldown(int cooldown) throws Exception{
        if (cooldown > 0){
            this.cooldown = cooldown;
        }else {
            throw new Exception(String.format("Cooldown sudah mencapai batas bawah, yaitu 0"));
        }
    }

    public Positition getPos(){
        return pos;
    }

    public void setPos(Positition pos){
        this.pos = pos;
    }
}
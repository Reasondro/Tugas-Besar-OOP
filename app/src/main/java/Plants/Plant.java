package Plants;

import Position.*;
import Zombies.Zombie;
import Abilities.*;


public abstract class Plant  implements Ability {

    private String name;
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    Positition pos;

    //TODO tambahin input user buat ngatur posisi di konstruktor (ga default 0 , 0)

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, Positition pos )
    {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
        this.pos = pos;
    }

    public void displayStatus()
    {
        System.out.println("Name: " + name);
        System.out.println("Cost: " + cost);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Range: " + range);
        System.out.println("Cooldown: " + cooldown);
        System.out.printf("Position: X = %d, Y = %d\n", pos.getX(), pos.getY());
    }

    public void reduceCooldown(){
        cooldown-= 1;
    }

    public void specialAbility(Zombie zomb){
        zomb.decreaseHP(this);
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

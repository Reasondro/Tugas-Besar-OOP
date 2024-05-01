package Zombies;
import Position.*;

public abstract class Zombie implements Abilities.Ability{

    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;
    private Positition pos;

    //TODO tambahin input user buat ngatur posisi di konstruktor (ga default 0 , 0)

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, Positition pos)
    {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
        this.pos = pos;
    }

    public void displayStatus()
    {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Is Aquatic: " + is_aquatic);
        System.out.printf("Position: X = %d, Y = %d\n", pos.getX(), pos.getY());
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

    public void decreaseHP(Plant plant){
        health -= plant.getAttack_damage();
    }
    
}

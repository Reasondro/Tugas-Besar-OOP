package Zombies;
import Position.*;

public abstract class Zombie implements Abilities.Ability{

    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;
    private Position pos;

    //TODO tambahin input user buat ngatur posisi di konstruktor (ga default 0 , 0)

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic, Position pos)
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

}

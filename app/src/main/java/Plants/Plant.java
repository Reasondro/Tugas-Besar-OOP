package Plants;

import Position.*;
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

}

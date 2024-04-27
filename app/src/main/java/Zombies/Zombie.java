package Zombies;

public abstract class Zombie {

    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;

    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic)
    {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
    }

    public void displayStatus()
    {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack Damage: " + attack_damage);
        System.out.println("Attack Speed: " + attack_speed);
        System.out.println("Is Aquatic: " + is_aquatic);
    }

}

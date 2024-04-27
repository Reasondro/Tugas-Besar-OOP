package Plants;

public abstract class Plant {
    
    private String name;
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown )
    {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
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
    }

}

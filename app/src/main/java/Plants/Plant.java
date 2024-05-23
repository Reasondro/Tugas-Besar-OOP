package Plants;

import Creature.*;
import Position.*;
import PlantAbility.PlantAbility;



public abstract class Plant extends Creature {

    private int cost;

    private float cooldown;
    private float originalCooldown;
    private Position position;

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

    public void refreshPlant()
    {
        // refreshCooldown();
        if(getHealth() > 0)
        {
            if(this instanceof PlantAbility)
            {
                ((PlantAbility) this).checkToUseAbility();
            }
        } 
    }


    public void displayStatus()
    {
        System.out.println("Name: " + getName());
        System.out.println("Cost: " + getCost());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack Damage: " + getAttackDamage());
        System.out.println("Attack Speed: " + getAttackSpeed());
        System.out.println("Range: " + getRange());
        System.out.println("Attack timer: " + getAttackTimer());
        System.out.println("Range: " + getRange());
        System.out.println("Cooldown: " + getCooldown());
        System.out.printf("Position: X = %d, Y = %d\n", getPos().getX(), getPos().getY());
    }

    // public void setPos(Position newPosition){
    //     if (this.position != null) {
    //         this.position.getPlants().remove(this);
    //     }
    //     this.position = newPosition;
    //     if (newPosition != null) {
    //         newPosition.addPlant(this);
    //     }  
    // }

}
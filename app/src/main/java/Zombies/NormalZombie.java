package Zombies;

public class NormalZombie extends Zombie{

    public NormalZombie()
    {
        super("Normal Zombie", 125, 100, 1, false);
    }

    @Override
    public void useAbility()
    {
        System.out.println("Normal Zombie walks slowly.");
    }
    
}

package Zombies;

public class DuckyTubeZombie extends Zombie{
    public DuckyTubeZombie()
    {
        super("Ducky Tube Zombie", 200, 100, 1, false);
    }

    @Override
    public void useAbility()
    {
        System.out.println("Ducky Tube Zombie floats on water!");
    }
}

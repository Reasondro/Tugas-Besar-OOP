package Zombies;

import Position.Position;

public class DuckyTubeZombie extends Zombie{
    public DuckyTubeZombie()
    {
        super("Ducky Tube Zombie", 200, 100, 1, false,  new Position(0, 0));
    }

    @Override
    public void useAbility()
    {
        System.out.println("Ducky Tube Zombie floats on water!");
    }
}

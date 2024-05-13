package Zombies;

import Position.Position;
import ZombieAbility.*;

public class FootballZombie extends Zombie implements ZombieAbility {
    public FootballZombie()
    {
        super("Football Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility(){
        System.out.println("Football Zombie is kicking the ball to the plant!");
    }
}

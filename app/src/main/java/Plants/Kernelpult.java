package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class Kernelpult extends Plant implements PlantAbility{
   
    private List<Zombie> targets = new ArrayList<>();
    private int shotCounter = 0; // Counter to track shots

    public Kernelpult()
    {
        super("Kernelpult", 200, 300, 100, 6, -1, 10, new Position(0, 0));
    }

    public void setTargets(List<Zombie> targets)
    {
        this.targets = targets;
    }

    public void addTarget(Zombie z)
    {
        targets.add(z);
    }

    public void removeTarget(Zombie z)
    {
        targets.remove(z);
    }

    @Override
    public void useAbility()
    {
        for (Zombie z : targets)
        {
            if (shotCounter == 5) // Every 5 shots, switch to butter, this butter will freeze zombie
            {
                z.reduceHealth(getAttackDamage()); // Apply damage
                z.setFrozenTimer(10); // Set frozen timer for 10 seconds
                if (!z.isFrozen())
                {
                    z.setFrozen(true);
                shotCounter = 0; // Reset counter after shooting butter
            }
            else
            {
                z.reduceHealth(getAttackDamage()); // Apply damage with corn kernel
            }
        }
        shotCounter++;
    }
    }

    @Override
    public void checkToUseAbility()
    {
        // Implementation for checking whether to use the ability (e.g., if there are zombies in range)
    }
}


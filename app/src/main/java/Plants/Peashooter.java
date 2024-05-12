package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;
import Bullet.Bullet;
import Bullet.PeaBullet;
import java.util.List;
import java.util.ArrayList;
import GameMap.GameMap;
import Petak.Petak;


public class Peashooter extends Plant implements PlantAbility{

    
    private List<Zombie> targets = new ArrayList<>();
    private PeaBullet bullet;

    
    public Peashooter()
    {
        super("Peashooter", 100, 100, 25, 1, -1, 10,  new Position(0, 0));
        bullet =  new PeaBullet(getAttackDamage());
    }


    
    @Override
    public void useAbility( )
    {
        List<Petak> reachablePetak =  GameMap.getInstance().getRowBasedOnPlantRange(this);
        for(Petak p : reachablePetak)
        {
            if(!(bullet.isWornOut()))
            {
             bullet.hit(p);
            }
            else
            {
                break;
            }
        }

    }

}

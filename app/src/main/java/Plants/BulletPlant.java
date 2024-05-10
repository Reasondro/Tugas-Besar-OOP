package Plants;
import Position.Position;
import PlantAbility.*;
import Zombies.Zombie;
import Bullet.Bullet;
import GameMap.GameMap;
import Petak.Petak;

import java.util.List;
import java.util.ArrayList;


public class BulletPlant extends Plant implements PlantAbility{

    private Bullet bullet;

    public BulletPlant()
    {
        super("Bullet Plant", 100, 100, 100, 1, 3, 10,  new Position(0, 0));
        bullet = new Bullet(getAttackDamage(), getRange());
    }

    public Bullet getBullet()
    {
        return bullet;
    }

    @Override
    public void useAbility()
    {
        // List<Petak> row=  GameMap.getInstance().getRow(getAttackDamage())

        
    }

    
}

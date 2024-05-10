package Plants;
import Position.Position;
import PlantAbility.*;
import Zombies.Zombie;
import Bullet.Bullet;


public class BulletPlant extends Plant implements PlantAbility{

    private Bullet bullet;

    public BulletPlant()
    {
        super("Bullet Plant", 100, 100, 100, 1, -1, 10,  new Position(0, 0));
        bullet = new Bullet(getAttackDamage(), getRange());
    }

    public Bullet getBullet()
    {
        return bullet;
    }

    @Override
    public void useAbility()
    {
        
    }

    
}

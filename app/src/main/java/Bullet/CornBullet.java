package Bullet;
import Petak.Petak;
import Zombies.Zombie;

public class CornBullet extends Bullet{
    public CornBullet(int damage)
        {
            super(damage);
        }
        @Override
        public void hit(Petak p)
        {
            synchronized(p)
            {
               for(Zombie z : p.getZombies())
               {
                z.reduceHealth(getDamage());
               }
            }
               setWornOut(true);
           }
}

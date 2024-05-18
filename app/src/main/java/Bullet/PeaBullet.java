package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class PeaBullet extends Bullet{

        public PeaBullet(int damage)
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
        //    else //? use this if want to test the bullet when there is no zombie in the petak
        //    {
        //        System.out.println("No zombie in this petak");
        //    }
        }
        
}

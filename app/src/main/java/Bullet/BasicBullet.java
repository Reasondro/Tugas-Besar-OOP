package Bullet;
import Petak.Petak;
import Zombies.Zombie;

public class BasicBullet extends Bullet{
    
        public BasicBullet(int damage)
        {
            super(damage);
        }
        @Override
        public void hit(Petak p)
        {
               for(Zombie z : p.getZombies())
               {
                int originalHealth = z.getHealth();
                z.reduceHealth(getDamage());
                System.out.printf("Hit %s with damage %d\n", z.getName(), getDamage());
                System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
               }
               setWornOut(true);
           }
        //    else //? use this if want to test the bullet when there is no zombie in the petak
        //    {
        //        System.out.println("No zombie in this petak");
        //    }
}

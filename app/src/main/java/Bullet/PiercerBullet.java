package Bullet;

import Petak.Petak;
import Zombies.Zombie;

public class PiercerBullet extends Bullet{

        public PiercerBullet(int damage)
        {
            super(damage);
        }
        @Override
        public void hit(Petak p)
        {
               for(Zombie z : p.getZombies())
               {
<<<<<<< HEAD
                int originalHealth = z.getHealth();
=======
                // int originalHealth = z.getHealth();
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b
                z.reduceHealth(getDamage());
                // System.out.printf("Hit %s with damage %d\n", z.getName(), getDamage());
                // System.out.printf("%s went from %d HP to %d HP\n", z.getName(), originalHealth, z.getHealth());
               }
            //    setWornOut(true); ini ga perlu supaya bullet dari piercer ini nembus zombie 
        //    else //? use this if want to test the bullet when there is no zombie in the petak
        //    {
        //        System.out.println("No zombie in this petak");
        //    }
        }
<<<<<<< HEAD
        
}
=======
<<<<<<<< HEAD:app/src/main/java/Bullet/SquashBullet.java
    
========
        
>>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b:app/src/main/java/Bullet/PiercerBullet.java
}
>>>>>>> d1d3d9d98fedf774e86cd3e8fb13c850b32fde4b

package Zombies;

public class BucketheadZombie extends Zombie{

    public BucketheadZombie()
    {
        super("Buckethead Zombie", 300, 100, 1, false);
    }

    @Override
    public void useAbility()
    {
        System.out.println("Buckethead Zombie has a bucket on its head!");
    }
    
}

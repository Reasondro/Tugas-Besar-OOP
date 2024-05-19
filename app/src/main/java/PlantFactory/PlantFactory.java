package PlantFactory;
import Plants.Plant;

public abstract class PlantFactory {
    private static int plantCount = 0;

    private String factoryName;
    private float factoryCooldown;
    private float cooldownTimer;
    private boolean ready;

    public PlantFactory(String factoryName, float factoryCooldown)
    {
        this.factoryName = factoryName;
        this.factoryCooldown = factoryCooldown;
        this.cooldownTimer = 0;
        this.ready = true;
    }

    public abstract Plant createPlant();

    public static int getPlantCount()
    {
        return plantCount;
    }

    public static void incrementPlantCount()
    {
        plantCount++;
    }

    public static void decrementPlantCount()
    {
        plantCount--;
    }

    public String getFactoryName()
    {
        return factoryName;
    }

    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }

    public float getFactoryCooldown()
    {
        return factoryCooldown;
    }

    public boolean isReady()
    {
        return ready;
    }

    public void setReady(boolean ready)
    {
        this.ready = ready;
    }

    public float getCooldownTimer()
    {
        return cooldownTimer;
    }


    public void setCooldownTimer(float cooldownTimer)
    {
        this.cooldownTimer = cooldownTimer;
    }

    public void addCooldownTimer()
    {
        cooldownTimer += 1;
    }

    public void reduceCooldownTimer()
    {
        cooldownTimer -= 1;
    
    }

    public void checkToChangeCooldown()
    {
        if (cooldownTimer > 0 )
        {
            reduceCooldownTimer();
        }

        else if(cooldownTimer < factoryCooldown && !ready)
        {
            addCooldownTimer();
        }
        
    }

    public void refreshFactory()
    {
        checkToChangeCooldown();

        if (cooldownTimer == 0 && !ready)
        {
            setReady(true);
        }
    }

    public void displayStatus()
    {
        System.out.println(factoryName + " cooldown: " + cooldownTimer + "/" + factoryCooldown + " Ready: " + ready);
    }

}

package PlantFactory;

import Plants.Plant;

public abstract class PlantFactory {
    private static int plantCount = 0;

    private String factoryName;
    private float factoryCooldown;
    private float cooldownTimer;
    private boolean ready;
    private boolean aquatic;
    private int cost;

    public PlantFactory(String factoryName, float factoryCooldown, boolean aquatic, int cost) {
        this.factoryName = factoryName;
        this.factoryCooldown = factoryCooldown;
        this.cooldownTimer = 0;
        this.ready = true;
        this.aquatic = aquatic;
        this.cost = cost;
    }

    public abstract Plant createPlant();

    public static int getPlantCount() {
        return plantCount;
    }

    public static void incrementPlantCount() {
        plantCount++;
    }

    public static void decrementPlantCount() {
        plantCount--;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public float getFactoryCooldown() {
        return factoryCooldown;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public void setAquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getCooldownTimer() {
        return cooldownTimer;
    }

    public void setCooldownTimer(float cooldownTimer) {
        this.cooldownTimer = cooldownTimer;
    }

    public void addCooldownTimer() {
        cooldownTimer += 1;
    }

    public void reduceCooldownTimer() {
        cooldownTimer -= 1;
        if (cooldownTimer <= 0) {
            cooldownTimer = 0;
            setReady(true);
        }

    }

    public void checkToChangeCooldown() {
        if (cooldownTimer > 0) {
            reduceCooldownTimer();
        }

        else if (cooldownTimer < factoryCooldown && !isReady()) {
            addCooldownTimer();
        }

    }

    public void refreshFactory() {
        checkToChangeCooldown();
    }

    public void displayStatus() {
        System.out.println(factoryName + " cooldown: " + cooldownTimer + "/" + factoryCooldown + " Ready: " + ready);
    }

}
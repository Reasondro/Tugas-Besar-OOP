package Sun;

public class Sun {
    
    //TODO make a list of suns in the game and implement it dengan sun class ato Sunflower

    private static volatile Sun instance = null;
    private static int sunPoints;
    
    private Sun()
    {
        sunPoints = 50;
    }

    public static Sun getInstance() {
        if (instance == null) {
            synchronized (Sun.class) {
                if (instance == null) {
                    instance = new Sun();
                }
            }
        }
        return instance;
    }

    public synchronized int getSunPoints()
    {
        return sunPoints;
    }
    
    public synchronized void addSunPoints(int sunPoints)
    {
        Sun.sunPoints += sunPoints;
    }
    
    public synchronized void subtractSunPoints(int sunPoints)
    {
        Sun.sunPoints -= sunPoints;
    }
    
    public void setSunPoints(int sunPoints)
    {
        Sun.sunPoints = sunPoints;
    }

    public void resetSunPoints()
    {
        Sun.sunPoints = 50;
    }

    public static void displayStatus()
    {
        System.out.println("Sun points: " + sunPoints);
    }


}

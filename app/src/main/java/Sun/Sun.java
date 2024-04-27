package Sun;

public class Sun {
    
    private static int sunPoints;
    
    public Sun()
    {
        sunPoints = 25;
    }
    
    public int getSunPoints()
    {
        return sunPoints;
    }
    
    public void addSunPoints(int sunPoints)
    {
        Sun.sunPoints += sunPoints;
    }
    
    public void subtractSunPoints(int sunPoints)
    {
        Sun.sunPoints -= sunPoints;
    }
    
    public void setSunPoints(int sunPoints)
    {
        Sun.sunPoints = sunPoints;
    }
    
    public void updateSunPoints()
    {
        sunPoints += 25;
    }
    
    public void updateSunPoints(int sunPoints)
    {
        Sun.sunPoints += sunPoints;
    }
    
    public void updateSunPoints(int sunPoints, int sunPoints2)
    {
        Sun.sunPoints += sunPoints;
        Sun.sunPoints += sunPoints2;
    }


}

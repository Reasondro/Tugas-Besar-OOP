package Position;

public class Positition {
    
    private int x;
    private int y;

    public Positition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // public void displayPos()
    // {
    //     System.out.println("X: " + x + " Y: " + y);
    // }
     
}

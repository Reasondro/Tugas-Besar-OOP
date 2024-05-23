package Position;
import java.util.ArrayList;
import java.util.List;
import Plants.Plant;

public class Position {
    
    private int x;
    private int y;
    private List<Plant> plants;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.plants = new ArrayList<>();
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

    public Position copyPos()
    {
        return new Position(x, y);
    }

    public void removePos()
    {
        this.x = -99;
        this.y = -99;
    }

    public void displayPos()
    {
        System.out.println("X: " + x + " Y: " + y);
    }
     
}

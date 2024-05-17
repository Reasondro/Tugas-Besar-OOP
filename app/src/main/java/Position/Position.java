package Position;
import java.util.ArrayList;
import java.util.List;
import Plants.Plant;

public class Position {
    
    private int x;
    private int y;
    private List<Plant> plants;
    private boolean aquatic;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.aquatic = aquatic;
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

    // dua method di bawah ini untuk mendapatkan semua tanaman di petak yang sama --> used for coffeebean karena dia akan mengali 2 damage tanaman dipetak sama
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public boolean isAquatic(){
        return aquatic;
    }
}
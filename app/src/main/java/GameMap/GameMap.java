package GameMap;

import java.util.*;
import Petak.Petak;
import Position.Position;
import Creature.Creature;
import Zombies.Zombie;
import Plants.Plant;

public class GameMap {

    private static volatile GameMap instance = null;
    
    private Petak[][] map;
    private int rows = 6;
    private int columns = 11;

    private List<Petak> zombieBase = new ArrayList<>();
    private List<Petak> zombieBaseDummy = new ArrayList<>();
    
    private GameMap()
    {

        map = new Petak[rows][columns];

        //? NOTE: The map is 11 columns x 6 rows (including the protected base and zombie base)
        
        for(int i = 0; i < rows; i++) 
        {
            for(int j = 0; j < 1; j++) {
                Position pos = new Position(i+1, -99); //! -99 is a mark for protected base
                map[i][j] = new Petak("Protected", pos);
            }
        }

     
        for(int i = 0; i < 2; i++) 
        {
            for(int j = 1; j <= 9; j++) {
                Position pos = new Position(i+1, j);
                map[i][j] = new Petak("Normal", pos);
            }
        }
        for(int i = 2; i < 4; i++) 
        {
            for(int j = 1; j <= 9; j++) {
                Position pos = new Position(i+1, j);
                map[i][j] = new Petak("Pool", pos);
            }
        }
        for(int i = 4; i < 6; i++) 
        {
            for(int j = 1; j <= 9; j++) {
                Position pos = new Position(i+1, j);
                map[i][j] = new Petak("Normal", pos);
            }
        }

                
        for(int i = 0; i < rows; i++) 
        {
            for(int j = 0; j < 1; j++) {
                int x = i+1;
                Position pos = new Position(x, 10); //! 10 is a mark for zombie base
                if(x  == 1 || x == 2 || x == 5 || x == 6)
                {
                    map[i][10] = new Petak("Zombie Base", pos);
                }
                else
                {
                    map[i][10] = new Petak("Aquatic Zombie Base", pos);
                }
                zombieBase.add(map[i][10]);
            }
        }   
    }

    public static GameMap getInstance()
    {
        if(instance == null)
        {
            synchronized(GameMap.class)
            {
                if(instance == null)
                {
                    instance = new GameMap();
                }
            }
        }
        return instance;
    }

    //? NOTE: Petak efektif untuk player mulai dari [0][1] (baris 1 kolom 1) sampai [5][9] (baris 6 kolom 9)
    //? NOTE: Petak asli mulai dari [0][0] (baris 1 kolom -99/Protected) sampai [5][10] (baris 6 kolom 10/Zombie Base)


    //? NOTE : This is a test function
    // public void printTest()
    // {
    //     map[5][10].printPos();
    //     map[5][10].printType();
    // }

    public void printMap()
    {
        for(int i = 0; i < rows; i++) 
        {
            for(int j = 0; j < columns; j++) {
             
                if(j == columns-1)
                {
                    map[i][j].printCreatures();
                    System.out.println();
                }
                else
                {
                    map[i][j].printCreatures();
                    System.out.print(", ");
                }
            }
        }
    }

    public List<Petak> getRow(int row)
    {
        List<Petak> rowList = new ArrayList<>();
        for(int i = 0; i < columns; i++)
        {
            rowList.add(map[row][i]);
        }
        return rowList;
    }

    public List<Petak> getRowBasedOnPlantRange(Plant p) //TODO use only Creature Parameter
    {
        List<Petak> rowList = new ArrayList<>();
        Position pos = p.getPos();
        int range = p.getRange();
        
        int row = pos.getX()-1;
        int column = pos.getY();

        if(range == -1) //? if -1 then it has unlimited range
        {

            for(int i = column; i < columns; i++)
            {
                if(map[row][i].getPos().getY() == -99 || map[row][i].getPos().getY() == 10)
                {
                    break;
                }
                    rowList.add(map[row][i]);
            }
        }
        else
        {
          for(int i = column; i <= column+range; i++)
            {
                if(map[row][i].getPos().getY() == -99 || map[row][i].getPos().getY() == 10)
                {
                    break;
                }
            
                    rowList.add(map[row][i]);
            }
        }


        return rowList;
    }



    public Petak getPetakInFrontOfZombie(Zombie z) 
    {
      
        Position zombiePos = z.getPos();
        
        Position inFrontOfZombiePos = new Position(zombiePos.getX(), zombiePos.getY()-1);
        Petak inFrontOfZombiePetak = GameMap.getInstance().getPetak(inFrontOfZombiePos);

        return inFrontOfZombiePetak;
    }

    public List<Petak> getColumn(int column)
    {
        List<Petak> columnList = new ArrayList<>();
        for(int i = 0; i < rows; i++)
        {
            columnList.add(map[i][column]);
        }
        return columnList;
    }

    public Petak getPetak(Position pos)
    {
        int x = pos.getX()-1;
        int y = pos.getY();
        
        //? preveent horizontal movement to go out of bounds
        if(y < 1)
        {
            y = 0;
        }
        return map[x][y];
    }
    
    public void refreshMap()
    {
        for(int i = 0; i < rows; i++) 
        {
            for(int j = 0; j < columns; j++) {
                map[i][j].refreshPetak();
            }
        }
    }

    public boolean isZombieBaseEmpty()
    {
        boolean empty = true;
        
        for(int i = 0; i < rows; i++) 
        {
            if(!(map[i][10].getZombies().isEmpty()))
            {
                empty = false;
                break;
            }
        }

        return empty;
    }

    public boolean isProtectedBaseCompromised()
    {
        boolean compromised = false;
        
        for(int i = 0; i < rows; i++) 
        {
            if(!(map[i][0].getZombies().isEmpty()))
            {
                compromised = true;
                System.out.println("Protected Base is compromised! Game Over!");
                break;
            }
        }
        return compromised;
    }

    public List<Petak> getZombieBase()
    {
        return zombieBase;
    }

    public List<Petak> getZombieBaseDummy()
    {
        return zombieBaseDummy;
    }
    


}


package GameMap;

import java.util.*;
import Petak.Petak;
import Position.Position;

public class GameMap {
    
    private Petak[][] map;
    private int rows = 6;
    private int columns = 11;
    
    public GameMap()
    {

        map = new Petak[rows][columns];

        //? NOTE: The map is 11 columns x 9 rows (including the protected base and zombie base)
        
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
                Position pos = new Position(i+1, 99); //! 99 is a mark for zombie base
                map[i][10] = new Petak("Zombie Base", pos);
            }
        }   
    }

    //? NOTE: Petak efektif untuk player mulai dari [0][1] (baris 1 kolom 1) sampai [5][9] (baris 6 kolom 9)
    //? NOTE: Petak asli mulai dari [0][0] (baris 1 kolom -99/Protected) sampai [5][10] (baris 6 kolom 99/Zombie Base)


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

    public Petak getPetak(Position pos)
    {
        return map[pos.getX()-1][pos.getY()];
    }


}


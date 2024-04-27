package Map;

import java.util.*;

public class Map {
    
    private int[][] map;
    private int rows;
    private int columns;
    
    public Map(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        map = new int[rows][columns];
    }
    
    public void printMap()
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void setMap(int row, int column, int value)
    {
        map[row][column] = value;
    }
    
    public int getMap(int row, int column)
    {
        return map[row][column];
    }
    
    public int getRows()
    {
        return rows;
    }
    
    public int getColumns()
    {
        return columns;
    }
    
    public void resetMap()
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                map[i][j] = 0;
            }
        }
    }
    
    public boolean isMapEmpty()
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(map[i][j] != 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isRowEmpty(int row)
    {
        for(int i = 0; i < columns; i++)
        {
            if(map[row][i] != 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isColumnEmpty(int column)
    {
        for(int i = 0; i < rows; i++)
        {
            if(map[i][column] != 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean isRowFull(int row)
    {
        for(int i = 0; i < columns; i++)
        {
            if(map[row][i] == 0)
            {
                return false;
            }
        }
        return true;
    }
    

}

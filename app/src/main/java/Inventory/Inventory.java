package Inventory;

import PlantFactory.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.HashMap;
import Deck.Deck;
public class Inventory {

    private  Map<String, PlantFactory> inventory; 

    public Inventory()
    {
        inventory = new HashMap<String, PlantFactory>();
        inventory.put("Peashooter", new PeashooterFactory());
        inventory.put("Sunflower", new SunflowerFactory());
        inventory.put("Snowpea", new SnowpeaFactory());
        inventory.put("Squash", new SquashFactory());
        inventory.put("Wallnut", new WallnutFactory());
    }

    public PlantFactory getPlantFactory(String plantName)
    {
        return inventory.get(plantName);
    }

    public void printInventory()
    {
        for (Map.Entry<String, PlantFactory> entry : inventory.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void addToDeck(Deck<PlantFactory> deck, String plantName)
    {
        PlantFactory plantFactory = getPlantFactory(plantName);
        deck.addCard(plantFactory);
    }

    public void removeFromDeck(Deck<PlantFactory> deck, String plantName)
    {
        PlantFactory plantFactory = getPlantFactory(plantName);
        deck.removeCard(plantFactory);
    }

    
    
    
}

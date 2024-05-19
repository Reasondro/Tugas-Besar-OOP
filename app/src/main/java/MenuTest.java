
import PlantFactory.*;


import Inventory.Inventory;
import Deck.Deck;

public class MenuTest {

    public static void main(String[] args)
    {
        Inventory myInventory = new Inventory();
        Deck<PlantFactory> myDeck = new Deck<PlantFactory>();

        myInventory.printInventory();

        myInventory.swapPlantInInventory(1, 2);
        
        System.out.println("After swapping in inventory");
        myInventory.printInventory();

        myInventory.addCardToDeckWithIndex(myDeck, 1);
        myInventory.addCardToDeckWithIndex(myDeck, 2);
        myInventory.addCardToDeckWithIndex(myDeck, 3);

        myDeck.printDeck();
        myInventory.swapCardInDeck(myDeck, 1, 2);
        myInventory.addCardToDeckWithIndex(myDeck, 3);
        myInventory.removeCardFromDeckWithIndex(myDeck, 3);
        myDeck.printDeck();

       


    
    }
}




    // LilypadFactory lilypadFactory = new LilypadFactory();
        // PeashooterFactory peashooterFactory = new PeashooterFactory();
        // SunflowerFactory sunflowerFactory = new SunflowerFactory();
        // SnowpeaFactory snowpeaFactory = new SnowpeaFactory();
        // SquashFactory squashFactory = new SquashFactory();
        // WallnutFactory wallnutFactory = new WallnutFactory();

        // List<PlantFactory> plantFactories = new ArrayList<PlantFactory>();
        // plantFactories.add(lilypadFactory);
        // plantFactories.add(peashooterFactory);
        // plantFactories.add(sunflowerFactory);
        // plantFactories.add(snowpeaFactory);
        // plantFactories.add(squashFactory);
        // plantFactories.add(wallnutFactory);


        // for(PlantFactory plantFactory : plantFactories)
        // {
        //     plantFactory.createPlant();
        // }

        // for(PlantFactory plantFactory : plantFactories)
        // {
        //     plantFactory.displayStatus();
        // }

        // System.out.println("After refresh 10 times");

        // for(PlantFactory plantFactory : plantFactories)
        // {

        //     for(int i = 0; i < 10; i++)
        //     {
        //         plantFactory.refreshFactory();
        //     }
        // }

        // for(PlantFactory plantFactory : plantFactories)
        // {
        //     plantFactory.displayStatus();
        // }
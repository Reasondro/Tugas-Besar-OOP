import java.util.Scanner;

import GameMap.GameMap;
import Inventory.Inventory;
import Deck.Deck;
import PlantFactory.PlantFactory;
import Plants.Plant;
import Sun.Sun;
import Threads.*;

public class GameAle{
    public static void main(String[] args)
    {
        GameMap map = GameMap.getInstance();
        Inventory myInventory = Inventory.getInstance();

        Deck<PlantFactory> myDeck = Deck.getInstance();

        long  dayStart = 0;
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        String userInput;
    

        while(isRunning)
        {
            Thread plantThread = new Thread(PlantThread.getInstance());
            Thread zombieThread = new Thread(ZombieThread.getInstance());
            userInput = input.nextLine();

           if(userInput.equalsIgnoreCase("START"))
            {
                plantThread = new Thread(PlantThread.getInstance());
                zombieThread =new Thread(ZombieThread.getInstance());
                // myInventory = Inventory.getInstance();
                // myDeck = Deck.getInstance();

                dayStart = System.currentTimeMillis();
                plantThread.start();
                zombieThread.start();
            }
            else if(userInput.equalsIgnoreCase("STATUS"))
            {
                Sun.displayStatus();
            }
            else if(userInput.equalsIgnoreCase("STOP"))
            {
                plantThread.interrupt();
                zombieThread.interrupt();
                myDeck.clearDeck();
                map.resetMap();
            }
            else if(userInput.equalsIgnoreCase("PLANTING"))
            {

                if(myDeck.getMyCards().size() == 0) //todo pindahain ini ke planting di deck langsung
                {
                    System.out.println("You have no plants in your deck. Please add plants to your deck first.");
                    continue;
                }

                System.out.println("Choose the plant's index you want to plant:");
                myDeck.printDeck();
                System.out.print("Index: ");
                int index = Integer.parseInt(input.nextLine());

                System.out.println("Enter the row and column of the plant you want to plant: ");
                System.out.print("Row: ");
                int row = Integer.parseInt(input.nextLine());
                System.out.print("Column: ");
                int column = Integer.parseInt(input.nextLine());

                myDeck.planting(index, row, column);
                map.printMap();

            }
            else if(userInput.equalsIgnoreCase("PRINT INVENTORY"))
            {
                myInventory.printInventory();
            }
            else if(userInput.equalsIgnoreCase("ADD CARD TO DECK"))
            {
                myInventory.printInventory();
                
                System.out.println("Enter the index of the card you want to add to deck: ");
                int index =  Integer.parseInt(input.nextLine());

                myInventory.addCardToDeckWithIndex(myDeck, index);

                System.out.println("After adding to deck");
                myDeck.printDeck();
            }
            else if(userInput.equalsIgnoreCase("REMOVE CARD FROM DECK"))
            {
                myDeck.printDeck();

                System.out.println("Enter the index of the card you want to remove from deck: ");
                int index = Integer.parseInt(input.nextLine());

                myInventory.removeCardFromDeckWithIndex(myDeck, index);
                System.out.println("After removing from deck");
                myDeck.printDeck();

            }
            else if(userInput.equalsIgnoreCase("SWAP CARD IN DECK"))
            {
                myDeck.printDeck();

                System.out.println("Enter the index of the first card you want to swap: ");
                int index1 = Integer.parseInt(input.nextLine());

                System.out.println("Enter the index of the second card you want to swap: ");
                int index2 = Integer.parseInt(input.nextLine());
                myInventory.swapCardInDeck(myDeck, index1, index2);

                System.out.println("After swapping in deck");
                myDeck.printDeck();

            }
            else if(userInput.equalsIgnoreCase("SWAP CARD IN INVENTORY"))
            {
                myInventory.printInventory();

                System.out.println("Enter the index of the first plant you want to swap: ");
                int index1 = Integer.parseInt(input.nextLine());

                System.out.println("Enter the index of the second plant you want to swap: ");
                int index2 = Integer.parseInt(input.nextLine());
                myInventory.swapPlantInInventory(index1, index2);

                System.out.println("After swapping in inventory");
                myInventory.printInventory();

            }
            else if(userInput.equalsIgnoreCase("PRINT DECK"))
            {
                myDeck.printDeck();
            }
            else if(userInput.equalsIgnoreCase("PRINT MAP"))
            {
                final long currentTime = System.currentTimeMillis() - dayStart;
                final long elapsedSeconds = currentTime/1000;
                final long secondsDisplay = elapsedSeconds % 60;
                final long minutesDisplay = elapsedSeconds / 60;
                System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                map.printMap();
            }
            else if(userInput.equalsIgnoreCase("EXIT"))
            {
                isRunning = false;
            }
            else
            {
                System.out.println(userInput + " is not a valid command. Please try again.");
            }

        }
        input.close();
}
}



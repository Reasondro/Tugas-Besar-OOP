import java.util.Scanner;
import java.util.Timer;

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

        long  dayStart = TimerThread.getDayStart();
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        String userInput;
    
        Thread timerThread = new Thread(TimerThread.getInstance());
        Thread plantThread = new Thread(PlantThread.getInstance());
        Thread zombieThread = new Thread(ZombieThread.getInstance());

        boolean gameStarted = false;

        while(isRunning)
        {

            // long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
            // long elapsedSeconds = currentTime/1000;
            // long secondsDisplay = elapsedSeconds % 60;
            // long minutesDisplay = elapsedSeconds / 60;

            // if(!gameStarted)
            // {
            //     System.out.println("Click X to see the list of commands!");
            // }
            // else
            // {     

            // }

            System.out.print("Enter your command: ");
            userInput = input.nextLine();



           if( (userInput.equalsIgnoreCase("1")) && !gameStarted) //? Start the game
            {

                if(myDeck.getMyCards().size() < 6)
                {
                    System.out.println("Deck must have 6 cards to start the game.");
                    System.out.println("You only have " + myDeck.getMyCards().size() + " cards in your deck.");
                    continue;
                }
                
                timerThread = new Thread(TimerThread.getInstance());
                plantThread = new Thread(PlantThread.getInstance());
                zombieThread =new Thread(ZombieThread.getInstance());

                myInventory = Inventory.getInstance();
                myDeck = Deck.getInstance();
                
                timerThread.start();
                plantThread.start();
                zombieThread.start();
                dayStart = TimerThread.getDayStart();
                gameStarted = true;
            }
            else if(userInput.equalsIgnoreCase("2") && !gameStarted ) //? Print Inventory
            {
                myInventory.printInventory();
            }
            else if(userInput.equalsIgnoreCase("3") && !gameStarted) //? Swap Card in Inventory
            {
                myInventory.printInventory();

                System.out.print("Enter the index of the first plant you want to swap: ");
                int index1 = Integer.parseInt(input.nextLine());

                System.out.print("Enter the index of the second plant you want to swap: ");
                int index2 = Integer.parseInt(input.nextLine());
                myInventory.swapPlantInInventory(index1, index2);

                System.out.println("After swapping in inventory");
                myInventory.printInventory();

            }
            else if(userInput.equalsIgnoreCase("4")  && !gameStarted) //? Print Deck
            {
                myDeck.printDeck();
            }
            else if(userInput.equalsIgnoreCase("5") && !gameStarted) //? Add Card to Deck
            {
                myInventory.printInventory();
                
                System.out.print("Enter the index of the card you want to add to deck: "); 
                int index =  Integer.parseInt(input.nextLine());

                myInventory.addCardToDeckWithIndex(myDeck, index);

                System.out.println("After adding to deck");
                myDeck.printDeck();
            }
            else if(userInput.equalsIgnoreCase("6")  && !gameStarted) //? Remove Card from Deck
            {
                myDeck.printDeck();

                System.out.print("Enter the index of the card you want to remove from deck: ");
                int index = Integer.parseInt(input.nextLine());

                myInventory.removeCardFromDeckWithIndex(myDeck, index);
                System.out.println("After removing from deck");
                myDeck.printDeck();

            }
            else if(userInput.equalsIgnoreCase("7")  && !gameStarted) //? Swap Card in Deck
            {
                myDeck.printDeck();

                System.out.print("Enter the index of the first card you want to swap: ");
                int index1 = Integer.parseInt(input.nextLine());

                System.out.print("Enter the index of the second card you want to swap: ");
                int index2 = Integer.parseInt(input.nextLine());
                myInventory.swapCardInDeck(myDeck, index1, index2);

                System.out.println("After swapping in deck");
                myDeck.printDeck();

            }
            else if(userInput.equalsIgnoreCase("8")&& !gameStarted)
            {
                myInventory.addAllCardRandomly(myDeck);
                myDeck.printDeck();
            }

            else if((userInput.equalsIgnoreCase("quit")|| userInput.equalsIgnoreCase("9") || userInput.equalsIgnoreCase("exit")) && !gameStarted) //? Stop the program
            {
                isRunning = false;
            }
            else if(userInput.equalsIgnoreCase("X") && !gameStarted) //? Stop the program
            {
                System.out.println("List of commands: ");
                System.out.println("1. START - Start the game");
                System.out.println("2. PRINT INVENTORY - Print the inventory");
                System.out.println("3. SWAP CARD IN INVENTORY - Swap two cards in the inventory");
                System.out.println("4. PRINT DECK - Print the deck");
                System.out.println("5. ADD CARD TO DECK - Add a card to the deck");
                System.out.println("6. REMOVE CARD FROM DECK - Remove a card from the deck");
                System.out.println("7. SWAP CARD IN DECK - Swap two cards in the deck");
                System.out.println("8. FILL DECK - Fill the deck with random cards");
                System.out.println("9. STOP - STOP THE PROGRAM");
            }
            else if(userInput.equalsIgnoreCase("1") && gameStarted) //? Display the status of the game
            {
                long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                long elapsedSeconds = currentTime/1000;
                long secondsDisplay = elapsedSeconds % 60;
                long minutesDisplay = elapsedSeconds / 60;
                System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                Sun.displayStatus();
                myDeck.printDeck();
            }
            else if(userInput.equalsIgnoreCase("2") && gameStarted ) //? Plant a plant
            {
                
                System.out.println("Choose the plant's index you want to plant!"); 
                myDeck.printDeck();
                System.out.print("Index: ");
                int index = Integer.parseInt(input.nextLine());
                
                System.out.println("Enter the row and column of the plant you want to plant! ");
                System.out.print("Row: ");
                int row = Integer.parseInt(input.nextLine());
                System.out.print("Column: ");
                int column = Integer.parseInt(input.nextLine());
                
                myDeck.planting(index, row, column);
                
                long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                long elapsedSeconds = currentTime/1000;
                long secondsDisplay = elapsedSeconds % 60;
                long minutesDisplay = elapsedSeconds / 60;
                System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                map.printMap();
                
            }
            else if(userInput.equalsIgnoreCase("3") && gameStarted) //? Display the map
            {
                long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                long elapsedSeconds = currentTime/1000;
                long secondsDisplay = elapsedSeconds % 60;
                long minutesDisplay = elapsedSeconds / 60;
                System.out.println("Time right now "+ minutesDisplay + ":" + secondsDisplay);
                map.printMap();
            }
            else if(userInput.equalsIgnoreCase("4") && gameStarted) //? Exit the game
            {
                timerThread.interrupt();

                zombieThread.interrupt();
                plantThread.interrupt();
                
                myDeck.clearDeck();
                map.resetMap();
                gameStarted = false;
            }
            else if(userInput.equalsIgnoreCase("X") && gameStarted) //? Stop the program
            {
                System.out.println("List of commands: ");
                System.out.println("1. STATUS - Display the status of the game");
                System.out.println("2. PLANTING - Plant a plant");
                System.out.println("3. MAP - Display the map");
                System.out.println("4. EXIT - Exit the game");
            }
            else if(map.isProtectedBaseCompromised() && gameStarted) //? Game Over
            {
                timerThread.interrupt();
                plantThread.interrupt();
                zombieThread.interrupt();
                myDeck.clearDeck();
                map.resetMap();
                gameStarted = false;
                System.out.println("Protected Base is compromised! Game Over!");
            }
            else
            {
                System.out.println(userInput + " is not a valid command. Please try again.");
                System.out.println("You could click X to see the list of commands!");
            }
            
        }
        input.close();
    }
}



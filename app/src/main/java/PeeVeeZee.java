import java.util.Scanner;

import Creature.Creature;
import GameMap.GameMap;
import Inventory.Inventory;
import Petak.Petak;
import Deck.*;
import PlantFactory.PlantFactory;
import Position.Position;
import Sun.Sun;
import Threads.*;

public class PeeVeeZee {
    public static void main(String[] args)
            throws InvalidRowAtauColumn, Decknotfull, PlantingException, IndexOutDariBounds, RemoveDeckException,
            AddDeckException, SwapCardException, DiggingException {
        GameMap map = GameMap.getInstance();
        Inventory myInventory = Inventory.getInstance();

        Deck<PlantFactory> myDeck = Deck.getInstance();

        long dayStart = TimerThread.getDayStart();
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        String userInput;

        Thread timerThread = new Thread(TimerThread.getInstance());
        Thread plantThread = new Thread(PlantThread.getInstance());
        Thread zombieThread = new Thread(ZombieThread.getInstance());

        boolean gameStarted = false;

        System.out.println("Welcome to PeeVeeZee!");

        while (isRunning) {

            System.out.print("Enter your command: ");
            userInput = input.nextLine().trim();

            if (!gameStarted) // ? Game not started yet
            {
                try {
                    if ((userInput.equalsIgnoreCase("1"))) // ? Start the game
                    {
                        try {
                            if (myDeck.getMyCards().size() < 6) {
                                throw new Decknotfull();
                            }
                        } catch (Decknotfull e) {
                            System.out.println(e.getMessage());
                            System.out.println("You only have " + myDeck.getMyCards().size() + " cards in your deck.");
                            continue;
                        }

                        timerThread = new Thread(TimerThread.getInstance());
                        plantThread = new Thread(PlantThread.getInstance());
                        zombieThread = new Thread(ZombieThread.getInstance());

                        myInventory = Inventory.getInstance();
                        myDeck = Deck.getInstance();

                        timerThread.start();
                        plantThread.start();
                        zombieThread.start();
                        dayStart = TimerThread.getDayStart();
                        gameStarted = true;
                        System.out.println("Game Started!");
                    } else if (userInput.equalsIgnoreCase("2")) // ? Print Inventory
                    {
                        myInventory.printInventory();
                    } else if (userInput.equalsIgnoreCase("3")) // ? Swap Card in Inventory
                    {
                        myInventory.printInventory();

                        System.out.print("Enter the index of the first plant you want to swap: ");
                        int index1 = Integer.parseInt(input.nextLine());
                        try {
                            if (index1 < 1 || index1 > 10) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myInventory.printInventory();

                        System.out.print("Enter the index of the second plant you want to swap: ");
                        int index2 = Integer.parseInt(input.nextLine());
                        try {
                            if (index2 < 1 || index2 > 10) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myInventory.printInventory();

                        myInventory.swapPlantInInventory(index1, index2);

                        System.out.println("After swapping in inventory!");
                        myInventory.printInventory();

                    } else if (userInput.equalsIgnoreCase("4")) // ? Print Deck
                    {
                        myDeck.printDeck();
                    } else if (userInput.equalsIgnoreCase("5")) // ? Add Card to Deck
                    {
                        try {
                            if (myDeck.getMyCards().size() == 6) {
                                throw new AddDeckException();
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myInventory.printInventory();

                        System.out.print("Enter the index of the card you want to add to deck: ");
                        int index = Integer.parseInt(input.nextLine());
                        try {

                            if (index < 1 || index > 10) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myInventory.printInventory();

                        myInventory.addCardToDeckWithIndex(myDeck, index);

                        System.out.println("After adding to deck!");
                        myDeck.printDeck();

                    } else if (userInput.equalsIgnoreCase("6")) // ? Remove Card from Deck
                    {
                        try {
                            if (myDeck.getMyCards().size() == 0) {
                                throw new RemoveDeckException();
                            }
                        } catch (RemoveDeckException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.printDeck();

                        System.out.print("Enter the index of the card you want to remove from deck: ");
                        int index = Integer.parseInt(input.nextLine());
                        try {
                            if (index < 1 || index > 6) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.printDeck();

                        myInventory.removeCardFromDeckWithIndex(myDeck, index);
                        System.out.println("After removing from deck!");
                        myDeck.printDeck();

                    } else if (userInput.equalsIgnoreCase("7")) // ? Swap Card in Deck
                    {
                        myDeck.printDeck();

                        try {
                            if (myDeck.getMyCards().size() == 0) {
                                throw new SwapCardException();
                            }
                        } catch (SwapCardException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.printDeck();

                        System.out.print("Enter the index of the first card you want to swap: ");
                        int index1 = Integer.parseInt(input.nextLine());
                        try {
                            if (index1 < 1 || index1 > 6) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.printDeck();

                        System.out.print("Enter the index of the second card you want to swap: ");
                        int index2 = Integer.parseInt(input.nextLine());
                        try {
                            if (index2 < 1 || index2 > 6) {
                                throw new IndexOutDariBounds();
                            }
                        } catch (IndexOutDariBounds e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.printDeck();

                        myInventory.swapCardInDeck(myDeck, index1, index2);

                        System.out.println("After swapping in deck!");
                        myDeck.printDeck();

                    } else if (userInput.equalsIgnoreCase("8")) // ? Fill Deck with random cards
                    {
                        myInventory.addAllCardRandomly(myDeck);
                        myDeck.printDeck();
                    }

                    else if ((userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("9")
                            || userInput.equalsIgnoreCase("exit"))) // ? Stop the program
                    {
                        isRunning = false;
                    }

                    else if ((userInput.equalsIgnoreCase("X") || userInput.equalsIgnoreCase("HELP"))) // ? Stop the
                                                                                                      // program
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
                    } else // ? Invalid Command
                    {
                        throw new InvalidCommand();
                    }
                } catch (InvalidCommand e) {
                    System.out.println(userInput + e.getMessage());
                    System.out.println("You could type X/HELP to see the list of commands!");
                    continue;
                }
            } else {
                try {
                    if ((map.isProtectedBaseCompromised())) // ? Game Over
                    {
                        timerThread.interrupt();
                        plantThread.interrupt();
                        zombieThread.interrupt();
                        myDeck.clearDeck();
                        map.resetMap();
                        gameStarted = false;
                        System.out
                                .println("Nice try! You survived for " + TimerThread.getGlobalTimeElapsed()
                                        + " seconds!");
                    } else if ((ZombieThread.globalIsAllZombiesDead()
                            && (TimerThread.getGlobalTimeElapsed() > 21
                                    && TimerThread.getGlobalTimeElapsed() <= 160))) {
                        timerThread.interrupt();
                        plantThread.interrupt();
                        zombieThread.interrupt();
                        myDeck.clearDeck();
                        map.resetMap();
                        gameStarted = false;
                        System.out.println(
                                "Well played! You survived for " + TimerThread.getGlobalTimeElapsed() + " seconds!");
                        // System.out.println(TimerThread.getGlobalTimeElapsed());
                    }

                    else if (userInput.equalsIgnoreCase("1")) // ? Display the status of the game
                    {
                        long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                        long elapsedSeconds = currentTime / 1000;
                        long secondsDisplay = elapsedSeconds % 60;
                        long minutesDisplay = elapsedSeconds / 60;
                        System.out.println("Time right now " + minutesDisplay + ":" + secondsDisplay);
                        Sun.displayStatus();
                        myDeck.printDeck();
                    } else if (userInput.equalsIgnoreCase("2")) // ? Plant a plant
                    {
                        myDeck.printDeck();

                        int plantIndex;
                        int row;
                        int column;

                        System.out.println("Your sun points: " + Sun.getInstance().getSunPoints());
                        System.out.println("Choose a plant's index, row (1-6) and column(1-9)!");
                        System.out.println("Example: 1 2 3 (Plant index 1, row 2, column 3)");

                        try {

                            userInput = input.nextLine();
                            String[] parts = userInput.trim().split(" ");

                            if (parts.length == 3) {
                                plantIndex = Integer.parseInt(parts[0].trim());
                                row = Integer.parseInt(parts[1].trim());
                                column = Integer.parseInt(parts[2].trim());
                            } else {
                                System.out.println("Invalid input. Please try again.");
                                continue;
                            }

                            if (row < 1 || row > 6 || column < 1 || column >= 9) {
                                throw new InvalidRowAtauColumn();
                            }
                            Position pos = new Position(row, column);
                            Petak targetPetak = map.getPetak(pos);
                            if (targetPetak.getPlants().size() == 1) {
                                throw new PlantingException();
                            }
                        } catch (InvalidRowAtauColumn e) {
                            System.out.println(e.getMessage());
                            continue;
                        } catch (PlantingException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        myDeck.planting(plantIndex, row, column);

                        long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                        long elapsedSeconds = currentTime / 1000;
                        long secondsDisplay = elapsedSeconds % 60;
                        long minutesDisplay = elapsedSeconds / 60;
                        System.out.println("Time right now " + minutesDisplay + ":" + secondsDisplay);
                        map.printMap();

                    } else if (userInput.equalsIgnoreCase("3")) // ? Plant a plant
                    {

                        int row;
                        int column;

                        System.out.println("Choose the Petak's row (1-6) and column(1-9)!");
                        System.out.println("Example: 6 9 (Row 6, column 9)");

                        try {
                            userInput = input.nextLine();
                            String[] parts = userInput.trim().split(" ");

                            if (parts.length == 2) {
                                row = Integer.parseInt(parts[0].trim());
                                column = Integer.parseInt(parts[1].trim());
                            } else {
                                System.out.println("Invalid input. Please try again.");
                                continue;
                            }
                            if (row < 1 || row > 6 || column < 1 || column >= 9) {
                                throw new InvalidRowAtauColumn();
                            }

                            Position pos = new Position(row, column);
                            Petak targetPetak = map.getPetak(pos);
                            if (targetPetak.getPlants().size() == 0) {
                                throw new DiggingException();
                            }
                        } catch (InvalidRowAtauColumn e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        myDeck.digging(row, column);

                        long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                        long elapsedSeconds = currentTime / 1000;
                        long secondsDisplay = elapsedSeconds % 60;
                        long minutesDisplay = elapsedSeconds / 60;
                        System.out.println("Time right now " + minutesDisplay + ":" + secondsDisplay);
                        map.printMap();

                    } else if (userInput.equalsIgnoreCase("4")) // ? Display the map
                    {
                        long currentTime = TimerThread.getCurrentTime() - TimerThread.getDayStart();
                        long elapsedSeconds = currentTime / 1000;
                        long secondsDisplay = elapsedSeconds % 60;
                        long minutesDisplay = elapsedSeconds / 60;
                        System.out.println("Time right now " + minutesDisplay + ":" + secondsDisplay);
                        map.printMap();
                    } else if (userInput.equalsIgnoreCase("5")) // ? Exit the game
                    {
                        timerThread.interrupt();

                        zombieThread.interrupt();
                        plantThread.interrupt();

                        myDeck.clearDeck();
                        map.resetMap();
                        gameStarted = false;
                    } else if ((userInput.equalsIgnoreCase("X") || userInput.equalsIgnoreCase("HELP"))) // ? Stop the
                                                                                                        // program
                    {
                        System.out.println("List of commands: ");
                        System.out.println("1. STATUS - Display the status of the game");
                        System.out.println("2. PLANTING - Plant a plant");
                        System.out.println("3. DIGGING - Dig a petak");
                        System.out.println("4. MAP - Display the map");
                        System.out.println("5. EXIT - Exit the game");
                    } else // ? Invalid Command
                    {
                        throw new InvalidCommand();
                    }
                } catch (InvalidCommand e) {
                    System.out.println(userInput + e.getMessage());
                    System.out.println("You could type X/HELP to see the list of commands!");
                }
            }

        }
        input.close();
    }
}

class InvalidRowAtauColumn extends Exception {
    public String getMessage() {
        return "Invalid Row or Column!";
    }
}

class Decknotfull extends Exception {
    public String getMessage() {
        return "Deck must have 6 card to start the game !";
    }
}

class PlantingException extends Exception {
    public String getMessage() {
        return ("Cannot plant more than 1 plant in a petak!");
    }
}

class IndexOutDariBounds extends Exception {
    public String getMessage() {
        return ("Invalid Index!");
    }
}

class RemoveDeckException extends Exception {
    public String getMessage() {
        return ("Cannot remove an empty decks!");
    }
}

class AddDeckException extends Exception {
    public String getMessage() {
        return ("Cannot add to full decks!");
    }
}

class SwapCardException extends Exception {
    public String getMessage() {
        return ("cannot swap an empty decks!");
    }
}

class DiggingException extends Exception {
    public String getMessage() {
        return ("No plant in petak to dig!");
    }
}

class InvalidCommand extends Exception {
    public String getMessage() {
        return (" is not a valid command! Please try again.");
    }
}
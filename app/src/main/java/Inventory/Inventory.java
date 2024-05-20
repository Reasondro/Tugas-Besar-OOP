package Inventory;

import PlantFactory.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Deck.Deck;

public class Inventory {

    private static volatile Inventory instance = null;

    private List<PlantFactory> inventory;

    private Inventory() {
        inventory = new ArrayList<PlantFactory>();

        inventory.add(new PeashooterFactory());
        inventory.add(new SunflowerFactory());
        inventory.add(new SnowpeaFactory());
        inventory.add(new SquashFactory());
        inventory.add(new WallnutFactory());
        inventory.add(new LilypadFactory());

    }

    public static Inventory getInstance() {
        if (instance == null) {
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }

    public PlantFactory getPlantFactoryByIndex(int index) {
        int formattedIndex = index - 1;
        if (formattedIndex < 0 || formattedIndex >= inventory.size()) {
            System.out.println("Invalid index");
            return null;
        }
        return inventory.get(formattedIndex);
    }

    public void printInventory() {
        System.out.println("My Inventory: ");
        int index = 1;

        for (PlantFactory plantFactory : inventory) {
            System.out.println(index + ". " + plantFactory.getFactoryName());
            index++;
        }

    }

    public boolean isInDeck(Deck<PlantFactory> deck, PlantFactory plantFactory) {
        return deck.getMyCards().contains(plantFactory);
    }

    public void addCardToDeckWithIndex(Deck<PlantFactory> deck, int index) {
        int formattedIndex = index - 1;

        if (formattedIndex < 0 || formattedIndex >= inventory.size()) {
            System.out.println("Invalid index");
            return;
        }
        PlantFactory plantFactory = inventory.get(formattedIndex);
        if (isInDeck(deck, plantFactory)) {
            System.out.println(plantFactory.getFactoryName() + " already in deck");
            return;
        }
        deck.addCard(plantFactory);
    }

    public void addAllCardRandomly(Deck<PlantFactory> deck) {
        Random rand = new Random();
        while (deck.getMyCards().size() < 6) {
            int randomIndex = rand.nextInt(inventory.size());
            PlantFactory plantFactory = inventory.get(randomIndex);
            if (!isInDeck(deck, plantFactory)) {
                deck.addCard(plantFactory);
            }
        }
    }

    public void removeCardFromDeckWithIndex(Deck<PlantFactory> deck, int index) {
        deck.removeCardWithIndex(index);
    }

    public void swapPlantInInventory(int index1, int index2) {
        int formattedIndex1 = index1 - 1;
        int formattedIndex2 = index2 - 1;

        if (formattedIndex1 < 0 || formattedIndex1 >= inventory.size() || formattedIndex2 < 0
                || formattedIndex2 >= inventory.size()) {
            System.out.println("Invalid index");
            return;
        }

        PlantFactory plant1 = inventory.get(formattedIndex1); // ? because we start at 1 in game
        PlantFactory plant2 = inventory.get(formattedIndex2);
        inventory.set(formattedIndex1, plant2);
        inventory.set(formattedIndex2, plant1);

    }

    public void swapCardInDeck(Deck<PlantFactory> deck, int index1, int index2) {
        deck.swapCard(index1, index2);
    }

    public void clearInventory() {
        inventory.clear();
    }

}

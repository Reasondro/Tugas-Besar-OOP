package Inventory;

import java.util.ArrayList;
import java.util.List;

import Deck.Deck;
import Plants.BulletPlant;
import Plants.CoffeeBean;
import Plants.Kernelpult;
import Plants.Lilypad;
import Plants.Peashooter;
import Plants.Plant;
import Plants.PotatoMine;
import Plants.Snowpea;
import Plants.Squash;
import Plants.Sunflower;
import Plants.Tangle;
import Plants.Wallnut;

public class Inventory<T extends Plant> {
    List<T> inventory = new ArrayList<T>(10);
    List<Plant> myDeck = new ArrayList<Plant>(6);

    @SuppressWarnings("unchecked")
    public Inventory() {
        inventory.add((T) new CoffeeBean());
        inventory.add((T) new Lilypad());
        inventory.add((T) new Kernelpult());
        inventory.add((T) new Peashooter());
        inventory.add((T) new PotatoMine());
        inventory.add((T) new Snowpea());
        inventory.add((T) new Squash());
        inventory.add((T) new Sunflower());
        inventory.add((T) new Tangle());
        inventory.add((T) new Wallnut());
        inventory.add((T) new BulletPlant());
    }

    public void addToDeck(T plant) {
        myDeck.add(plant);
    }

    public void removeFromDeck(T plant) {
        myDeck.remove(plant);
    }

    public void swapPlant(int index1, int index2) {
        T plant1 = inventory.get(index1);
        T plant2 = inventory.get(index2);
        inventory.remove(index1);
        inventory.add(index1, plant2);

        inventory.remove(index2);
        inventory.add(index2, plant1);

    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (T plant : inventory) {
            System.out.println(plant.getName());
        }
    }

    public void displayDeck() {
        System.out.println("Deck:");
        for (Plant plant : myDeck) {
            System.out.println(plant.getName());
        }
    }

    public List<Plant> getDeck(Inventory<T> inventory) {
        return inventory.myDeck;

    }

}

class InventoryException extends Exception {
    public InventoryException(String message) {
        super(message);
    }
}

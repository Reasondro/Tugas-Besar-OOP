
import java.util.*;

import Deck.Deck;
import GameMap.GameMap;
import Inventory.Inventory;
import Petak.Petak;
import PlantFactory.LiliypadFactory;
import PlantFactory.SquashFactory;
import Plants.Lilypad;
import Plants.Peashooter;
import Plants.Plant;
import Plants.Squash;
import Position.Position;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Inventory
        Inventory<Plant> inventory = new Inventory<>();
        GameMap map = GameMap.getInstance();
        // Menampilkan isi inventory awal
        inventory.displayInventory();
        inventory.swapPlant(1, 5);
        System.out.println("--------------------------------------------------------------");
        inventory.displayInventory();
        Deck<Plant> myDeck = new Deck<Plant>(inventory);
        // Menambahkan beberapa tanaman ke deck
        Position posP11 = new Position(1, 1);
        Peashooter peashooter = new Peashooter();
        inventory.addToDeck(peashooter);
        Petak petakp11Petak = map.getPetak(posP11);
        myDeck.planting(peashooter, petakp11Petak, posP11);
        map.printMap();
        System.out.println("--------------------------------------------------------------");
        myDeck.digging(posP11);
        map.printMap();
        // Menambahkan tanaman yang sama ke deck lagi
        Lilypad lilypad = new Lilypad();
        inventory.addToDeck(lilypad);

        // Menampilkan isi deck
        inventory.displayDeck();
        inventory.removeFromDeck(lilypad);

        inventory.displayDeck();
        inventory.addToDeck(new Squash());
        inventory.displayDeck();

    }
}
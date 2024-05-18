
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
        List<Plant> listinventory = new ArrayList<Plant>(inventory.getLengthinventory());
        List<Plant> inventroyList = inventory.getInventory();
        GameMap map = GameMap.getInstance();
        // Menampilkan isi inventory awal

        Deck<Plant> myDeck = new Deck<Plant>(inventory);
        // Menambahkan beberapa tanaman ke deck
        Position posP11 = new Position(1, 1);
        Position posP34 = new Position(3, 4);
        Position posp42 = new Position(4, 2);
        Peashooter peashooter = new Peashooter();
        inventory.addToDeck(peashooter);
        SquashFactory squashFactory = new SquashFactory();
        Plant squash = squashFactory.createPlant();
        Petak petakp11Petak = map.getPetak(posP11);
        Petak petakp34Petak = map.getPetak(posP34);
        Petak petakp42Petak = map.getPetak(posp42);
        Petak petakp52Petak = map.getPetak(new Position(5, 2));
        Plant planttt = inventory.getInventory().get(0);

        inventory.displayInventory();
        myDeck.planting(inventory.getPlantInventory(1), petakp34Petak);
        inventory.swapPlant(1, 5);
        System.out.println("--------------------------------------------------------------");
        inventory.displayInventory();
        System.out.println("\n");
        for (Plant plantt : inventory.getInventory()) {
            System.out.println(plantt.getName());
        }
        myDeck.planting((inventory.getInventory().get(4)), petakp52Petak);
        myDeck.planting(peashooter, petakp11Petak);
        myDeck.planting((inventory.getInventory().get(1)), petakp34Petak);
        myDeck.planting((inventory.getPlantInventory(1)), petakp42Petak);
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
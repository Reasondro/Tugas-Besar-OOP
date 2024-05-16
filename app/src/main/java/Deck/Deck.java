package Deck;

import java.util.*;

import Creature.Creature;
import GameMap.GameMap;
import Inventory.Inventory;
import Petak.Petak;
import PlantFactory.CoffeeBeanFactory;
import PlantFactory.KernelpultFactory;
import PlantFactory.LiliypadFactory;
import PlantFactory.PeashooterFactory;
import PlantFactory.PotatoMineFactory;
import PlantFactory.SnowpeaFactory;
import PlantFactory.SquashFactory;
import PlantFactory.SunflowerFactory;
import PlantFactory.TangleFactory;
import PlantFactory.WallnutFactory;
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
import Position.Position;

public class Deck<T extends Plant> {

    // TODO implement Deck class with a list of plants/cards

    List<Plant> myDeck;
    private GameMap map;

    public Deck(Inventory<T> inventory) {
        myDeck = inventory.getDeck(inventory);
        map = GameMap.getInstance();
    }

    public void planting(Plant plant, Petak petakPlant, Position pos) {
        if (plant instanceof Lilypad) {
            LiliypadFactory lilypadfactory = new LiliypadFactory();
            Plant lilypad = lilypadfactory.createPlant();
            petakPlant.addCreature(lilypad);
        } else if (plant instanceof CoffeeBean) {
            CoffeeBeanFactory coffeeBeanFactory = new CoffeeBeanFactory();
            Plant coffeebean = coffeeBeanFactory.createPlant();
            petakPlant.addCreature(coffeebean);
        } else if (plant instanceof Kernelpult) {
            KernelpultFactory kernelpultFactory = new KernelpultFactory();
            Plant kernelpult = kernelpultFactory.createPlant();
            petakPlant.addCreature(kernelpult);
        } else if (plant instanceof Peashooter) {
            PeashooterFactory peashooterFactory = new PeashooterFactory();
            Plant peashooter = peashooterFactory.createPlant();
            petakPlant.addCreature(peashooter);
        } else if (plant instanceof PotatoMine) {
            PotatoMineFactory potatoMineFactory = new PotatoMineFactory();
            Plant potatomine = potatoMineFactory.createPlant();
            petakPlant.addCreature(potatomine);
        } else if (plant instanceof Snowpea) {
            SnowpeaFactory snowpeaFactory = new SnowpeaFactory();
            Plant snowpea = snowpeaFactory.createPlant();
            petakPlant.addCreature(snowpea);
        } else if (plant instanceof Squash) {
            SquashFactory squashFactory = new SquashFactory();
            Plant squash = squashFactory.createPlant();
            petakPlant.addCreature(squash);
        } else if (plant instanceof Sunflower) {
            SunflowerFactory sunflowerFactory = new SunflowerFactory();
            Plant sunflower = sunflowerFactory.createPlant();
            petakPlant.addCreature(sunflower);
        } else if (plant instanceof Tangle) {
            TangleFactory tangleFactory = new TangleFactory();
            Plant tangle = tangleFactory.createPlant();
            petakPlant.addCreature(tangle);
        } else if (plant instanceof Wallnut) {
            WallnutFactory wallnutFactory = new WallnutFactory();
            Plant wallnut = wallnutFactory.createPlant();
            petakPlant.addCreature(wallnut);
        }
    }

    public void digging(Position pos) {
        Petak petakDig = map.getPetak(pos);
        petakDig.removeAllPlants();
    }
    // TODO add swap methods
}

class DeckException extends Exception {
    public DeckException(String message) {
        super(message);
    }
}
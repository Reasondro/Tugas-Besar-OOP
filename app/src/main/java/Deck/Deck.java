package Deck;

import java.util.*;

import Creature.Creature;
import GameMap.GameMap;
import Inventory.Inventory;
import Petak.Petak;
import PlantFactory.CoffeeBeanFactory;
import PlantFactory.KernelpultFactory;
import PlantFactory.LilypadFactory;
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

    public void planting(Plant plant, Petak petakPlant) throws Exception {
        List<Creature> creatures = petakPlant.getCreatures();
        boolean planted = false;
        boolean isAquatic = false;
        boolean plantable = false;

        if (petakPlant.getPos().getX() == 3 || petakPlant.getPos().getX() == 4) {
            isAquatic = true;
        }

        for (Creature creature : creatures) {
            if (creature instanceof Plant) {
                planted = true;
                break;
            }
        }

        for (Creature creature : creatures) {
            if (creature instanceof Lilypad) {
                plantable = true;
                break;
            }
        }

        if (isAquatic && plantable && plant instanceof Lilypad) {
            throw new Exception("tidak bisa menanam lilypad pada lilypad");
        } else if (isAquatic && !plantable && !(plant instanceof Lilypad)) {
            throw new Exception("tidak bisa menanam tanaman ini di air");
        } else if (isAquatic && !plantable && plant instanceof Lilypad) {
            LilypadFactory lilypadFactory = new LilypadFactory();
            Plant lilypad = lilypadFactory.createPlant();
            petakPlant.addCreature(lilypad);
        } else if (isAquatic && plantable) {
            plantPlant(petakPlant, plant);
        } else if (!isAquatic && plant instanceof Lilypad) {
            throw new Exception("Tidak bisa menanam tanaman Lilypad di tanah");
        } else if (!isAquatic && planted) {
            throw new Exception("Petak tersebut telah ditanam tanaman lain");
        } else {
            plantPlant(petakPlant, plant);
        }
    }

    private void plantPlant(Petak petakPlant, Plant plant) throws Exception {
        if (plant instanceof CoffeeBean) {
            CoffeeBeanFactory factory = new CoffeeBeanFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Kernelpult) {
            KernelpultFactory factory = new KernelpultFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Peashooter) {
            PeashooterFactory factory = new PeashooterFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof PotatoMine) {
            PotatoMineFactory factory = new PotatoMineFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Snowpea) {
            SnowpeaFactory factory = new SnowpeaFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Squash) {
            SquashFactory factory = new SquashFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Sunflower) {
            SunflowerFactory factory = new SunflowerFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Tangle) {
            TangleFactory factory = new TangleFactory();
            petakPlant.addCreature(factory.createPlant());
        } else if (plant instanceof Wallnut) {
            WallnutFactory factory = new WallnutFactory();
            petakPlant.addCreature(factory.createPlant());
        } else {
            throw new Exception("Tanaman tidak dikenal");
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

class PetakHasPlanted extends DeckException {
    public PetakHasPlanted() {
        super("Petak tersebut telah ditanam tanaman lain");
    }
}
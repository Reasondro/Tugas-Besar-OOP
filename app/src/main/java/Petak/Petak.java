package Petak;

import Position.*;
import java.util.ArrayList;
import java.util.List;
import Creature.Creature;


public class Petak {

    private Position pos;
    private List<Creature> creatures;
    private String type; //? type of petak (Protected, Normal, Pool, ZombieSpawnArea)

    public Petak(String type ,Position pos) {
        this.pos = pos;
        this.type = type; //? TODO initialize pas generate map
        this.creatures = new ArrayList<>();
    }

    // Add a creature to the list
    public void addCreature(Creature creature) {
        creatures.add(creature);
        creature.setPos(pos);
    }

    // Remove a creature from the list
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    // Get all creatures in the petak
    public List<Creature> getCreatures() {
        return creatures;
    }
}






    


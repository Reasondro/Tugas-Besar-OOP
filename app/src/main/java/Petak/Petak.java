package Petak;

import Position.*;
import java.util.ArrayList;
import java.util.List;
import Creature.Creature;


public class Petak {

    Position pos;
    List<Creature> creatures;

    public Petak(Position pos) {
        this.pos = pos;
        this.creatures = new ArrayList<>();
    }

    // Add a creature to the list
    public void addCreature(Creature creature) {
        creatures.add(creature);
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






    


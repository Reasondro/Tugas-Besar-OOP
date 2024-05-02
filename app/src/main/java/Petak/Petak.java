package Petak;

import Position.*;
import java.util.ArrayList;
import java.util.List;
import Creature.Creature;


public class Petak {

    private String type; //? type of petak (Protected, Normal, Pool, ZombieSpawnArea)
    private Position pos;
    private List<Creature> creatures;

    public Petak(String type ,Position pos) {
        this.type = type; //? TODO initialize pas generate map
        this.pos = pos;
        this.creatures = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printType() {
        System.out.println("Petak type: " + type);
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

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void printPos() {
        System.out.println("Petak position: (Kolom = " + pos.getY() + ", Baris = " + pos.getX() + ")");
    }
    // public void printPos() {
    //     System.out.println("Petak position: (Baris = " + pos.getX() + ", Kolom = " + pos.getY() + ")");
    // }


    public void printCreature() {
        System.out.print("[");
        for (int i = 0; i < creatures.size(); i++) {
            System.out.print(creatures.get(i).getName());
            if (i < creatures.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}






    


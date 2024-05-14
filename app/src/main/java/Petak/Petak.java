package Petak;

import Position.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Creature.Creature;

import Zombies.Zombie;



public class Petak {

    private String type; //? type of petak (Protected, Normal, Pool, ZombieSpawnArea)
    private Position pos;
    private List<Creature> creatures =  new ArrayList<>();

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
    public void addCreature(Creature creature) //? TODO Allow Game logic to add the creature to petak
    {
        creatures.add(creature);
        creature.setPos(pos);
    }


    // Remove a creature from the list
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    // public void refreshPetak() {
    //     for (Creature creature : creatures) {
    //         if(creature.getHealth() == 0)
    //         {
                // System.out.println("Creature " + creature.getName() + " has been removed from the petak");
    //             removeCreature(creature);
    //         }
    //     }
    // }

    public void refreshPetak() //! obsolete, already implemented in Creature.reduceHealth()
    {
        Iterator<Creature> iterator = creatures.iterator();
        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            if (creature.getHealth() == 0) {
                iterator.remove();
            }
        }
    }

    // Get all creatures in the petak
    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<Zombie> getZombies() {
        List<Zombie> zombies = new ArrayList<>();
        for (Creature creature : creatures) {
            if (creature instanceof Zombie) {
                zombies.add((Zombie) creature);
            }
        }
        return zombies;
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


    public void printCreatures() {

        if(type == "Zombie Base")  //TODO Delete this if when implementing the zombie spawn logic
        {
            System.out.print("[Zombie Base]");
            return;
        }
        else if(type == "Protected") {
            System.out.print("[Protected]");
            return;
        }
        

        System.out.print("[");
        for (int i = 0; i < creatures.size(); i++) {
            System.out.print(creatures.get(i).getName());
            if (i < creatures.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}






    


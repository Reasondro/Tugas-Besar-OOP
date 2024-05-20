package Petak;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Creature.Creature;

import Zombies.Zombie;
import Plants.Plant;
import Position.Position;



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
    public void addCreature(Creature creature)
    {
        if(creature.getHealth() == 0)
        {
            return;
        }
        creatures.add(creature);
        creature.setPos(pos);
    }


    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void removeAllPlants() {
        Iterator<Creature> iterator = creatures.iterator();
        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            if (creature instanceof Plant) {
                iterator.remove();
            }
        }
    }

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

    public synchronized void resetPetak() {
        creatures.clear();
    }



    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<Zombie> getZombies() {
        List<Zombie> zombies = new ArrayList<>();
        List<Creature> creaturesCopy = new ArrayList<>(creatures);
        for (Creature creature : creaturesCopy) {
            if (creature instanceof Zombie) {
                zombies.add((Zombie) creature);
            }
        }
        return zombies;
    }

    public List<Plant> getPlants() {
        List<Plant> plants = new ArrayList<>();
        List<Creature> creaturesCopy = new ArrayList<>(creatures);
        for (Creature creature : creaturesCopy) {
            if (creature instanceof Plant) {
                plants.add((Plant) creature);
            }
        }
        return plants;
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

    public void printCreatures() {

        if(type == "Zombie Base")
        {
            System.out.print("[Zombie Base]");
            return;
        }
       else if(type == "Aquatic Zombie Base") 
        {
            System.out.print("[Aquatic Zombie Base]");
            return;
        }
        else if(type == "Protected") {
            System.out.print("[Protected, ");

            for (int i = 0; i < creatures.size(); i++) {
                System.out.print(creatures.get(i).getName() + " " + creatures.get(i).getHealth() + " " + creatures.get(i).getAttackTimer());
                if (i < creatures.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");

            return;
        }
        

        System.out.print("[");
        for (int i = 0; i < creatures.size(); i++) {
            
            System.out.print(creatures.get(i).getName() + " " + creatures.get(i).getHealth() + " " + creatures.get(i).getAttackTimer());
            if(creatures.get(i) instanceof Zombie)
            {
                System.out.print(" " + ((Zombie)creatures.get(i)).getWalkTimer());
            }
            if (i < creatures.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");

    }
}






    


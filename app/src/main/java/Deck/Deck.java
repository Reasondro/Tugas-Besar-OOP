package Deck;


import java.util.ArrayList;
import java.util.List;
import PlantFactory.PlantFactory;

import GameMap.GameMap;
import Petak.Petak;
import Position.Position;

import Plants.Plant;
import Threads.PlantThread;

public class Deck<T extends PlantFactory> {

    private static volatile Deck<PlantFactory> instance = null;

   private List<T> myCards;

    private Deck() 
    {
        myCards = new ArrayList<T>(6);
    }

    public static Deck<PlantFactory> getInstance() 
    {
        if (instance == null) 
        {
            synchronized (Deck.class) 
            {
                if (instance == null) 
                {
                    instance = new Deck<PlantFactory>();
                }
            }
        }
        return instance;
    }

    public void addCard(T card) {
        if (myCards.size() < 6) {
            myCards.add(card);
        }
    }

    public void removeCard(T card) {
        myCards.remove(card);
    }

    public void removeCardWithIndex(int index) {
        int formattedIndex = index - 1;
        if (formattedIndex < 0 || formattedIndex >= myCards.size()) {
            System.out.println("Invalid index");
            return;
        }
        myCards.remove(formattedIndex);
    }

    public void swapCard(int index1, int index2) {
        int formattedIndex1 = index1 - 1;
        int formattedIndex2 = index2 - 1;

        if (formattedIndex1 < 0 || formattedIndex1 >= myCards.size() || formattedIndex2 < 0 || formattedIndex2 >= myCards.size()) {
            System.out.println("Invalid index");
            return;
        }

        T card1 = myCards.get(formattedIndex1); //? because we start at 1 in game
        T card2 = myCards.get(formattedIndex2);
        myCards.set(formattedIndex1, card2);
        myCards.set(formattedIndex2, card1);
    }

    public List<T> getMyCards() {
        return myCards;
    }

    public void setMyCards(List<T> myCards) {
        this.myCards = myCards;
    }

    public void printDeck() 
    {
        System.out.println("My Deck: ");

        int index = 1;
        for (T card : myCards) 
        {
            System.out.println(index + ". " + card.getFactoryName() + " || Cooldown: " + card.getCooldownTimer() + " seconds left");
            index++;
        }
    }



    public void planting(int plantIndex, int Row, int Column) 
    {

        int formattedIndex = plantIndex - 1;
        if (formattedIndex < 0 || formattedIndex >= myCards.size()) {
            System.out.println("Invalid index");
            return;
        }

        T card = myCards.get(formattedIndex);
        if (card.isReady()) 
        {
            GameMap map = GameMap.getInstance();

            Position position = new Position(Row, Column);
            Petak targetPetak = map.getPetak(position);

            Plant newPlant = card.createPlant();
            PlantThread plantThread = PlantThread.getInstance();
            plantThread.addPlant(newPlant);
            targetPetak.addCreature(newPlant);
        }
         else 
        {
            System.out.println( card.getFactoryName() + " is still in cooldown" + " (" + card.getCooldownTimer() + " seconds left)");
        }
    }

    public void refresh() 
    {
        for (T card : myCards) 
        {
            card.checkToChangeCooldown();
        }
    }
    public void clearDeck() 
    
    {
        for (T card : myCards) 
        {
            card.setReady(true);
            card.setCooldownTimer(0);
        }
        
        myCards.clear();
    }

    
}

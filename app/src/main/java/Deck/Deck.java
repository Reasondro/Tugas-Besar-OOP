package Deck;

import Plants.Plant;
import java.util.ArrayList;
import java.util.List;

public class Deck<T> {

    //TODO implement Deck class with a list of plants/cards
    
   private List<T> myCards;

    public Deck() 
    {
        myCards = new ArrayList<T>(6);
    }

    public void addCard(T card) {
        if (myCards.size() < 6) {
            myCards.add(card);
        }
    }

    public void removeCard(T card) {
        myCards.remove(card);
    }

    public void swapCard(T card1, T card2) {
        int index1 = myCards.indexOf(card1);
        int index2 = myCards.indexOf(card2);
        myCards.set(index1, card2);
        myCards.set(index2, card1);
    }

    public List<T> getMyCards() {
        return myCards;
    }

    public void setMyCards(List<T> myCards) {
        this.myCards = myCards;
    }

    public void printDeck() {
        for (T card : myCards) {
            System.out.println(card);
        }
    }

    
}

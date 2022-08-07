// A stack of cards, there are 9 of them on the Arena

import java.util.ArrayList;

public class Pile extends DeckOfCards{
    private ArrayList<Card> pile;

    public Pile(){
        pile = new ArrayList<Card>();
    }

    public int getPileSize(){
        return pile.size();
    }

    public boolean isEmpty(){
        return pile.size() == 0;
    }

    public void addCard(Card c){
        pile.add(c);
    }

    public Card removeTopCard(){
        Card topCard = pile.get(pile.size()-1);
        pile.remove(pile.size()-1);
        return topCard;
    }

    public Card returnTopCard(){
        return pile.get(pile.size()-1);
    }

    @Override
    public String toString(){
        return pile.get(pile.size()-1).toString() + "(" + getPileSize() + "), ";
    }
}
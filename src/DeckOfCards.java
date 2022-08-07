// A stack of Card that represents the entire deck

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class DeckOfCards extends Card{
    public static final int numCards = 81;
    public static final int numQuantities = 3;
    // protected Stack<Card>deckOfCards;
    private ArrayList<Card> deckOfCards;
    
    
    public DeckOfCards(){
        List<String> quantities = Card.getValidQuantities(); //this is calling a static method
                                                    //so we do NOT need an instance of Card
                                                    //to call it
        List<String> fills = Card.getValidFills();
        List<String> colors = Card.getValidColors();
        List<String> shapes = Card.getValidShapes();
        
        
        deckOfCards = new ArrayList<Card>();
        for (String q : quantities){
            for (String f : fills){
                for (String c : colors){
                    for (String s : shapes){
                        deckOfCards.add(new Card(q,f,c,s));
                    }
                }
            }
        }    
        // List<String> suits = Card.getValidSuits(); //this is calling a static method
        //                                             //so we do NOT need an instance of Card
        //                                             //to call it
        // List<String> faceNames = Card.getValidFaceNames();

        // deckOfCards = new ArrayList<>();
        // for (String suit:suits)
        // {
        //     for (String faceName:faceNames)
        //         deckOfCards.add(new Card(faceName,suit));
        // }
    }

    public int getDeckSize(){
        return deckOfCards.size();
    }

    // public Card peekNextCard(){
    //     return deckOfCards.peek();
    // }

    public Card dealNextCard(){
        if (deckOfCards.size() > 0){
            Card nextCard = deckOfCards.remove(0);
            return nextCard;
        }
        else
            return null;
    }

    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    public String toString(){
        return Arrays.toString(deckOfCards.toArray());
    }
}
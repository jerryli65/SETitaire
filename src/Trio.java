// Consists of a Set d.s. that holds a SET!

// https://stackoverflow.com/a/3642843class 
// feels unnecessary, could just stick with 
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

public class Trio extends Card{
  private Card card1;
  private Card card2;
  private Card card3;
  private List<Card>trio;

  public Trio(){
    card1 = null;
    card2 = null;
    card3 = null;
    trio = new ArrayList<Card>();
  }

  public Trio(Card card1, Card card2, Card card3){
    this.card1 = card1;
    this.card2 = card2;
    this.card3 = card3;
    trio = new ArrayList<Card>();
    trio.add(this.card1);
    trio.add(this.card2);
    trio.add(this.card3);
  }

  public void setCard1(Card c1){
    card1 = c1;
  }

  public void setCard2(Card c2){
    card2 = c2;
  }

  public void setCard3(Card c3){
    card3 = c3;
  }

  public boolean isASet(){
  // algorithm of what is a set
  // check for "ALL 3 ARE SAME" of any of the features
    boolean sameQ = card1.getQuantity() == card2.getQuantity() && card1.getQuantity() == card3.getQuantity();
    boolean sameF = card1.getFill() == card2.getFill() && card1.getFill() == card3.getFill();
    boolean sameC = card1.getColor() == card2.getColor() && card1.getColor() == card3.getColor();
    boolean sameS = card1.getShape() == card2.getShape() && card1.getShape() == card3.getShape();

    // CHECK FOR "ALL 3 ARE DIFFERENT" for any of the features
    Set<String> setCheck = new HashSet<>();
    // Set<String> setF = new HashSet<>();
    // Set<String> setC = new HashSet<>();
    // Set<String> setS = new HashSet<>();

    setCheck.add(card1.getQuantity());
    setCheck.add(card2.getQuantity());
    setCheck.add(card3.getQuantity());
    boolean diffQ = (setCheck.size() == 3);

    setCheck.clear();

    setCheck.add(card1.getFill());
    setCheck.add(card2.getFill());
    setCheck.add(card3.getFill());
    boolean diffF = (setCheck.size() == 3);

    setCheck.clear();

    setCheck.add(card1.getColor());
    setCheck.add(card2.getColor());
    setCheck.add(card3.getColor());
    boolean diffC = (setCheck.size() == 3);

    setCheck.clear();

    setCheck.add(card1.getShape());
    setCheck.add(card2.getShape());
    setCheck.add(card3.getShape());
    boolean diffS = (setCheck.size() == 3);
    
    return (sameQ || diffQ) && (sameF || diffF) && (sameC || diffC) && (sameS || diffS);
  }

  public void clear(){
    for (int i = 0; i < trio.size(); i++){
      trio.remove(0);
    }
  }

  @Override
  public String toString(){
   return "[" + card1.toString() + ", " + card2.toString() + ", " + card3.toString() + "]"; 
    // String ret = "";
    // for (Card c : trio){
    //   ret += c.toString() + ", ";
    // }
    // return ret;

  }

  public static void main(String[]args){
    // dont know the syntax of this
    // Trio t = new Trio(new Card());

  }
}
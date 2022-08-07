// Represents an individual card with 4 properties

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
public class Card {
    // Card features
    // private Quantities quantity;
    // private Fills fill;
    // private Colors color;
    // private Shapes shape;

    private String quantity;
    private String fill;
    private String color;
    private String shape;

    private String faceName, suit;

    private Image image;

    static int numInits = 0;

    // public enum Quantities{
    //     ONE,
    //     TWO,
    //     THREE;
    // }

    // public enum Fills{
    //     SOLID,
    //     DASHED,
    //     EMPTY;
    // }

    // public enum Colors{
    //     RED,
    //     GREEN,
    //     PURPLE;
    // }

    // public enum Shapes{
    //     OVAL,
    //     SQUIGGLE,
    //     DIAMOND;
    // }

    public Card(){
        // this.quantity = Quantities.ONE;
        // this.fill = Fills.SOLID;
        // this.color = Colors.RED;
        // this.shape = Shapes.OVAL;
        this.quantity = "1";
        this.fill = "SOLID";
        this.color = "RED";
        this.shape = "OVAL";
    }
    public Card(String quantity, String fill, String color, String shape){
        this.quantity = quantity;
        this.fill = fill;
        this.color = color;
        this.shape = shape;

        //System.out.println(numInits++);
        String fileName = quantity + "_" + fill + "_" + color + "_" + shape + ".png";
        image = new Image("./images/"+fileName);

        // String fileName = "greensphere.png";
        // image = new Image("./images/" + fileName);

        
    }

    // public Card(String fn, String s){
    //     setFaceName(fn);
    //     setSuit(s);
    //     String fileName = fn + "_of_"+s+".png";
    //     image = new Image("./images/"+fileName);
    // }

    public String getQuantity(){
        return quantity;
    }

    public String getFill(){
        return fill;
    }

    public String getColor(){
        return color;
    }
    public String getShape(){
        return shape;
    }

    /**
     * This method returns a list of QUANTITIES that are valid for
     * Card objects
     */
    public static List<String> getValidQuantities()
    {
        return Arrays.asList("1", "2", "3");
    }

    public static List<String> getValidFills()
    {
        return Arrays.asList("SOLID", "EMPTY", "DASHED");
    }

    public static List<String> getValidColors()
    {
        return Arrays.asList("RED", "GREEN", "PURPLE");
    }

    public static List<String> getValidShapes()
    {
        return Arrays.asList("DIAMOND", "OVAL", "SQUIGGLE");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * This method will validate the argument and set the instance variable
     * @param faceName 2,3,4,5,6,7,8,9,10,jack,queen,king
     */
    // public void setFaceName(String faceName) {
    //     List<String> validFaceNames = getValidFaceNames();
    //     faceName = faceName.toLowerCase();

    //     if (validFaceNames.contains(faceName))
    //         this.faceName = faceName;
    //     else
    //         throw new IllegalArgumentException("Valid face names are: "+
    //                         validFaceNames);
    // }

    // public String getSuit() {
    //     return suit;
    // }

    /**
     * This method will return a list of valid suits
     * @return spades, hearts, clubs, diamonds
     */
    // public static List<String> getValidSuits()
    // {
    //     return Arrays.asList("hearts","diamonds","spades","clubs");
    // }

    // public void setSuit(String suit) {
    //     List<String> validSuits = getValidSuits();
    //     suit = suit.toLowerCase();

    //     if (validSuits.contains(suit))
    //         this.suit = suit;
    //     else
    //         throw new IllegalArgumentException("valid suits are: "+ validSuits);
    // }



    // public String toString(){
    //     return "" + getQuantity() + " " + getFill() + " " + getColor() + " " + getShape();
    // }

    public String toString(){
        return "" + getQuantity() + " " + getFill() + " " + getColor() + " " + getShape();
    }

    public static void main(String[] args) {
        Card c1 = new Card();
        System.out.println(c1.getImage());
    }
}
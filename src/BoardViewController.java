import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BoardViewController implements Initializable {

    @FXML private Button buttonDealCards;
    @FXML private ImageView activeCard1;
    @FXML private ImageView imageViewDeck;
    @FXML private Label labelCardsRemaining;
    @FXML private Label labelNumCardsRemain;
    @FXML private ImageView imageViewPile1;
    @FXML private ImageView imageViewPile2;
    @FXML private ImageView imageViewPile3;
    @FXML private ImageView imageViewPile4;
    @FXML private ImageView imageViewPile5;
    @FXML private ImageView imageViewPile6;
    @FXML private ImageView imageViewPile7;
    @FXML private ImageView imageViewPile8;
    @FXML private ImageView imageViewPile9;
    @FXML private TextField textFieldSetSubmit;
    @FXML private TextArea textAreaIsASet;
    @FXML private Label labelSetsFound;
    @FXML private Label labelNumSetsFound;
    private DeckOfCards deck;
    private Trio trio;
    private List<ImageView>listOfImageViewPiles;

    private List<List<Image>> listOfPileVisuals;
    public static int numberOfSetsFound;

    private List<Pile>listOfPiles;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deck = new DeckOfCards();
        deck.shuffleDeck();
 
        trio = new Trio();

        listOfImageViewPiles = new ArrayList<>();
        listOfImageViewPiles.add(imageViewPile1);
        listOfImageViewPiles.add(imageViewPile2);
        listOfImageViewPiles.add(imageViewPile3);
        listOfImageViewPiles.add(imageViewPile4);
        listOfImageViewPiles.add(imageViewPile5);
        listOfImageViewPiles.add(imageViewPile6);
        listOfImageViewPiles.add(imageViewPile7);
        listOfImageViewPiles.add(imageViewPile8);
        listOfImageViewPiles.add(imageViewPile9);

        numberOfSetsFound = 0;

        listOfPiles = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            listOfPiles.add(new Pile());
        }

        listOfPileVisuals = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            listOfPileVisuals.add(new ArrayList<Image>());
            listOfPileVisuals.get(i).add(new Image("./images/emptypile.png"));
        }

        //deckImageView.setImage(deck.getBackOfCardImage());
    }

    @FXML public void buttonDealCardsPushed()
    {
        Card nextCard = deck.dealNextCard();
        imageViewPile1.setImage(nextCard.getImage());
        listOfPiles.get(0).addCard(nextCard);
        listOfPileVisuals.get(0).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile2.setImage(nextCard.getImage());
        listOfPiles.get(1).addCard(nextCard);
        listOfPileVisuals.get(1).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile3.setImage(nextCard.getImage());
        listOfPiles.get(2).addCard(nextCard);
        listOfPileVisuals.get(2).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile4.setImage(nextCard.getImage());
        listOfPiles.get(3).addCard(nextCard);
        listOfPileVisuals.get(3).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile5.setImage(nextCard.getImage());
        listOfPiles.get(4).addCard(nextCard);
        listOfPileVisuals.get(4).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile6.setImage(nextCard.getImage());
        listOfPiles.get(5).addCard(nextCard);
        listOfPileVisuals.get(5).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile7.setImage(nextCard.getImage());
        listOfPiles.get(6).addCard(nextCard);
        listOfPileVisuals.get(6).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile8.setImage(nextCard.getImage());
        listOfPiles.get(7).addCard(nextCard);
        listOfPileVisuals.get(7).add(imageViewPile1.getImage());

        nextCard = deck.dealNextCard();
        imageViewPile9.setImage(nextCard.getImage());
        listOfPiles.get(8).addCard(nextCard);
        listOfPileVisuals.get(8).add(imageViewPile1.getImage());

        labelNumCardsRemain.setText(String.valueOf(deck.getDeckSize()));
    }

    @FXML
    void textFieldSetSubmitEntered(ActionEvent event) {
        String submission = textFieldSetSubmit.getText();
        
        String[] submittedCards = submission.trim().split("\\s+");

        int chosenPile1 = Integer.parseInt(submittedCards[0])-1;
        trio.setCard1(listOfPiles.get(chosenPile1).returnTopCard());
        int chosenPile2 = Integer.parseInt(submittedCards[1])-1;
        trio.setCard2(listOfPiles.get(chosenPile2).returnTopCard());
        int chosenPile3 = Integer.parseInt(submittedCards[2])-1;
        trio.setCard3(listOfPiles.get(chosenPile3).returnTopCard());

        textAreaIsASet.setText(submission);

        boolean isASet = trio.isASet();

        if (isASet){
            numberOfSetsFound += 1;
            labelNumSetsFound.setText(String.valueOf(numberOfSetsFound));
            // remove cards from trio - may not be necessary due to function resetting after each ENTER
            trio.clear();
            // remove cards from arena
            listOfPiles.get(chosenPile1).removeTopCard(); // does removing actually visually remove?
            listOfPiles.get(chosenPile2).removeTopCard();
            listOfPiles.get(chosenPile3).removeTopCard();

            listOfPileVisuals.get(chosenPile1).remove(listOfPileVisuals.get(chosenPile1).size()-1);
            listOfPileVisuals.get(chosenPile2).remove(listOfPileVisuals.get(chosenPile2).size()-1);
            listOfPileVisuals.get(chosenPile3).remove(listOfPileVisuals.get(chosenPile3).size()-1);
            
            listOfImageViewPiles.get(chosenPile1).setImage(listOfPileVisuals.get(chosenPile1).get(listOfPileVisuals.get(chosenPile1).size()-1));
            listOfImageViewPiles.get(chosenPile2).setImage(listOfPileVisuals.get(chosenPile2).get(listOfPileVisuals.get(chosenPile2).size()-1));
            listOfImageViewPiles.get(chosenPile3).setImage(listOfPileVisuals.get(chosenPile3).get(listOfPileVisuals.get(chosenPile3).size()-1));

            textAreaIsASet.setText("SET!");

        }
        else{
            textAreaIsASet.setText("Try again...");
        }
        
    }

}
package com.predictor;


//import java.util.ArrayList;

public class Card {

    String suit = "";
    int pip  = 0;


    public Card ( String suit, int pip)
    {
        this.suit = suit;
        this.pip = pip;
    }
    public String getter(int pip )
    {
        switch (pip) {
            case 0:
                return "Joker";
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default :
                return pip + "";
        }

    }
    public void compareCard(Card c1)
    {
        if(this.suit.equals(c1.suit) && this.pip > c1.pip )
        {
            int temp = 0;
            temp = this.pip;
            this.pip = c1.pip;
            c1.pip = temp;
        }

    }
}



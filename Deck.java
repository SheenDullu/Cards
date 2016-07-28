package com.predictor;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Pack> deck = null;
    ArrayList<Card> shuffle = null;
    Deck(int noOfPacks) {
        this.deck = new ArrayList<Pack>();
        for(int i=0; i< noOfPacks;i++)
            this.deck.add(new Pack());

    }
    public void shuffle() {
        Random random = new Random ();
        ArrayList<Card> cards = new ArrayList<>();
       this.shuffle = new ArrayList<>();
        for(Pack pack:this.deck)
            for(Card card: pack.pack) {
            cards.add(card);
               // System.out.println(card.suit+" "+card.pip);

            }
        int maxCard = cards.size();
            for(int i = 0; i < maxCard;i++)
            {
                int j = random.nextInt(cards.size());
                this.shuffle.add(cards.get(j));
                cards.remove(j);
            }


    }

}

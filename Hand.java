package com.predictor;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    Deck deck = null;
    Card []playerCard = null;
    Hand(){
        this.deck = new Deck(1);
        this.deck.shuffle();
        this.playerCard = new Card[5];
        int i = 0;


        for (Card c : this.deck.shuffle) {



                if(i == 5)
                    break;
                this.playerCard[i] = c;
              //  this.deck.shuffle.remove(i*5+j+1);*/
                i++;

            }
    }
    public void chooseBestCombination() {
        int [] bestComb = new int[5];
        int i = 0;
        for(Card c:this.playerCard) {
            bestComb[i] =c.pip;
            i++;
        }
        Arrays.sort(bestComb);
        if(isStraight(bestComb)) {
            System.out.println("Straight possible");
        }
    }

    private boolean isStraight(int[] bestComb) {
       
        return false;
    }

    public static void main(String[] args) {
         Hand hand = new Hand();
            for(int i = 0; i < 5;i++) {

                    System.out.print(hand.playerCard[i].suit+" "+hand.playerCard[i].getter(hand.playerCard[i].pip) + "   ");


            }
        hand.chooseBestCombination();
    }
}

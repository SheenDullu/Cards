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
        if(isFourOfAKind(bestComb)) {
            System.out.println("Four of a kind");
        }
        else if(isRoyalFlush(bestComb)) {
            System.out.println("Royal Flush");
        }
    }
    private boolean isStraightFlush(int[] bestComb) {

        return bestComb[0]==9 && bestComb[1]==10 && bestComb[2]==11 && bestComb[3]==12 && bestComb[4]==13;
    }
    private boolean isFourOfAKind(int[] bestComb) {

       return ((bestComb[1]==bestComb[2]) &&(bestComb[2]==bestComb[3])&&((bestComb[0]==bestComb[1])||(bestComb[4]==bestComb[3])));
    }

    private boolean isRoyalFlush(int[] bestComb) {

        return bestComb[0]==1 && bestComb[1]==10&& bestComb[2]==11 && bestComb[3]==12 && bestComb[4]==13;
    }

    public static void main(String[] args) {
         Hand hand = new Hand();
            for(int i = 0; i < 5;i++) {

                    System.out.print(hand.playerCard[i].suit+" "+hand.playerCard[i].getter(hand.playerCard[i].pip) + "   ");


            }
        hand.chooseBestCombination();
    }
}

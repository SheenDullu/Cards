package com.predictor;

//import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    Deck deck = null;
    Card []playerCard = null;

    Hand(){
        this.deck = new Deck(1);
        this.deck.shuffle();

        // this.playerCard = new Card[]{ new Card ("Clubs",8),new Card ("Clubs",10),new Card ("Clubs",9),new Card ("Clubs",11),new Card ("Clubs",12)};
      // this.playerCard = new Card[]{ new Card ("Clubs",10),new Card ("Clubs",11),new Card ("Clubs",12),new Card ("Clubs",13),new Card ("Clubs",1)};
      //    this.playerCard = new Card[]{ new Card ("Clubs",8),new Card ("Clubs",9),new Card ("Clubs",9),new Card ("Clubs",9),new Card ("Clubs",12)};
     //  this.playerCard = new Card[]{ new Card ("Clubs",8),new Card ("Clubs",9),new Card ("Clubs",10),new Card ("Clubs",11),new Card ("Clubs",12)};
        this.playerCard = new Card[]{ new Card ("Clubs",8),new Card ("Clubs",9),new Card ("Clubs",10),new Card ("Clubs",11),new Card ("Clubs",12)};
        int i = 0;


        for (Card c : this.deck.shuffle) {



            if(i == 5)
                break;
       //     this.playerCard[i] = c;
       //     this.deck.shuffle.remove(i*5+j+1);
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

        if(isRoyalFlush(bestComb, this.playerCard)) {
            System.out.println("Royal Flush");
        }
        else if(isStraightFlush(bestComb,this.playerCard)) {
            System.out.println("Straight Flush");
        }
        else if(isFourOfAKind(bestComb)) {
            System.out.println("Four Of A Kind");
        }
        else if(isFullHouse(bestComb)) {
            System.out.println("Full House");
        }
        else if(isFlush(this.playerCard)) {
            System.out.println("Flush");
        }
        else if(isStraight(bestComb)) {
            System.out.println("Straight");
        }
        else if(isThreeOfAKind(bestComb)) {
            System.out.println("Three of A KInd");
        }
        else if(isTwoPair(bestComb)) {
            System.out.println("Two of pair");
        }
        else if(isOnePair(bestComb)) {
            System.out.println("one pair");
        } else{
            System.out.println("High Card");
        }


    }

    private boolean isFlush(Card[] playerCard) {
        String match="";
        int cnt = 0;
        for(Card c:playerCard) {
            if(match.equals("")) {
                match = c.suit;
            }
            if(c.suit.equals(match)) {
                cnt++;
            }
        }
        return cnt == 5;
    }

    private boolean isStraightFlush(int[] bestComb, Card[] playerCard) {
        String match="";
        int cnt = 0;
        for(Card c:playerCard) {
            if(match.equals("")) {
                match = c.suit;
            }
            if(c.suit.equals(match)) {
                cnt++;
            }
        }


        return cnt == 5 && bestComb[4]-bestComb[0] == 4 ;
    }

    private boolean isFourOfAKind(int[] bestComb) {

       return ((bestComb[1]==bestComb[2]) &&(bestComb[2]==bestComb[3])&&((bestComb[0]==bestComb[1])||(bestComb[4]==bestComb[3])));
    }
    private boolean isThreeOfAKind(int[] bestComb ) {
        for (int i = 0; i< bestComb.length - 2; i++) {
            if(bestComb[i]== bestComb[i+1] && bestComb[i+1]== bestComb[i+2])
                return true;
        }
        return false;
    }

    private boolean isFullHouse(int[] bestComb) {

        return ((bestComb[0]==bestComb[1]) &&(bestComb[3]==bestComb[4])&& ((bestComb[1]==bestComb[2])||(bestComb[2]==bestComb[3])));
    }

    private boolean isRoyalFlush(int[] bestComb, Card[] playerCard) {
        String match="";
        int cnt = 0;
        for(Card c:playerCard) {
            if(match.equals("")) {
                match = c.suit;
            }
            if(c.suit.equals(match)) {
                cnt++;
            }
        }

        return cnt == 5 && bestComb[0]==1 && bestComb[1]==10&& bestComb[2]==11 && bestComb[3]==12 && bestComb[4]==13;
    }


         private  boolean isTwoPair (int []  bestComb){
             int flg = 0;
             for(int i = 0; i < bestComb.length-1; i++) {
                 if(bestComb[i]== bestComb[i+1]) {
                     i++;
                     flg++;
                 }
             }
             return flg == 2;

     }

    private  boolean isOnePair (int []  bestComb){
        int count = 0;
        for(int i = 0; i<4;i++)
        {
            if (bestComb[i] == bestComb[i+1]) {
                count ++;

            }
        }
        if(count == 1)
            return true;
        return false;
    }
    private  boolean isStraight (int []  bestComb){
        int count = 0;
        for(int i = 0; i<4;i++)
        {
            if (bestComb[i] == (bestComb[i+1]-1)) {
                count ++;

            }
        }
        if(count == 4)
            return true;
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

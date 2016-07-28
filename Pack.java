package com.predictor;

import java.util.ArrayList;

/**
 * Created by dullus on 7/28/2016.
 */
public class Pack {
    ArrayList<Card> pack = null;
    Pack () {

        this.pack = new ArrayList<Card>();
        for (int i = 1; i <14; i++) {
            this.pack.add(new Card("Heart", i ));
        }
        for (int i = 1; i <14; i++) {
            this.pack.add(new Card("Clubs", i ));
        }
        for (int i = 1; i <14; i++) {
            this.pack.add(new Card("Diamonds", i ));
        }
        for (int i = 1; i <14; i++) {
            this.pack.add(new Card("Spades", i ));
        }
    }

}

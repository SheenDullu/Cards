import java.util.ArrayList;

public class PlayingCard {
    public static void main(String [] args) {
        Suit hearts =  new Suit("Hearts", "Red");
        Suit clubs = new Suit("Clubs", "Black");
        Suit spades = new Suit("Spades", "Black");
        Suit diamonds = new Suit("Diamonds", "Red");
        System.out.println(hearts.suitName);

    }


}
class Suit {
    String suitName = "";
    String color = "";
    ArrayList<String> listOfSuitCard = null;
    Suit(String suitName, String color) {
            this.suitName = suitName;
            this.color = color;
            this.listOfSuitCard = new ArrayList<String>();
            this.listOfSuitCard.add("A");
            for(int i = 2; i <11; i++)
            {
                this.listOfSuitCard.add(i+"");
            }
            this.listOfSuitCard.add("J");
            this.listOfSuitCard.add("Q");
            this.listOfSuitCard.add("K");
    }


}

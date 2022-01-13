import sheffield.*;

import java.util.Locale;

public class Order {

  //:::::::::::::Required for Task 2

  static EasyReader keyboard = new EasyReader();

  static Order askForANewThingOrdered() {
      //Fill in the body for Task2 using the keyboard declared above
      MenuItem item =
              MenuItem.called(keyboard.readString(
                      "What do you want? (starter , main , pudding , side , drink or nothing) "));

      if (item == null) return null;
      else {
          double price = keyboard.readDouble("What is the " + item +  "'s price? ");
          return new Order(item, price); //replacing this
      }


  }

  private MenuItem menuItem;
  private int itemsPriceInPence;
  public int getPriceInPence() {  return itemsPriceInPence;  }

  private Order (MenuItem i, double p) {
      this.menuItem = i;
      this.itemsPriceInPence = (int) (p * 100);
     //Fill in this for task 2 to initialize the instance variables above
  }

  public String toString() {
     //I haven't taught you this and you don't need to understand it
     //to use the method.  Don't change it
     return String.format("%-10s%6.2f",menuItem,itemsPriceInPence/100.0);
  }

  //:::::::::::::Required for Task 4

  static Order askForANewThingOrdered(String diner_name) {
      //Fill in the body for Task4 using the keyboard declared above
      MenuItem item =
              MenuItem.called(keyboard.readString("What else would you like " + diner_name + "? "));
      if (item == null) return null;
      else {
          double price = keyboard.readDouble("What is the " + item +  "'s price? ");
          return new Order(item, price);
      }

  }


}

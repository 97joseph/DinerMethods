package diner;

import sheffield.*;

/**
 *
 
 */
public class Diner {

    // :::::::::::::Required for Task 1
    public static void main(String[] args) {
        Diner.createPartyFor(args);
        Diner.takeEveryonesOrder();
        Diner.listEveryonesOrder();
        Diner.getAnotherRound();
        Diner.listEveryonesOrder();
    }

    static Diner[] allTheDiners;

    // Takes in names of the Diners and adds them to "allTheDiners" array
    static void createPartyFor(String[] peoplesNames) {

        Diner[] allTheDiners = new Diner[peoplesNames.length];
        int i = 0; // index counter
        for (String peoplesName : peoplesNames) { // iterates through each arg (each Diner)
            allTheDiners[i] = new Diner(peoplesName); // Adds the Diner to the array
            i++; // increments the index counter
        }

        Diner.allTheDiners = allTheDiners;

    }

    static EasyWriter screen = new EasyWriter();

    static void listAllTheDiners() {
        // This needs a body to do task 1. Using screen declared above
        screen.println("The diners are");
        for (Diner diner : Diner.allTheDiners) { // iterate through the Diner objects stored in all the diners
            screen.println(diner.theDinersName);
        }
    }

    private String theDinersName;
    Order[] thingsOrderedByDiner;

    // constructor
    private Diner(String called) {
        this.theDinersName = called;
        this.thingsOrderedByDiner = new Order[MAX_NUMBER_OF_THINGS_A_DINER_CAN_ORDER];
        // This needs a body to do task 1 and an addition line for task 2
    }

    // :::::::::::::Additionally required for Task 2
    static void takeEveryonesOrder() {
        for (Diner diner : Diner.allTheDiners) { // iterate through the Diner objects stored in all the diners
            diner.askForTheirOrder(); // propagates the thingsOrderedByDiner for the diner
        }
        // This needs a body to do Task 2 and should make use of askForOrder
    }

    static final int MAX_NUMBER_OF_THINGS_A_DINER_CAN_ORDER = 10;

    private void askForTheirOrder() {
        // This is also required for task 2
        screen.println("Time for " + theDinersName + " to order");
        // Fill in the rest of the method.
        // You should use thingsOrderedByDiner (declared above) and
        // Order.askForNewThingOrdered()
        // Upto here
        int i = 0; // index counter for while loop
        Order order;
        do {
            order = Order.askForANewThingOrdered();
            thingsOrderedByDiner[i] = order;
            i++;
        } while (order != null);

    }

    static void listEveryonesOrder() {
        // This is the second method for task 2
        screen.println("The diners' order is");
        for (Diner diner : Diner.allTheDiners) { // iterate through the Diner objects stored in all the diners
            screen.println("\t" + diner.theDinersName);
            for (Order order : diner.thingsOrderedByDiner) {
                if (order != null) {
                    screen.println("\t \t" + order.toString());
                }
            }
            // Fill in the rest of the method.
            // It should use printOrder() below
            // Upto here
            screen.println();
        }
    }

    private void printOrder() {
        // This is also part of task 2. You can use the constant spaces
        // declared below to get a nice tidy layout
        // You should use the toString method of the class order
        // without changing it to print out the details of the item ordered
        // If the diner ordered nothing print out "Nothing"
    }

    // :::::::::::::Additionally required for Task 3
    static void dealWithTheBill() {
        // Fill this in for task 3 using screen as above for output
        // and the method getShareOfBill() below which also needs to be
        // filled in
        double total_owed = 0;
        int rounded_total;
        double[] amounts_owed = new double[Diner.allTheDiners.length];

        int i = 0; // index counter for amounts owed array
        for (Diner diner : Diner.allTheDiners) { // iterate through the Diner objects stored in all the diners
            // iterates through the orders adding up each order for each diner
            double unrounded_total = diner.getShareOfBill();
            amounts_owed[i] = unrounded_total;
            total_owed += unrounded_total;
            i++;
        }

        screen.print("The diners \t owe ");
        screen.println(total_owed, 2);
        screen.println("Everyone's debt rounded up is");
        double total_owed_rounded = 0;

        for (int j = 0; j < amounts_owed.length; j++) {

            rounded_total = (int) Math.ceil(amounts_owed[j]);
            total_owed_rounded += rounded_total;
            screen.print(Diner.allTheDiners[j].theDinersName);
            screen.println(" " + rounded_total);
        }

        screen.print("which is too much by ");
        screen.println((total_owed_rounded - total_owed), 2);
    }

    private double getShareOfBill() {
        // Fill this in for task 3 too replacing the line below
        double diner_total = 0;
        // iterates through the orders adding up each order for each diner rounded up ()
        for (Order order : this.thingsOrderedByDiner) {
            if (order != null) {
                diner_total += (double) order.getPriceInPence() / 100.0;
            }
        }
        return diner_total;
    }

    // :::::::::::::Additionally required for Task 4
    static void getAnotherRound() {
        // Fill this in for task 4

        for (Diner diner : Diner.allTheDiners) {

            Order final_order = Order.askForANewThingOrdered(diner.theDinersName);
            // check for room
            boolean full = true;
            for (int i = 0; i < diner.thingsOrderedByDiner.length && full; i++) {
                if (diner.thingsOrderedByDiner[i] == null) { // empty array slot
                    diner.thingsOrderedByDiner[i] = final_order; // adds the new order to the array
                    full = false; // sets the full bool to false as it had something added to it
                }
            }

            if (full && final_order != null) {
                screen.println("sorry maximum order reached unable to take order");
            }

            screen.println();
        }

    }

}

package com.pluralsight;

import java.util.ArrayList;
import java.util.*;

public class SearchInventoryApp {
static Scanner theScanner = new Scanner (System.in);
    public static void main(String[] args) {

        //load products into array list
        ArrayList<Product> inventory = new ArrayList<Product>();


        //Creating a loop to iterate through the Array List
        for(int i = 0; i < inventory.size; i++){
            //Printing everything in the list
            System.out.println(i++ + " " + inventory.get(i));
            System.out.println(getInventory());

    }

//    public static void inventoryMenu(){
//        //Display the Inventory menu
//        System.out.println("=== Inventory Display ===");
//        System.out.println();
//        System.out.println("Press 1 to Display ID");
//        System.out.println("Press 2 to Display Name");
//        System.out.println("Press 3 to Display Price");
//        System.out.println("Press 4 to exit");
//        System.out.println();
//        System.out.println("Please choose an option: ");
//
//
//        int usersChoice = theScanner.nextInt();
//
//        boolean isRunning = true;
//        while(isRunning){
//            case 1:
//                displayId;
//                break;
//            case 2:
//                displayName;
//                break;
//            case 3:
//                displayPrice;
//                break;
//            case 4:
//                System.exit(0);
//
//
//        }
    }

    public static ArrayList<Product> getInventory(){
        //Creating an empty array list
        ArrayList<Product> inventory = new ArrayList<Product>();
        //Add stuff to inventory
        inventory.add(new Product(7777, "Lawn Mower", 89.75));
        inventory.add(new Product(4444, "Nail Gun", 56.99));
        inventory.add(new Product(2222, "Saw", 30.00));
        inventory.add(new Product(1111, "Shovel", 20.00));
        inventory.add(new Product(9999, "Plant Pots", 15.00));

        return inventory;
    }


}

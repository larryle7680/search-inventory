package com.pluralsight;

import java.util.ArrayList;
import java.util.*;

public class SearchInventoryApp {

static Scanner theScanner = new Scanner (System.in);
    public static void main(String[] args) {
        //Calling the getInventory method to put it in inventory
        ArrayList<Product> inventory = getInventory();

        //Header for inventory
        System.out.println("This is what we have in the inventory: ");
        System.out.println();


        //Use a for loop to iterate through the array and print
        for(int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("ID: %d | Name: %s | Price: %.2f\n",p.getProductID(),p.getProductName(),p.getPrice());


        }
    }



    public static void inventoryMenu(){
        //Display the Inventory menu
        System.out.println("=== Inventory Display ===");
        System.out.println();
        System.out.println("Press 1 to Display ID");
        System.out.println("Press 2 to Display Name");
        System.out.println("Press 3 to Display Price");
        System.out.println("Press 4 to exit");
        System.out.println();
        System.out.println("Please choose an option: ");


        int usersChoice = theScanner.nextInt();

        boolean isRunning = true;
        while(isRunning){

            switch(usersChoice){
                case 1:
                    idSearch;
                    break;
                case 2:
                    nameSearch;
                    break;
                case 3:
                    priceSearch;
                    break;
                case 4:
                    isRunning = false;
                default:
                    System.out.println("Invalid choice");
            }

        }

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

    public static ArrayList<Product> idSearch(){

        //Prompt user for the id they are trying to look up and store
        System.out.println("What is the id for your item? ");
    }
}


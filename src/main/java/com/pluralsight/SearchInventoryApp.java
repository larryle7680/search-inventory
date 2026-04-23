package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
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

        //Call the menu
        //Prompt the user
        inventoryMenu();
    }



    public static void inventoryMenu(){
        //Display the Inventory menu
        System.out.println();
        System.out.println("=== Inventory Display ===");
        System.out.println();
        System.out.println("1: List all items");
        System.out.println("2: Search by ID");
        System.out.println("3: Search by Name");
        System.out.println("4. Search by Price Range");
        System.out.println("5. Add items to Inventory");
        System.out.println();
        System.out.println("Please choose an option: ");


        int usersChoice = theScanner.nextInt();

        boolean isRunning = true;
        while(isRunning){

            switch(usersChoice){
                case 1:
                    //allItems();
                    break;
                case 2:
                    idSearch();
                    break;
                case 3:
                    nameSearch();
                    break;
                case 4:
                    priceSearch();
                    break;
                case 5:
                    addInventory(isRunning);
                    break;
                case 6:
                    System.exit(0);
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

    //ID SEARCH METHOD
    public static void idSearch(){
        //Setting Variables
        boolean found = false;
        ArrayList<Product> inventory = getInventory();


        //Using a while loop to prompt user the questions
            while (!found){
                System.out.print("Please input your item ID: ");
                int searchId = theScanner.nextInt();

                //Use a for loop to iterate through the array and print
                for(int i = 0; i < inventory.size(); i++) {
                Product p = inventory.get(i);
                if(searchId == p.getProductID()){
                    System.out.println();
                    System.out.println("Your ID matches this item:");
                    System.out.println(p.getProductID() + " | " + p.getProductName() + " | " + p.getPrice());

                }
                }
                }

    }
    //NAME SEARCH METHOD
    public static void nameSearch(){
        //Setting Variables
        boolean found = false;
        ArrayList<Product> inventory = getInventory();


        //Using a while loop to prompt user the questions
        while (!found){
            theScanner.nextLine();
            System.out.print("Please input your item Name: ");
            String searchId = theScanner.nextLine();

            //Use a for loop to iterate through the array and print
            for(int i = 0; i < inventory.size(); i++) {
                Product p = inventory.get(i);
                if(searchId.equalsIgnoreCase(p.getProductName()) ){
                    System.out.println();
                    System.out.println("Your name input matches this item:");
                    System.out.println(p.getProductID() + " | " + p.getProductName() + " | " + p.getPrice());

                }
            }
        }

    }
    //PRICE SEARCH METHOD
    public static void priceSearch(){
        //Setting Variables
        boolean found = false;
        ArrayList<Product> inventory = getInventory();


        //Using a while loop to prompt user the questions
        while (!found){
            System.out.print("Please input your item price minimum: ");
            double searchPriceMin = theScanner.nextDouble();
            System.out.println();
            System.out.println("Please input your item price maximum: ");
            double searchPriceMax = theScanner.nextDouble();


            //Use a for loop to iterate through the array and print
            for(int i = 0; i < inventory.size(); i++) {
                Product p = inventory.get(i);
                if(p.getPrice() >= searchPriceMin && p.getPrice() <= searchPriceMax ){
                    System.out.println();
                    System.out.println("These are the items that are within the range: ");
                    System.out.println(p.getProductID() + " | " + p.getProductName() + " | " + p.getPrice());



                }
            }
        }

    }
    //ADD ITEMS METHOD
    public static void addInventory( boolean isRunning){
        ArrayList<Product> inventory = getInventory();
        //Inventory menu prompt user to fill out the questions and store to add new items.
        System.out.println("=== Adding Inventory ===");
        System.out.println();
        System.out.println("What is the item ID?");
        int addItemId = theScanner.nextInt();

        //Eat line
        theScanner.nextLine();

        System.out.println("What is the name of the item?");
        String addItemName = theScanner.nextLine();
        System.out.println("What is the price of the item?");
        double addItemPrice = theScanner.nextDouble();

        try {
            FileWriter fileWriter = new FileWriter("src/main/inventory.csv");
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            Product addInventoryItems = new Product(addItemId,addItemName,addItemPrice);

            bufWriter.write(addInventoryItems.getProductID() + "|" + addInventoryItems.getProductName() + "|" + addInventoryItems.getPrice() + true);

            bufWriter.close();
            System.out.println();
            System.out.println("You added: " + "ID: " + addInventoryItems.getProductID() + " Name: " + addInventoryItems.getProductName() + " Price: " + addInventoryItems.getPrice());
            System.out.println();
            //Close the menu
            isRunning = false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }





    }



}




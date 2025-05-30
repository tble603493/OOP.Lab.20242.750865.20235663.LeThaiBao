package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Already Exist!");
        } else {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(media);
                System.out.println("Added to cart.");
            } else {
                System.out.println("Cart is full. Cannot add more items.");
            }
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart");
        } else {
            System.out.println("Do not found in cart");
        }
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Current items in the cart:");
            for (Media x : itemsOrdered) {
                System.out.println(x.toString());
            }
        }
    }

    public void print() {
        System.out.println("****************************** Cart ******************************");
        System.out.println("Ordered Items:");

        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Media x : itemsOrdered) {
                String type = "Media";
                if (x instanceof DigitalVideoDisc) {
                    type = "DVD";
                } else if (x instanceof Book) {
                    type = "Book";
                } else if (x instanceof CompactDisc) {
                    type = "CD";
                }

                System.out.print(x.getId() + ". " + type + " - ");
                System.out.println(x.toString());
            }
        }

        System.out.printf("Total cost: %.2f$\n", this.totalCost());
        System.out.println("******************************************************************");
    }

    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter media title to search: ");
        String title = sc.nextLine().trim();

        boolean found = false;
        for (Media x : itemsOrdered) {
            if (x.getTitle().equalsIgnoreCase(title)) {
                System.out.println(x.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Media with title \"" + title + "\" does not exist in the cart.");
        }
    }
    
    public Media search(String title) {
        for (Media x : itemsOrdered) {
            if (x.getTitle().equalsIgnoreCase(title)) {
                return x;
            }
        }

        return null;
    }

    public void searchByID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter media ID to search: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Media x : itemsOrdered) {
            if (x.getId() == id) {
                System.out.println(x.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Media with ID " + id + " does not exist in the cart.");
        }
    }

    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title then cost.");
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by cost then title.");
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart is now empty. Order placed.");
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
} 

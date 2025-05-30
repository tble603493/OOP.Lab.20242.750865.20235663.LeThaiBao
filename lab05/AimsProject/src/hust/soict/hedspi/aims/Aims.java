package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Store store = new Store();
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Media book = new Book("Java Programming", "Education", 15.5f);
        Media dvd = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
        Media anotherDvd = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 21.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(anotherDvd);

        Cart cart = new Cart();
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    cartMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Scanner scanner) {
        store.displayStore();
        int choice;

        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media);
                        mediaDetailsMenu(scanner, media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter title to add to cart: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to play: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                        ((Disc) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        int choice;

        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                        ((Disc) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void updateStore(Scanner scanner) {
    	int choice;
    	do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to store");
            System.out.println("2. Remove from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                	Book book = new Book("Book A", "Education", 10.5f,"Leonardo Davinci");
            		DigitalVideoDisc DVD = new DigitalVideoDisc("Movie A", "Action", "John Wick", 120, 15.0f);
            		CompactDisc CD = new CompactDisc("CD A", "Music", 12.0f, "Taylor Swift");
                    store.addMedia(book);
                    store.addMedia(DVD);
                    store.addMedia(CD);
                    break;
                case 2:
                    String title = scanner.nextLine();
                    Media check = store.searchByTitle(title);
                    store.removeMedia(check);
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
	
    

    public static void cartMenu(Scanner scanner) {
        int choice;

        do {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.search();
                    cart.searchByID();
                    break;
                case 2:
                    System.out.println("1. Sort by title");
                    System.out.println("2. Sort by cost");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if(sortChoice == 1) {
                    	cart.sortByTitleThenCost();
                    }else {
                    	cart.sortByCostThenTitle();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media media = cart.search(title);
                    if (media != null) cart.removeMedia(media);
                    else System.out.println("Not found");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    title = scanner.nextLine();
                    media = cart.search(title);
                    if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
                        ((Disc) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 5:
                    System.out.println("Order placed! Clearing cart...");
                    cart.clear();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
} 

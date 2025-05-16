package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Scanner;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Book;
import java.util.Collections;
import java.util.Comparator;

public class Store {

    private ArrayList<Media> store = new ArrayList<>();

    // Thêm media vào store
    public void addMedia(Media media) {
        if (store.contains(media)) {
            System.out.println("Media already exists in the store: " + media.getTitle());
        } else {
            store.add(media);
            System.out.println("Added to store: " + media.getTitle());
        }
    }

    // Xóa media khỏi store
    public void removeMedia(Media media) {
        if (!store.contains(media)) {
            System.out.println("Media not found in the store: " + media.getTitle());
        } else {
            store.remove(media);
            System.out.println("Removed from store: " + media.getTitle());
        }
    }

    // In thông tin các media trong store
    public void displayStore() {
        System.out.println("************ STORE ************");
        int cnt = 1;
        for (Media media : store) {
            String type = "Media";
            if (media instanceof DigitalVideoDisc) {
                type = "DVD";
            } else if (media instanceof CompactDisc) {
                type = "CD";
            } else if (media instanceof Book) {
                type = "Book";
            }
            System.out.println(cnt + ". " + type + " - " + media.toString());
            cnt++;
        }
        System.out.println("********************************");
    }

    // Tìm kiếm media theo tiêu đề
    public Media searchByTitle(String title) {

        for (Media media : store) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }

            return null;
    }

    // Lọc media theo ID
    public void filterMediaByID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter media ID to search: ");
        int id = sc.nextInt();

        boolean found = false;
        for (Media media : store) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Media with ID " + id + " not found in the store.");
        }
    }

    // Lọc media theo title
    public void filterMediaByTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title to filter by: ");
        String title = sc.nextLine().trim();

        boolean found = false;
        for (Media media : store) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media with the title \"" + title + "\" found.");
        }
    }

    // Sắp xếp media theo title rồi đến cost
    public void sortByTitleThenCost() {
        Collections.sort(store, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                int titleComparison = m1.getTitle().compareTo(m2.getTitle());
                if (titleComparison == 0) {
                    return Float.compare(m2.getCost(), m1.getCost());
                }
                return titleComparison;
            }
        });
        System.out.println("Store sorted by title and cost.");
    }

    // Sắp xếp media theo cost rồi đến title
    public void sortByCostThenTitle() {
        Collections.sort(store, new Comparator<Media>() {
            @Override
            public int compare(Media m1, Media m2) {
                int costComparison = Float.compare(m2.getCost(), m1.getCost());
                if (costComparison == 0) {
                    return m1.getTitle().compareTo(m2.getTitle());
                }
                return costComparison;
            }
        });
        System.out.println("Store sorted by cost and title.");
    }
    
    public ArrayList<Media> getItemsInStore() {
    	return store;
    }
}

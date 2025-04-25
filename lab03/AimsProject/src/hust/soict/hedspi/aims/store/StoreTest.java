package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class StoreTest {

	public static void main(String[] args) {
		ArrayList<Media> mediaList = new ArrayList<>();
		
		Book book = new Book("Book A", "Education", 10.5f,"Leonardo Davinci");
		DigitalVideoDisc DVD = new DigitalVideoDisc("Movie A", "Action", "John Wick", 120, 15.0f);
		CompactDisc CD = new CompactDisc("CD A", "Music", 12.0f, "Taylor Swift");
		
		mediaList.add(book);
		mediaList.add(DVD);
		mediaList.add(CD);
		book.addAuthor("Nicolas Tela");

		for (Media media : mediaList) {
		    System.out.println(media.toString());
		}
		System.out.println("******************************");
		
		Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
		for (Media media : mediaList) {
		    System.out.println(media.toString());
		}
		System.out.println("******************************");
		
		Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
		for (Media media : mediaList) {
		    System.out.println(media.toString());
		}
		System.out.println("******************************");
		

	}

}

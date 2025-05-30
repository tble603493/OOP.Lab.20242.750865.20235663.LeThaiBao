package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		Book book = new Book("Book A", "Education", 10.5f,"Leonardo Davinci");
		DigitalVideoDisc DVD = new DigitalVideoDisc("Movie A", "Action", "John Wick", 120, 15.0f);
		CompactDisc CD = new CompactDisc("CD A", "Music", 12.0f, "Taylor Swift");
		
		cart.addMedia(book);
		cart.addMedia(DVD);
		cart.addMedia(CD);
		book.addAuthor("Nicolas Tela");
		cart.print();
		
		cart.search();
		
		cart.searchByID();

	}

}

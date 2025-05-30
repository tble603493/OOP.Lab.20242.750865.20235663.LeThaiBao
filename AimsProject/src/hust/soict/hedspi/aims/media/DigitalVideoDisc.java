package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title, "", "", 0, 0);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, "", 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);  
        this.director = director;
        this.length = length;
    }


    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean isMatch(String title) {
        return title.equals(this.title);
    }
    @Override
    public String toString() {
        return "DVD - " + super.toString() + " | Director: " + director + " | Length: " + length;
    }

}
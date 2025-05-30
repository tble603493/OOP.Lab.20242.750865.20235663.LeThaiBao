package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost); 
    }


	public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

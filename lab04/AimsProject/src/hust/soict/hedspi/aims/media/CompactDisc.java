package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category,"",0, cost);  
        this.artist = artist;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (this.tracks.contains(track)) {
            System.out.println("Already Exist!");
        } else {
            this.tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (!this.tracks.contains(track)) {
            System.out.println("Do not Exist!");
        } else {
            this.tracks.remove(track);
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD - " + super.toString() + " | Artist: " + artist + " | Tracks: " + tracks.size() + " tracks";
    }

}
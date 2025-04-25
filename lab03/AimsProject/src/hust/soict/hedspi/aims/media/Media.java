package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media{
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    private static int nbMedia = 0;
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (!(o instanceof Media)) return false; 
        
        Media media = (Media) o;
        return this.title != null && this.title.equals(media.title); 
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Category: " + category + " | Cost: " + cost + "$";
    }
    

}

/*
 * 2025 Freshies
 * Item.java
 * This Java file specifies how data is stored for each item in the app.
 */

import java.nio.file.Path;

public class Item {
    /* Fields */
    private int position;
    private String name;
    private String caption;
    private Path image;
    private int stars;

    /* Constructor */
    public Item(int position, String name, String caption, Path path){
        this.position = position;
        this.name = name;
        this.caption = caption;
        this.image = path;
    }

    /* Methods: Getters */
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getCaption() {
        return caption;
    }

    public Path getImage() {
        return image;
    }

    public int getStars() {
        return stars;
    }

    /* Methods: Setters */
    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setImage(Path image) {
        this.image = image;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

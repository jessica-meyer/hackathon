/*
 * 2025 Freshies
 * myCollection.java
 * This Java file specifies how data is stored for each collection in the app.
 */

import java.nio.file.Path;
import java.util.ArrayList;

public class myCollection {
    /* Fields */
    private string collectionID;
    private string ownerUID;
    private string name;
    private string description;
    private int starCount;
    private Color col1;
    private Color col2;
    private Path icon;
    private ArrayList<Item> items = new ArrayList<Item>();
    /* Fields */

    /* Constructor */
    public myCollection(string ID, string UID, string name, string description, int starCount, Color c1, Color c2, Path icon){
        this.collectionID = ID;
        this.ownerUID = UID;
        this.name = name;
        this.description = description;
        this.starCount = starCount;
        this.col1 = c1;
        this.col2 = c2;
        this.icon = icon;
    }
    /* Methods */
    /**
     * addItem
     * input: Item
     * output: n/a
     * Adds the given item to the items list
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * star
     * input: n/a
     * output: n/a
     * increments the star count by 1
     */
    public void star(){
        this.starCount++;
    }

}

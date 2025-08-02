/*
 * 2025 Freshies
 * myCollection.java
 * This Java file specifies how data is stored for each collection in the app.
 */

package backend;
import java.util.ArrayList;
import android.graphics.Color;


public class MyCollection {
    /* Fields */
    private String collectionID;
    private String ownerUID;
    private String name;
    private String description;
    private int starCount;
    private int col1;
    private int col2;
    private String icon;
    private ArrayList<Item> items = new ArrayList<Item>();
    /* Fields */

    /* Constructor */
    public myCollection(String ID, String UID, String name, String description, String icon){
        this.collectionID = ID;
        this.ownerUID = UID;
        this.name = name;
        this.description = description;
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
     * addItem
     * input: index, item
     * output: n/a
     * adds the given item to the specified location in the items list
     */
    public void addItem(int index, Item item){
        this.items.add(index, item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
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

    /* Methods: Getters */
    public String getCollectionID(){
        return this.collectionID;
    }
    public String getOwnerUID(){
        return this.ownerUID;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public int getStarCount(){
        return this.starCount;
    }
    public int getColor(int index){
        if(index == 1)
            return col1;
        else if(index == 2)
            return col2;
        return null;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }

    /* Methods: Setters */
    public void setCollectionID(String collectionID){
        this.collectionID = collectionID;
    }

    public void setOwnerUID(String ownerUID){
        this.ownerUID = ownerUID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStarCount(int starCount){
        this.starCount = starCount;
    }

    public void setColor(int index, int color){
        if(index == 1)
            this.col1 = color;
        else if(index == 2)
            this.col2 = color;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
}

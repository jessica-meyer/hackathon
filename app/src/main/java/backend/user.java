/*
 * 2025 Freshies
 * user.java
 * This Java file specifies how data is stored for each user in the app.
 */
import java.nio.file.Path;
import java.util.ArrayList;
import java.awt.Color;


public class user {
    /* Fields */
    private String uid;
    private String name;
    private Path avatar;
    private String bio;
    private Color color;
    private ArrayList<String> friends = new ArrayList<String>();
    private ArrayList<myCollection> collections = new ArrayList<myCollection>();
    /* Fields */

    /* Constructor */
    public user(String uid, String name, Path avatar, String bio, Color color){
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.bio = bio;
        this.color = color;
    }

    /* Methods */
    /**
     * addFriend
     * input: String
     * output: n/a
     * Adds the given user id to the friends array
     */
    public void addFriend(String uid){
        friends.add(uid);
    }

    /**
     * addCollection
     * input: String
     * output: n/a
     * Adds the given myCollection object to the collections array
     */
    public void addCollection(myCollection c){
        collections.add(c);
    }

    /* Methods: Getters */
    public String getName(){
        return this.name;
    }
    public String getUid(){
    return this.uid;
    }
    public Path getAvatar(){
        return this.avatar;
    }
    public String getBio(){
        return this.bio;
    }
    public Color getColor(){
        return this.color;
    }
    public ArrayList<String> getFriends(){
        return this.friends;
    }
    public ArrayList<myCollection> getCollections(){
        return this.collections;
    }
}


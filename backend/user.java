/*
 * 2025 Freshies
 * database.java
 * This Java file specifies how data is stored for each user in the app.
 */
import java.nio.file.Path;
import java.util.ArrayList;

public class user {
    /* Fields */
    private string uid;
    private string name;
    private Path avatar;
    private string bio;
    private Color color;
    private ArrayList<String> friends = new ArrayList<String>();
    private ArrayList<myCollection> collections = new ArrayList<myCollection>();
    /* Fields */

    /* Constructor */
    public user(string uid, string name, Path avatar, string bio, Color color){
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.bio = bio;
        this.color = color;
    }

    /* Methods */
    /**
     * addFriend
     * input: string
     * output: n/a
     * Adds the given user id to the friends array
     */
    public void addFriend(string uid){
        friends.add(uid);
    }

    /**
     * addCollection
     * input: string
     * output: n/a
     * Adds the given myCollection object to the collections array
     */
    public void addCollection(myCollection c){
        collections.add(c);
    }

    /* Methods: Getters */
    public string getName(){
        return this.name;
    }
    public Path getAvatar(){
        return this.path;
    }
    public string getBio(){
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


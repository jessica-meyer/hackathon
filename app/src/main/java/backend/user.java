/*
 * 2025 Freshies
 * user.java
 * This Java file specifies how data is stored for each user in the app.
 */

package backend;
import backend.MyCollection;
import backend.Item;
import java.nio.file.Path;
import java.util.ArrayList;


public class user {
    /* Fields */
    private String uid;
    private String name;
    private String avatar;
    private String bio;
    private int color;
    private ArrayList<String> friends;
    private ArrayList<MyCollection> collections;
    /* Fields */

    /* Constructor */
    public user(String uid, String name, String avatar, String bio, int color){
        this.uid = uid;
        this.name = name;
        this.avatar = avatar;
        this.bio = bio;
        this.color = color;
        friends = new ArrayList<String>();
        collections = new ArrayList<MyCollection>();
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
    public void addCollection(MyCollection c){
        collections.add(c);
    }

    /* Methods: Getters */
    public String getName(){
        return this.name;
    }
    public String getUid(){
    return this.uid;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public String getBio(){
        return this.bio;
    }
    public int getColor(){
        return this.color;
    }
    public ArrayList<String> getFriends(){
        return this.friends;
    }
    public ArrayList<MyCollection> getCollections(){
        return this.collections;
    }
}


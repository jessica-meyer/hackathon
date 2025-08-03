package backend;/*
* 2025 Freshies
* Database.java
* This Java file reads data in the backend and converts it to
* user, collection, and item objects.
*/

//Read FILESTRUCTURE.txt for a better understanding of scanner
//Run readAll, then use getters to get info

import android.util.Log;
import android.content.Context;

import static java.sql.DriverManager.println;

import android.util.Log;

import com.example.peek.Friend;
import com.example.peek.R;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class Database {
    /* Fields */
    private final String fileName = "users";
    private static ArrayList<String> collectionIDS = new ArrayList<String>();
    private user thisUser;
    private static ArrayList<user> allUsers;
    private static ArrayList<user> friends;
    private static ArrayList<MyCollection> allCollections;

    /* Constructor */
    public Database(){
        allUsers = new ArrayList<user>();
        friends = new ArrayList<user>();
        allCollections = new ArrayList<MyCollection>();
    }

    /* Getters */
    public user getUser(){
        return thisUser;
    }
    public ArrayList<user> getallUsers(){
        return allUsers;
    }
    public ArrayList<user> getfriends(){
        return friends;
    }
    public ArrayList<MyCollection> getCollections(){
        return allCollections;
    }



    /* Methods */

    public static Friend userToFriend(user u){
        String name = u.getName();
        return new Friend(name,u.getUid(), R.drawable.placeholder, false);
    }
    /**
     * readAll
     * input: n/a
     * output: n/a
     * Reads text files for data and converts to objects; main.
     */
    public void readAll(Context context){
        Log.d("DB_DEBUG", "readAll() called ✅");
        try{
            InputStream is = context.getAssets().open("users");
            Scanner scanner = new Scanner(is);
            Log.d("DB_DEBUG", "ReadAll() created scanner");
            while(scanner.hasNextLine()){
                String uid = scanner.nextLine();
                String name = scanner.nextLine();
                String avatar = scanner.nextLine();
                String bio = scanner.nextLine();
                scanner.nextLine();
                int color = 32;
                user userData = new user(uid, name, avatar, bio, color);
                Log.d("DB_DEBUG", "ReadAll() created user");
                while(!scanner.hasNextInt()){
                    userData.addFriend(scanner.next());
                }
                while(scanner.hasNextInt()){
                    userData.addCollection(readCollection(scanner.nextInt(), context));
                }
                scanner.nextLine();
                Log.d("DB_DEBUG", "User: " + userData.toString());
                allUsers.add(userData);
            }
            scanner.close();
        }catch(Exception e){
            Log.d("DB_DEBUG", e.toString());
        }
    }

    /**
     * readCollection
     * input: collectionID
     * output: collection object
     * Reads collection data and converts to object from text
     */
    public MyCollection readCollection(int collectionID, Context context){
        try{
            Log.d("DB_DEBUG", "readCollection: running");
            InputStream is = context.getAssets().open("collections/"+collectionID);
            Scanner scanner = new Scanner(is);
            String ownerUID = scanner.nextLine();
            String name = scanner.nextLine();
            String description = scanner.nextLine();
            String stringImagePath = scanner.nextLine();
            String imagePath = stringImagePath+"/c.jpg";
            MyCollection thisCollection = new MyCollection(collectionID, ownerUID, name, description,imagePath);
            Log.d("DB_DEBUG", "Collection: " + thisCollection.toString());
            while(scanner.hasNextLine()){
                scanner.nextLine();
                int position = scanner.nextInt();
                scanner.nextLine();
                String itemName = scanner.nextLine();
                scanner.nextLine();

                StringBuilder captionBuilder = new StringBuilder();
                String line;
                // Loop to accomodate multiline captions
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (line.trim().equals("/")) break; // End of caption block
                    captionBuilder.append(line).append("\n");
                }
                String caption = captionBuilder.toString().trim();
                
                scanner.nextLine();
                String itemPath = stringImagePath + "/" + position + ".jpg";
                Item item = new Item(position, itemName, caption, itemPath);
                thisCollection.addItem(item);
            }
            allCollections.add(thisCollection);
            scanner.close();
            return thisCollection;
        }catch(Exception e){
            Log.d("DB_DEBUG", e.toString());
            return null;
        }
    }
}

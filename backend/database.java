/*
* 2025 Freshies
* database.java
* This Java file reads data in the backend and converts it to
* user, collection, and item objects.
*/

//Run readAll, then use getters to get info

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.Color;


public class database {
    /* Fields */
    private String fileName = "users";
    private ArrayList<String> collectionIDS = new ArrayList<String>();
    private user thisUser;
    private ArrayList<user> allUsers = new ArrayList<user>();
    private ArrayList<user> friends = new ArrayList<user>();
    private ArrayList<myCollection> allCollections = new ArrayList<myCollection>();

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
    public ArrayList<myCollection> getCollections(){
        return allCollections;
    }

    /* Methods */
    /**
     * readAll
     * input: n/a
     * output: n/a
     * Reads text files for data and converts to objects; main.
     */
    public void readAll(){
        try{
            File userData = new File(fileName);
            Scanner scanner = new Scanner(userData);
            while(scanner.hasNextLine()){
                String uid = scanner.nextLine();
                String name = scanner.nextLine();
                Path avatar = Paths.get(scanner.nextLine());
                String bio = scanner.nextLine();
                Color color = Color.decode(scanner.nextLine());
                user userData = new user(uid, name, avatar, bio, color);
                while(!scanner.hasNextInt()){
                    userData.addFriend(scanner.next());
                }
                while(scanner.hasNextInt()){
                    userData.addCollection(readCollection(scanner.nextInt()));
                }
                scanner.nextLine();
            }
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * readCollection
     * input: collectionID
     * output: collection object
     * Reads collection data and converts to object from text
     */
    public myCollection readCollection(int collectionID){
        try{
            String path = "collections/";
            File collectionData = new File("collections/" + collectionID);
            Scanner scanner = new Scanner(collectionData);
            String ownerUID = scanner.nextLine();
            String name = scanner.nextLine();
            String description = scanner.nextLine();
            String stringimagePath = scanner.nextLine();
            Path imagePath = Paths.get(stringimagePath);
            myCollection thisCollection = new myCollection(collectionID, ownerUID, name, description,imagePath);
            while(scanner.hasNextLine()){
                scanner.nextLine();
                int position = scanner.nextInt();
                scanner.nextLine();
                String itemName = scanner.nextLine();
                scanner.nextLine();
                String caption = scanner.nextLine();
                scanner.nextLine();
                Path itemPath = Paths.get(stringimagePath + "/" + position + ".jpg");
                Item item = new item(position, itemName, caption, itemPath);
                thisCollection.addItem(item);
            }
            allCollections.add(thisCollection);
            scanner.close();
            return thisCollection;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

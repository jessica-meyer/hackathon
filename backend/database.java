/*
* 2025 Freshies
* database.java
* This Java file reads data in the backend and converts it to
* user, collection, and item objects.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Path;
import java.util.ArrayList;

public class database {
    /* Fields */
    private string fileName = "users";
    private ArrayList<String> collectionIDS = new ArrayList<String();
    private User thisUser;
    private ArrayList<user> allUsers = new ArrayList<user>();
    private ArrayList<user> friends = new ArrayList<user>();

    /* Methods */
    /**
     * readAll
     * input: n/a
     * output: n/a
     * Reads text files for data and converts to objects; main.
     */
    public void readAll(){
        try{
            File userData = new file(fileName);
            Scanner scanner = new scanner(userData);
            while(scanner.hasNextLine()){
                string uid = scanner.next();
                string name = scanner.nextLine();
                Path avatar = Paths.get(scanner.nextLine());
                string bio = scanner.nextLine();
                Color color = Color.decode(scanner.nextLine());
                User user = new user(uid, name, avatar, bio, color);
                while(!scanner.hasNextInt()){
                    user.addFriend(scanner.next);
                }
                while(scanner.hasNextInt()){
                    user.addCollection(readCollection(scanner.nextInt()));
                }
            }
        }catch{
            //do something
        }
    }


    public myCollection readCollection(int collectionID){
        try{
            String path = "collections/"
            File collectionData = new file("collections/" + collectionID);
            Scanner scanner = new scanner(collectionData);
            string ownerUID = scanner.next();
            string name = scanner.next();
            string description = scanner.nextLine();
            string imagePath = scanner.nextLine();
            Path imagePath = Paths.get(imagePath);
            myCollection thisCollection = new myCollection(collectionID, ownerUID, name, description,imagePath);
            while(scanner.hasNextLine()){
                scan.next();
                int position = scan.nextInt();
                string name = scan.nextLine();
                scan.next();
                string caption = scan.nextLine();
                scan.next();
                Path itemPath = Paths.get(imagePath + "/" + position.toString() + ".jpg");
                Item item = new item(position, name, caption, itemPath);
                thisCollection.addItem(item);
            }
            return thisCollection;
        }
    }

    /*
     * @demoUser
        I love peeK
        backend/images/avatars/demouser.jpg
        I'm the first user of peeK!
        #0000FF
        @demoUser2 @grapevine
        12345
     */
}

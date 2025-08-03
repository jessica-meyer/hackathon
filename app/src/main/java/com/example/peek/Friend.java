package com.example.peek;
import backend.user;

public class Friend {
    private String name;
    private String username;
    private int imageResId; // Drawable resource for the image
    private boolean isStarred;

    public Friend(String name, String username, int imageResId, boolean isStarred) {
        this.name = name;
        this.username = username;
        this.imageResId = imageResId;
        this.isStarred = isStarred;
    }

    public static Friend userToFriend(user u){
        String name = u.getName();
        return new Friend(u.getName(),u.getUid(), R.drawable.placeholder, false);
    }

    // Getters and setters...
    public String getName() { return name; }
    public String getUsername() { return username; }
    public int getImageResId() { return imageResId; }
    public boolean isStarred() { return isStarred; }
    public void setStarred(boolean starred) { isStarred = starred; }
}


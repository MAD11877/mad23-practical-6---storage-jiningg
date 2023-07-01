package sg.edu.np.mad.madpractical2;

import java.io.Serializable;

public class User implements Serializable {
    public String userName;

    public String userDescription;

    public int userId;

    public boolean userFollowed;

    public User(String userName, String userDescription, int userId, boolean userFollowed) {
        this.userName = userName;
        this.userDescription = userDescription;
        this.userId = userId;
        this.userFollowed = userFollowed;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isUserFollowed() {
        return userFollowed;
    }

    public void setUserFollowed(boolean userFollowed) {
        this.userFollowed = userFollowed;
    }
}

package com.miu;
import com.miu.dao.UserDao;
import java.io.Serializable;

public class User implements Serializable {

    private static UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1L;
    private int userId;
    private String userName;
    private String password;

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return userId;
    }

    public void setId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", userName='" + userName + "'}";
    }

    public User findByUsername(String userName) {
        System.out.println("finding user by: " + userName);
        User user = userDao.findByUsername(userName);
        return user;
    }

    public User getAuthenticatedUser(String userName, String password) {
        System.out.println("Login requested by: " + userName);
        User user = findByUsername(userName);
        if (user == null) {
            System.out.println("User not found");
            return null;
        }
        if (user.getPassword().equals(password)) {
            System.out.println("Login successful");
            return user;
        } else {
            System.out.println("Invalid username/password, login failed");
            return null;
        }
    }

    public User addUser(String userName, String password) {
        User user = new User(0,userName,password);
        System.out.println("Adding user: " + userName);
        user.setUserName(userName);
        user.setPassword(password);
        userDao.save(user);
        System.out.println("User successfully added");
        return user;
    }
}

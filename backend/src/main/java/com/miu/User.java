package com.miu;

import com.miu.dao.UserDao;

import java.io.Serializable;

public class User implements Serializable {

    private static UserDao userDao = new UserDao();

    private static final long serialVersionUID = 1L;
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + firstName + " " + lastName + "'}";
    }

    public User findByUsername(String username) {
        System.out.println("finding user by: " + username);
        User user = userDao.findByUsername(username);
        return user;
    }

    public User getAuthenticatedUser(String userId, String password) {
        System.out.println("finding user by: " + username);
        User user = userDao.findByUsername(username);
        return user;
    }

    public User login(String username, String password) {
        System.out.println("login requested by: " + username);

        User user = findByUsername(username);
        if (user == null) {
            System.out.println("user is not found");
        }
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            System.out.println("login successful");
        }

        return user;
    }
}

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public User getAuthenticatedUser(String username, String password) {
        System.out.println("Login requested by: " + username);
        User user = findByUsername(username);
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

    public User addUser(String username, String password, String firstName, String lastName) {
        User user = new User();
        System.out.println("Adding user: " + username);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
//        user.setRole();
        userDao.save(user);
        System.out.println("User successfully added");
        return user;
    }
}

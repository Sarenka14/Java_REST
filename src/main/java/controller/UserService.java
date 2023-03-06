package controller;

import model.User;

import java.util.HashMap;

public interface UserService {
    void addUser(User user);
    String getUsers();
    User editUser(User user);
    void deleteUser(String id);
    Boolean userExist(String id);
}
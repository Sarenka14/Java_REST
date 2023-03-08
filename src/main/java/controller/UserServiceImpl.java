package controller;

import com.google.gson.Gson;
import model.User;

import java.util.HashMap;

public class UserServiceImpl implements controller.UserService{
    static Gson gson = new Gson();

    String temp;
    HashMap<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public String getUsers() {
        temp = "";

        users.entrySet().forEach(entry->{
            temp += entry.getKey() + ": " + gson.toJson(entry.getValue(), User.class);
            temp += "\n";
        });
        return temp;
    }

    @Override
    public User editUser(User user) {
        users.put(user.getId(), user);
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public Boolean userExist(String id) {
        return null;
    }
}



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
        });
        return temp;
    }
    @Override
    public String getUsers(String id) {
        return gson.toJson(users.get(id), User.class);
    }

    @Override
    public void editUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    @Override
    public Boolean userExist(String id) {
        return users.get(id) != null;
    }
}






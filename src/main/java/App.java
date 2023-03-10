import static spark.Spark.*;

import com.google.gson.Gson;
import controller.UserServiceImpl;
import spark.Request;
import spark.Response;


import model.User;

public class App {
    static Gson gson = new Gson();
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        port(7777);

        get("/api/users",App::users);

        get("/api/users/:id", App::idUser);

        post("/api/users", App::add);

        put("/api/users", App::editUser);

        options("/api/users/:id", App::ifUserExists);

        delete("/api/users/:id", App::deleteUser);
    }

    private static Object users(Request req, Response res) {
        res.type("application/json");
        return userServiceImpl.getUsers();
    }

    private static Object idUser(Request req, Response res) {
        res.type("application/json");
        return userServiceImpl.getUsers(req.params("id"));
    }

    private static Object add(Request req, Response res) {
        System.out.println(req.body());
        User user = gson.fromJson(req.body(), User.class);
        System.out.println(gson.toJson(user, User.class));
        userServiceImpl.addUser(user);
        res.type("application/json");
        return "dodano: " + gson.toJson(user, User.class);
    }

    private static Object editUser(Request req, Response res) {
        User user = gson.fromJson(req.body(), User.class);
        userServiceImpl.editUser(user);
        res.type("application/json");
        return "Zmieniono usera o id: " + user.getId();
    }

    private static Object ifUserExists(Request req, Response res) {
        if(userServiceImpl.userExist(req.params("id"))){
            return "User istnieje";
        }else{
            return "User nie istnieje";
        }
    }

    private static Object deleteUser(Request req, Response res) {
        userServiceImpl.deleteUser(req.params("id"));
        res.type("application/json");
        return "Usunieto usera o id: " + req.params("id");
    }
}

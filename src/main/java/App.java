import static spark.Spark.*;

import controller.UserServiceImpl;
import spark.Request;
import spark.Response;

public class App {
    static UserServiceImpl useFunctions = new UserServiceImpl();

    public static void main(String[] args) {

        get("/api/users",App::userList);

        get("/api/users/:id", App::idUser);

        post("/api/users/", App::addUser);

        put("/api/users/", App::editUser);

        options("/api/users/:id", App::ifUserExists);

        delete("/api/users/:id", App::deleteUser);
    }

    private static Object userList(Request req, Response res) {
        return "ok";
    }

    private static Object idUser(Request req, Response res) {
        return "ok";
    }

    private static Object addUser(Request req, Response res) {
        return "ok";
    }

    private static Object editUser(Request req, Response res) {
        return "ok";
    }

    private static Object ifUserExists(Request req, Response res) {
        return "ok";
    }

    private static Object deleteUser(Request req, Response res) {
        return "ok";
    }
}
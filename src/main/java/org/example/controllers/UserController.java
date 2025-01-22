package org.example.controllers;

import io.javalin.http.Context;
import org.example.models.UserModel;
import org.example.repositories.UserRepository;

import java.util.Map;

record UserRequest(String fullName, String email,
                   String password, String qualification, String userStatus, int campusID) {
}

record ReturnUserWithoutPassword(String fullName, String email, String userStatus) {
}

public class UserController {
    //    Gets all users based on a specific param
    public static void getAllUsers(Context ctx) throws Exception {
//        Remember, query_param is that ?name=value
        String status = ctx.queryParamAsClass("status", String.class).getOrDefault("TUTOR");
        if (status == null) {
            ctx.status(400);
            return;
        }
        var users = UserRepository.returnUsers(status);
        //    Renders all users in an html
        ctx.render("/index.html", Map.of("tutorUsers", users));

    }

}

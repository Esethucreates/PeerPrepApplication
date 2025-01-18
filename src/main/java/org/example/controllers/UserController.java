package org.example.controllers;

import io.javalin.http.Context;
import org.example.repositories.UserRepository;

import java.util.Map;

public class UserController {
    //    Gets all users based on a specific param
    public static void getAllUsers(Context ctx) throws Exception {
//        Remember, queryparam is that ?name=value
        String status = ctx.queryParamAsClass("status", String.class).getOrDefault("TUTOR");
        if (status == null) {
            ctx.status(400);
            return;
        }
        var users = UserRepository.returnUsers(status);
        ctx.render("/index.html", Map.of("tutorUsers", users));
//        ctx.json(users);
    }

//    Renders all users in an html

}

package org.example.controllers;

import io.javalin.http.Context;
import org.example.models.UserModel;
import org.example.repositories.UserRepository;

import java.util.Map;
record UserRequest (String fullName, String email,
                    String password, String qualification, String userStatus, int campusID){}
record ReturnUserWithoutPassword (String fullName, String email, String userStatus){}
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
// TODO: Create a post function to create user


    public static void createAUser(Context ctx) throws Exception{
//        Validate the param
        UserRequest body = ctx.bodyValidator(UserRequest.class)
                .check(data -> data.password().length() > 6, "password must be greater than six characters")
                .get();
        UserModel user = UserRepository.createUser(body.fullName(), body.email(), body.password(), body.qualification(), body.userStatus(), body.campusID());

        ctx.status(201);
//        TODO: return user without password key
        ReturnUserWithoutPassword parsedUser = new ReturnUserWithoutPassword(user.getFullName(), user.getEmail(), user.getUserStatus());
        ctx.json(parsedUser);
    }

}

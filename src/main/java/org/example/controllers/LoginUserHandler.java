package org.example.controllers;

import io.javalin.http.Context;
import org.example.models.UserModel;
import org.example.repositories.UserRepository;

public class LoginUserHandler {
//    TODO: Create a method that will find the credentials given in database
//    TODO: Create a handler that will identify if the same email has been used
//    TODO: Create a controller that will pass the id of the logged in user.
//     If ID is null then user is not logged return to signup regardless of page accessed

//    TODO: Create methods that will use that id as to access user data
//    TODO: Find a way to do log out. Set the referenced id back to null and redirect back to login page


    //    Render the login page
    public static void renderLoginPage(Context ctx) {
        ctx.render("/login.html");
    }


    public static void authenticateUser(Context ctx) throws Exception {

        String email = ctx.formParamAsClass("email", String.class)
                .check(String::isEmpty, "Enter valid email")
                .get();
        String password = ctx.formParamAsClass("password", String.class)
                .check(String::isEmpty, "Enter valid password")
                .get();


        UserModel user = UserRepository.returnUserByEmailPassword(email, password);
//        TODO: Fix return of null values
//        TODO: Handle null values in their repositories
        if (user.getFullName() == null) {
//            TODO: User was not found!
            ctx.status(404);
            ctx.redirect("/login");
            return;
        }
        ctx.status(201);
        ctx.sessionAttribute("userDetails", user);
        ctx.redirect("/dashboard");
    }

}

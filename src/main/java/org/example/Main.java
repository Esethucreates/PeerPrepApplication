package org.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.example.controllers.*;
import org.example.utilities.RenderEngine;


public class Main {
    public static void main(String[] args) {

        var app = Javalin.create( javalinConfig -> {
            javalinConfig.staticFiles.add("/public", Location.CLASSPATH);
            javalinConfig.fileRenderer(new JavalinThymeleaf(RenderEngine.thymeleafEngine()));
        }).start(1001);

//        Main page endpoint
        app.get("/", ctx -> ctx.render("/index.html"));

//        Sign Up page endpoint
        app.get("/signup", SignUpController::renderSignup);
        app.post("/handleCreation", SignUpController::handleUserCreation);

//        Login page endpoint
        app.get("/login", ctx -> ctx.render("/login.html"));
        app.get("/authenticate", LoginUserHandler::authenticateUser);

//        Dashboard page endpoint
        app.get("/dashboard", DashboardHandler::renderDashboard);

    }



}
package org.example;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.example.controllers.UserController;
import org.example.utilities.RenderEngine;


public class Main {
    public static void main(String[] args) {

        var app = Javalin.create( javalinConfig -> {
            javalinConfig.staticFiles.add("/public", Location.CLASSPATH);
            javalinConfig.fileRenderer(new JavalinThymeleaf(RenderEngine.thymeleafEngine()));
        }).start(1001);
        app.get("/", ctx -> ctx.result("Hello World!"));

        app.get("/users", UserController::getAllUsers);
    }

}
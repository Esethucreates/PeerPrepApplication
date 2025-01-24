package org.example.controllers;

import io.javalin.http.Context;
import org.example.models.UserModel;
import org.example.repositories.CampusRepository;
import org.example.repositories.SubjectRepository;
import org.example.repositories.UserRepository;

import java.util.Map;

public class SignUpController {
    public static void renderSignup(Context ctx) throws Exception {
        var subjectList = SubjectRepository.returnSubjects();
        var campusList = CampusRepository.returnCampuses();

        ctx.render("/signup.html", Map.of("subjectList", subjectList, "campusList", campusList));
    }


    public static void handleUserCreation(Context ctx) throws Exception {
//        Validate the form param
        String fullName = ctx.formParamAsClass("fullName", String.class).get();
        String email = ctx.formParamAsClass("email", String.class).get();
        String password = ctx.formParamAsClass("password", String.class).get();
        int campus = ctx.formParamAsClass("campus", Integer.class).get();
        String module = ctx.formParamAsClass("subject", String.class).get();
        String status = ctx.formParamAsClass("status", String.class).get();

        UserRequest bodyCreation = new UserRequest(fullName, email, password, module, status, campus);



        UserModel user = UserRepository.createUser(bodyCreation.fullName(), bodyCreation.email(), bodyCreation.password(), bodyCreation.qualification(), bodyCreation.userStatus(), bodyCreation.campusID());
        if (user.getFullName() == null) {
            ctx.status(404);
            ctx.redirect("/signup");
            return;
        }
        ctx.status(201);
        ctx.redirect("/dashboard");
    }

}

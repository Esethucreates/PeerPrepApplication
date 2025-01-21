package org.example.controllers;

import io.javalin.http.Context;
import org.example.repositories.CampusRepository;
import org.example.repositories.SubjectRepository;

import java.util.Map;

public class SignUpController {
    public static void renderSignup(Context ctx) throws Exception {
        var subjectList = SubjectRepository.returnSubjects();
        var campusList = CampusRepository.returnCampuses();

        ctx.render("/signup.html", Map.of("subjectList", subjectList, "campusList", campusList));
    }
}

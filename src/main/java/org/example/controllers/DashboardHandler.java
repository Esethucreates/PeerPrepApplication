package org.example.controllers;

import io.javalin.http.Context;
import org.example.repositories.CampusRepository;
import org.example.repositories.SubjectRepository;

import java.util.Map;

public class DashboardHandler {
    public static void renderDashboard(Context ctx) throws Exception {
//        Initializers
        ctx.sessionAttribute("userDetails");
        var campusList = CampusRepository.returnCampuses();

        ctx.render("/dashboard.html", Map.of("campusList", campusList));
    }
}

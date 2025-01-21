package org.example.repositories;

import org.example.models.CampusModel;
import org.example.utilities.DB;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CampusRepository {

    @NotNull
    public static List<CampusModel> returnCampuses() throws Exception {
        var query = "SELECT * FROM campus";

        try (var connection = DB.connection();
             var statement = connection.prepareStatement(query);) {
            var resultSet = statement.executeQuery();
            ArrayList<CampusModel> campuses = new ArrayList<>();
            while (resultSet.next()) {
                var campusID = resultSet.getInt("campusID");
                var campusName = resultSet.getString("campusName");
                var campusImg = resultSet.getString("campusImg");
                campuses.add(new CampusModel(campusID, campusName, campusImg));
            }
            return campuses;
        }
    }
}

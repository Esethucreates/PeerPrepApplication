package org.example.repositories;

import org.example.models.SubjectsModel;
import org.example.utilities.DB;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    @NotNull
    public static List<SubjectsModel> returnSubjects() throws Exception {
        String query = "SELECT * FROM subjects";
        try (var connection = DB.connection();
        var statement = connection.prepareStatement(query);
        var resultSet = statement.executeQuery();) {
            ArrayList<SubjectsModel> subjects = new ArrayList<>();
            while (resultSet.next()) {
                var subjectID = resultSet.getInt("subjectID");
                var subjectName = resultSet.getString("subject_name");
                subjects.add(new SubjectsModel(subjectID, subjectName));
            }
            return subjects;
        }
    }
}

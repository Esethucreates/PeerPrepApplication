package org.example.repositories;

import org.example.models.UserModel;
import org.example.utilities.DB;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    @NotNull
    public static List<UserModel> returnUsers(String userStatus) throws Exception {
        var query = "SELECT * FROM users WHERE userStatus = ?";
        try (var connection = DB.connection();
             var statement = connection.prepareStatement(query);) {
            statement.setString(1, userStatus);
            try (var resultSet = statement.executeQuery();) {
                LinkedList<UserModel> users = new LinkedList<>();
                while (resultSet.next()) {
                    var userID = resultSet.getInt("userID");
                    var fullName = resultSet.getString("fullName");
                    var email = resultSet.getString("email");
                    var password = resultSet.getString("password_hash");
                    var qualification = resultSet.getString("qualification");
                    var statusReturned = resultSet.getString("userStatus");
                    var campusID = resultSet.getInt("campusID");
//                    TODO: Remove returning the password
                    users.add(new UserModel(userID, fullName, email, password, qualification, statusReturned, campusID));
                }
                return users;
            }
        }
    }
// Creating a user
    @NotNull
    @Contract("_, _, _, _, _, _ -> new")
    public static UserModel createUser(String fullName, String email,
                                       String password_hash, String qualification,
                                       String userStatus, int campus) throws Exception {
        var query = "INSERT INTO (fullName, email, password_hash, qualification, userStatus, campus) INTO (?, ?, ?, ?, ?, ?) RETURNING*";

        try (var connection = DB.connection();
        var statement = connection.prepareStatement(query);){
            statement.setString(1, fullName);
            statement.setString(2, email);
//            TODO: hash the password before you insert it

            statement.setString(3, password_hash);
            statement.setString(4, qualification);
            statement.setString(5, userStatus);
            statement.setInt(6, campus);

            try (var resultSet = statement.executeQuery();){
                resultSet.next();
                var id = resultSet.getInt("userID");
//                TODO: Do not return the password
                return new UserModel(id, fullName, email, password_hash, qualification, userStatus, campus);
            }
        }

    }
}
